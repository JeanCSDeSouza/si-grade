package br.com.pm_2017.si_grade.rules;


import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.exceptions.StudentNullException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.RuleMessageDescriptor;
import br.com.pm_2017.si_grade.utils.StudentFieldsConstants;
/**
 * Checks if a student is registered in more than 3 disciplines. 
 * To do so needs to check if the student has more than 3 disciplines to
 * attend.
 */
public class RegisteredDisciplinesRule implements Rule{
	/**
	 * Checks if a student is attending more than the StudentFieldsConstants.REMAINING_DISCIPLINES_INFERIOR_LIMIT.
	 * <p>
	 * @param Student
	 * @return true if the student is attending more than the inferior limit or is has less than 3 disciplines to 
	 * attend
	 */
	public boolean execute(Student student) {
		if(student == null)
			throw new StudentNullException(ExceptionConstants.STUDENT_NULL.getMessage());

		if(student.getDisciplines().isEmpty()) 
			throw new EmptyCollectionException(ExceptionConstants.STUDENT_MAP_EMPTY.getMessage());
		
		if(hasAtLeast3Remaining(student)) 
			return (student.attending() >= StudentFieldsConstants.REMAINING_DISCIPLINES_INFERIOR_LIMIT.getValue()) ? true : false;
		
		return true;
	}
	/**
	 * Check if the student has more than 3 disciplines to attend
	 * @param student
	 * @return
	 */
	public boolean hasAtLeast3Remaining(Student student) {
		return (student.remaining() >= StudentFieldsConstants.REMAINING_DISCIPLINES_INFERIOR_LIMIT.getValue() ) ? true : false;
	}
	public String getMessage() {
		return RuleMessageDescriptor.REGISTERED_DISCIPLINES_MESSAGE.getValue();
	}
}
