package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.strategy.Strategy;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.PeriodsDisciplinesCount;
/**
 * Checks if a student can fish the graduation in time
 *
 */
public class GraduationTimeRule implements Strategy{
	/**
	 * Counts the amount of disciplines made by a student then compares with the 
	 * amount ( periods the student has multiplied by discipline in each period de-
	 * fined in the grade) he should have attended. 
	 * less
	 * @return True if the student can finish the graduation in time 
	 */
	public boolean execute( Student student ) {
		if(student == null)
			throw new StudentException( ExceptionConstants.STUDENT_NULL.getMessage() );
		if( student.getPeriodsCr( ) == null || student.getPeriodsCr( ).isEmpty( ) )
			throw new EmptyCollectionException( ExceptionConstants.STUDENT_CR_LIST_EMPTY.getMessage() );
		return isGraduationTimeRespected(student);
	}

	public boolean isGraduationTimeRespected(Student student) {
		int periodsAttended = student.getPeriodsCr().size();
		int periodsRemaining = (8 - periodsAttended);
		int remaining = student.remaining();
		if( remaining <= PeriodsDisciplinesCount.countMissingDisciplines(periodsRemaining) )
			return true;
		else 
			return false;
	}
}
