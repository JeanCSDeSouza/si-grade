package br.com.pm_2017.si_grade.rules._2014;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.rules.Rule;
import br.com.pm_2017.si_grade.utils.CurricularGradeConstants;
import br.com.pm_2017.si_grade.utils.RuleMessageDescriptor;
/**
 * implements the IntegralizationRule for the 2014 curriculum 
 *
 */
public class IntegralizationRule implements Rule{
	/**
	 * cheks if the student has attended to more than 6 periods
	 */
	public boolean execute(Student student) {
		if( student.numberOfValidPeriods() >= CurricularGradeConstants.MIN_VALUE_FOR_INTEGRALIZATION_PLAN_FROM_2014.getValue() )
			return true;
		else 
			return false;
	}
	public String getMessage() {
		return RuleMessageDescriptor.NOT_APPLICABLE.getValue();
	}
}
