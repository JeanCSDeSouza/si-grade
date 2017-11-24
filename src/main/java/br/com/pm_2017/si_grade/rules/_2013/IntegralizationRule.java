package br.com.pm_2017.si_grade.rules._2013;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.rules.Rule;
import br.com.pm_2017.si_grade.utils.CurricularGradeConstants;
import br.com.pm_2017.si_grade.utils.RuleMessageDescriptor;
/**
 * Implementation o the IntegralizationRule for the 2013 curriculum
 *
 */
public class IntegralizationRule implements Rule{
	/**
	 * checks if the student has attended more then 12 periods
	 */
	public boolean execute(Student student) {
		if( student.getPeriodsCr().size() >= CurricularGradeConstants.MIN_VALUE_FOR_INTEGRALIZATION_PLAN_UNTIL_2013_2.getValue() )
			return true;
		else
			return false;
	}
	public String getMessage() {
		return RuleMessageDescriptor.NOT_APPLICABLE.getValue();
	}
}
