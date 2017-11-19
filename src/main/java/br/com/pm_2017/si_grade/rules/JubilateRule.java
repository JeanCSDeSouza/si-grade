package br.com.pm_2017.si_grade.rules;

import java.util.Map;

import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.DisciplineStatus;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.RuleConstants;

/**
 * Implements the jubilate rule 
 */
public class JubilateRule {

	public boolean isJubilate ( Student student ) {
		if( student.getDisciplines( ).isEmpty( ) || student.getDisciplines( ) == null)
			throw new EmptyCollectionException( ExceptionConstants.STUDENT_MAP_EMPTY.getMessage() );
		return ( isCraLessThanCraLimit( student.getCra( ) ) & isDisciplineFailedMoreThan4Times(student.getDisciplines( ) ) );
	}
	
	/**
	 * Check if the disciplines map has any discipline failed 4 or more times. 
	 * <p>
	 * @param disciplinesAttended
	 * @return True if has a discipline that matches the pattern 
	 */
	private boolean isDisciplineFailedMoreThan4Times ( Map<String, Discipline> disciplinesAttended)  {
		for (Discipline discipline : disciplinesAttended.values()) 
			if(discipline.getTimesFailure() >= 4)
				return true;
		return false;
	}
	/**
	 * Check if the CRA is greater than the limit
	 * <p>
	 * @param studentCra
	 * @return true if CRA grater than RuleConstants.CRA_INFERIOR_LIMIT
	 */
	private boolean isCraLessThanCraLimit ( Float studentCra ) {
		if( studentCra < RuleConstants.CRA_INFERIOR_LIMIT.getValue( ) )
			return true;
		else 
			return false;
	}
}
