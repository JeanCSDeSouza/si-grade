package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.exceptions.StudentNullException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.strategy.Strategy;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.RuleConstants;

public class CraRule implements Strategy{
	
	public boolean CraGreaterThan(Student student){
		if(student == null)
			throw new StudentNullException(ExceptionConstants.STUDENT_NULL.getMessage());
		if(student.getCra() >= RuleConstants.CRA_SUPERIOR_LIMIT.getValue())
			return true;
		else 
			return false;
	}

	@Override
	public boolean execute(Student student) {
		// TODO Auto-generated method stub
		return false;
	}
}
