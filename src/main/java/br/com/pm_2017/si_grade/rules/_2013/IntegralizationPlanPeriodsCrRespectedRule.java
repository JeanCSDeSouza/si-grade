package br.com.pm_2017.si_grade.rules._2013;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.rules.Rule;
import br.com.pm_2017.si_grade.utils.CurricularGradeConstants;
import br.com.pm_2017.si_grade.utils.RuleFloatConstants;
import br.com.pm_2017.si_grade.utils.RuleMessageDescriptor;
/**
 * Implementation of the IntegralizationPlanPeriodsCrRespectedRule for the 2013 curriculum
 */
public class IntegralizationPlanPeriodsCrRespectedRule implements Rule{
	/**
	 * checks if the student has more them 12 periods and the periods above the limit 
	 * cr are greater than 5.0 
	 */
	public boolean execute(Student student) {
		if(student.getPeriodsCr().size() >= CurricularGradeConstants.MIN_VALUE_FOR_INTEGRALIZATION_PLAN_UNTIL_2013_2.getValue()) {
			for(int i = ( 13 - 1 ); i < student.getPeriodsCr().size(); i++)	
				if(student.getPeriodsCr().get(i) < RuleFloatConstants.INTEGRALIZATION_PLAN_PERIODS_CR_INFERIOR_LIMIT.getValue())
					return false;
		}
		return true;
	}
	public String getMessage() {
		return RuleMessageDescriptor.NOT_APPLICABLE.getValue();
	}
}
