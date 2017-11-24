package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.exceptions.StudentNullException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.RuleFloatConstants;
import br.com.pm_2017.si_grade.utils.RuleMessageDescriptor;
/**
 * Rule to check if the Cr of a student is greater then the constant 
 *  CRA_SUPERIOR_LIMIT.   
 *
 */
public class CraRule implements Rule{
	/**
	 * Checks if the student cr is greater then the constant 
	 * RuleFloatConstants.CRA_SUPERIOR_LIMIT
	 * @param student
	 * @return true if the CRA is grater than the constant
	 */
	public boolean execute(Student student) {
		if(student == null)
			throw new StudentNullException(ExceptionConstants.STUDENT_NULL.getMessage());
		if( craGreaterThan(student) )
			return true;
		else 
			return false;
	}
	
	private boolean craGreaterThan(Student student){
		if(student.getCra() >= RuleFloatConstants.CRA_SUPERIOR_LIMIT.getValue())
			return true;
		else 
			return false;
	}
	public String getMessage() {
		return RuleMessageDescriptor.CRA_MESSAGE.getValue();
	}
}
