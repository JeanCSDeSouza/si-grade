package br.com.pm_2017.si_grade.validation;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.strategy.Strategy;

public class ValidateStudentCurriculumType implements Strategy{
	
	public boolean execute(Student student) {
		return is2014Applied(student.getYearOfRegistry());
	}
	public boolean is2014Applied(int year) {
		if( year >= 2014 )
			return true;
		else
			return false;
	}
}
