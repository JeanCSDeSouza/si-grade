package br.com.pm_2017.si_grade.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import br.com.pm_2017.si_grade.filters.DisciplineStatus;
import br.com.pm_2017.si_grade.filters.RegexConstants;
import br.com.pm_2017.si_grade.model.Discipline;

public class DisciplineParser {
	public List<Discipline> generateDisciplinesList(List<String> disciplines){
		if(disciplines.isEmpty())
			return null;
		else {
			List<Discipline> listDiscipline = new ArrayList<Discipline>(); 
			disciplines.forEach( 
					(line) ->{	
						Discipline discipline;
						Matcher matcher = RegexConstants.getPdfDisciplineMatcher(line);
						matcher.find();
						if( line.contains( DisciplineStatus.APROVADO.getStatusName() ) 
								| line.contains( DisciplineStatus.DISPENSA_SEM_NOTA.getStatusName() )
								| line.contains( DisciplineStatus.DISPENSA_COM_NOTA.getStatusName() ) ) {
							discipline = new Discipline ( 
									line.substring( matcher.start(), matcher.end() ), 
									true
							);	
						}else {
							discipline = new Discipline ( 
									line.substring( matcher.start(), matcher.end() ), 
									false
							);	
						}
						listDiscipline.add(discipline);
					}
			);
			return listDiscipline;
		}
	}
	
}
