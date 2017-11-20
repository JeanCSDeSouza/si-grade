package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.strategy.Strategy;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.PeriodsDisciplinesCount;

public class GraduationTimeRule implements Strategy{
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
