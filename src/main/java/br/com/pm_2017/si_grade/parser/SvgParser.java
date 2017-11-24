package br.com.pm_2017.si_grade.parser;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.RegexConstants;

public class SvgParser {
	public static List<String> parseSvgLinesColoring(Student student, List<String> svgLines){
		Map<String, Discipline> disciplines = student.getDisciplines();
		List<String> lines = svgLines;
		for(int i = 0; i < lines.size() -1 ; i++) {
			if(RegexConstants.isDisciplinePath(lines.get(i))) {
				String line = lines.get(i);
				String flag = lines.get(i).substring(14, 21);
				Optional<Discipline> sparring = null;
				if(disciplines.containsKey(flag) ) {
					lines.set(i, paintLine(line, disciplines.get(flag)));
					disciplines.remove(flag);
				}else
					if( (flag.contains("ELETIVA"))) {
						sparring = disciplines.values().stream().filter( discipline -> discipline.getType() == 2).findFirst();
						if(sparring.isPresent()) {
							lines.set(i, paintLine(line, sparring.get()));
							disciplines.remove(sparring.get().getCode());
						}
					}else
						if(flag.contains("OPTATIV")) {
							sparring = disciplines.values().stream().filter( discipline -> discipline.getType() == 1).findFirst();
							if(sparring.isPresent()) {
								lines.set(i, paintLine(line, sparring.get()));
								disciplines.remove(sparring.get().getCode());
							}
						}	
			}
		}
		return lines;
	}
	public static String paintLine(String line, Discipline discipline) {
		String newLine = line;
		if (discipline.getSituation() == 1) {
			newLine = newLine.replace("ffffff", "00FF00");
		} else {
			if (discipline.getSituation() == 0 || ((discipline.getSituation() == -1)
					&& (discipline.getTimesAttended() > 1))) {
				newLine = newLine.replace("ffffff", "FF0000");
			} else if ((discipline.getSituation() == -1)
					&& (discipline.getTimesAttended() == 1)) {
				newLine = newLine.replace("ffffff", "FFFF00");
			}
		}
		return newLine;
	}
}
