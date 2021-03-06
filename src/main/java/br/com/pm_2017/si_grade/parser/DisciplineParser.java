package br.com.pm_2017.si_grade.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.utils.CurricularGradeConstants;
import br.com.pm_2017.si_grade.utils.DisciplineStatus;
import br.com.pm_2017.si_grade.utils.DisciplineCodHelper;
import br.com.pm_2017.si_grade.utils.RegexConstants;

/**
 * Class responsible for disciplines parsing logic
 */
public class DisciplineParser {
	/**
	 * Read the list of disciplines and generates a Map<String, Discipline> where
	 * the string is the cod.
	 * 
	 * @param disciplines
	 *            list filtered from the PDF text
	 * @return map of codes pointing to disciplines
	 */
	public static Map<String, Discipline> generateDisciplinesMap(List<String> disciplines) {
		if (disciplines.isEmpty())
			return null;
		else {
			HashMap<String, Discipline> listDisciplines = new HashMap<String, Discipline>();
			disciplines.forEach((line) -> {
				Discipline discipline;
				Matcher matcher = RegexConstants.getPdfDisciplineMatcher(line);
				if (matcher.find()) {
					// Here is the place where cod id get
					discipline = new Discipline(line.substring(matcher.start(), matcher.end()));
					discipline.attempt();
					if (DisciplineCodHelper.MANDATORY_DISCIPLINES.contains(discipline.getCode()))
						discipline.setType(CurricularGradeConstants.MANDATORY_DISCIPLINE.getValue());
					else if (DisciplineCodHelper.OPTIONAL_DISCIPLINES.contains(discipline.getCode()))
						discipline.setType(CurricularGradeConstants.OPTIONAL_DISCIPLINE.getValue());
					else
						discipline.setType(CurricularGradeConstants.ELECTIVE_DISCIPLINE.getValue());
					if (line.contains(DisciplineStatus.APROVADO.getStatusName())
							| line.contains(DisciplineStatus.DISPENSA_SEM_NOTA.getStatusName())
							| line.contains(DisciplineStatus.DISPENSA_COM_NOTA.getStatusName())) {
						discipline.setSituation(DisciplineStatus.APROVADO.getStatus());
					} else {
						if (line.contains(DisciplineStatus.REPROVADO.getStatusName())
								| line.contains(DisciplineStatus.REPROVADO_SEM_NOTA.getStatusName())) {
							discipline.setSituation(DisciplineStatus.REPROVADO.getStatus());
							discipline.fail();
						} else {
							if (line.contains(DisciplineStatus.MATRICULA.getStatusName())) {
								discipline.setSituation(DisciplineStatus.MATRICULA.getStatus());
							} else {
								if (line.contains(DisciplineStatus.TRANCADO.getStatusName())) {
									discipline.setSituation(DisciplineStatus.REPROVADO.getStatus());
								}
							}
						}
					}
					if (listDisciplines.containsKey(discipline.getCode())) {
						discipline.setTimesAttended(listDisciplines.get(discipline.getCode()).getTimesAttended()
								+ discipline.getTimesAttended());
						listDisciplines.replace(discipline.getCode(), discipline);
					} else {
						listDisciplines.put(discipline.getCode(), discipline);
					}
				}
			});
			return listDisciplines;
		}
	}

}
