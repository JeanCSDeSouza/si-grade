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
		return ( isCraLessThanCraLimit( student.getCra( ) ) & isdisciplineAttendedMoreThanLimit(student.getDisciplines( ) ) );
	}
	
	/**
	 * Check if the disciplines map has any discipline attended more than 4 time. 
	 * Also marks as true disciplines attended 4 times and with reproved status
	 * <p>
	 * @param disciplinesAttended
	 * @return True if has a discipline that matches the pattern 
	 */
	private boolean isdisciplineAttendedMoreThanLimit ( Map<String, Discipline> disciplinesAttended)  {
		boolean answer = false;
		for (Discipline discipline : disciplinesAttended.values( ) )
			if( (discipline.getTimesAttended( ) >= 4 ) ) {
				if( ( ( discipline.getTimesAttended( ) == 4 ) && 
						( discipline.getSituation( ) == DisciplineStatus.REPROVADO.getStatus( ) ) ) 
						|| (discipline.getTimesAttended( ) > 4 )) {
					answer = true;
					break;
				}
			}
		return answer;
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
