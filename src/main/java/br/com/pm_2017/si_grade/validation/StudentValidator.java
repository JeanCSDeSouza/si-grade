package br.com.pm_2017.si_grade.validation;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.StudentFieldsConstants;

/**
 * Implements the strategy to validate a student
 * <p>
 */
public class StudentValidator{
	/**
	 * validate the fields of a student
	 * @param student
	 * @return true if has errors
	 */
	public static boolean execute(Student student) {
		if( ( checkStudentNullError(student) ) || ( checkStudentMapError(student) ) || 
				( checkStudentNameError(student) ) || ( checkStudentResitryError(student) ) || 
				( checkStudentPeriodsCrError(student) ) )
			return true;
		else
			return false;
	}
	
	static boolean checkStudentNullError(Student student) {
		if(student == null)
			return true;
		else 
			return false;
	}
	static boolean checkStudentMapError(Student student) {
		if( ( student.getDisciplines() == null ) || ( student.getDisciplines().isEmpty() ) )
			return true;
		else 
			return false;
	}
	static boolean checkStudentNameError(Student student) {
		if( ( student.getName() == null ) || ( student.getName().length() == 0 ) || ( student.getName().isEmpty() ) )
			return true;
		else 
			return false;
	}
	static boolean checkStudentResitryError(Student student) {
		if(  ( student.getRegistry() == null ) || 
				( student.getRegistry().length() != StudentFieldsConstants.REGISTRY_LENGTH.getValue() ) || 
				( student.getRegistry().isEmpty() ) )
			return true;
		else 
			return false;
	}
	static boolean checkStudentPeriodsCrError(Student student) {
		if( ( student.getPeriodsCr() == null ) || ( student.getPeriodsCr().isEmpty() ) || 
				( student.getPeriodsCr().size() == 0 ) )
			return true;
		else
			return false;
	}
}
