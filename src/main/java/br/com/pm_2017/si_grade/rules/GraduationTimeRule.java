package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.exceptions.StudentNullException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;

public class GraduationTimeRule {
	public boolean inNeedOfIntegralizationPlan(Student student) {
		if(student == null)
			throw new StudentNullException(ExceptionConstants.STUDENT_NULL.getMessage());
		return false;
		//if( student.getResgistry( ).substring( 0 , 3 ) )
	}
}
