package br.com.pm_2017.si_grade.parser;

import br.com.pm_2017.si_grade.exceptions.StudentNullException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;

public class RegistryParser {
	/**
	 * Parse the student registry year from the 4 first characters from the registry
	 * <p>
	 * @param student
	 * @return The year of registry or -1 if has no registry to parse  
	 */
	public static int parseYearFromRegistry( Student student ) {
		if( student == null || student.getRegistry() == null )
			throw new StudentNullException(ExceptionConstants.STUDENT_NULL.getMessage());
		int year = -1;
		if( student.getRegistry().length() < 11 || student.getRegistry().isEmpty() )
			return year;	
		try {
			year = Integer.parseInt( student.getRegistry().substring(0, 4) );
		}catch(NumberFormatException nfe){
			nfe.getMessage();
		}
		return year;
	}
}
