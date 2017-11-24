package br.com.pm_2017.si_grade.rules._2014;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.rules.Rule;
import br.com.pm_2017.si_grade.utils.RuleMessageDescriptor;
/**
 * Implements the IntegralizationPlanPeriodsCrRespectedRule for the 2014 curriculum
 */
public class IntegralizationPlanPeriodsCrRespectedRule implements Rule{
	/**
	 * Checks if the student has attended to more then 7 periods and if the cr of those 
	 * periods are greater than 5.0
	 */
	public boolean execute(Student student) {
		if(student.getPeriodsCr().size() > 7) {
			for(int i = ( 7 ); i < student.getPeriodsCr().size(); i++) 	
				if(student.getPeriodsCr().get(i) < ((float) 5.0))
					return false;
		}	
		return true;
	}
	public String getMessage() {
		return RuleMessageDescriptor.NOT_APPLICABLE.getValue();
	}
}
