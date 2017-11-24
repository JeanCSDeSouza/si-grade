package br.com.pm_2017.si_grade.rules;

import java.util.Map;

import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.RuleFloatConstants;
import br.com.pm_2017.si_grade.utils.RuleMessageDescriptor;

/**
 * Implements the jubilate rule 
 */
public class JubilateRule implements Rule{
	/**
	 * Calls the working method that implements this rule
	 * @return True if the student hit the criteria to be expel
	 */
	public boolean execute(Student student) {
		return isJubilate(student);//True if the student has hit the rock-bottom
	}
	/**
	 * Concentrate the two methods in this class an then return true or false based 
	 * in the previous calls to hasDisciplineFailedMoreThanFailLimit and isCraLessThanCraLimit
	 * that are private members of this class
	 * @param student
	 * @return
	 */
	public boolean isJubilate ( Student student ) {
		if( student.getDisciplines( ) == null || student.getDisciplines( ).isEmpty( ) )
			throw new EmptyCollectionException( ExceptionConstants.STUDENT_MAP_EMPTY.getMessage() );
		return (isCraLessThanCraLimit( student.getCra() ) & hasDisciplineFailedMoreThanFailLimit(student.getDisciplines() ));
	}	
	/**
	 * Check if the disciplines map has any discipline failed 4 or more times. 
	 * <p>
	 * @param disciplinesAttended
	 * @return True if has a discipline that matches the pattern 
	 */
	private boolean hasDisciplineFailedMoreThanFailLimit ( Map<String, Discipline> disciplinesAttended)  {
		for (Discipline discipline : disciplinesAttended.values()) 
			if(discipline.getTimesFailure() >= 4)
				return true;
		return false;
	}
	/**
	 * Check if the CRA is greater than the limit
	 * <p>
	 * @param studentCra
	 * @return true if CRA grater than RuleFloatConstants.CRA_INFERIOR_LIMIT
	 */
	private boolean isCraLessThanCraLimit ( Float studentCra ) {
		if( studentCra < RuleFloatConstants.CRA_INFERIOR_LIMIT.getValue( ) )
			return true;
		else 
			return false;
	}
	public String getMessage() {
		return RuleMessageDescriptor.JUBILATE_MESSAGE.getValue();
	}
}
