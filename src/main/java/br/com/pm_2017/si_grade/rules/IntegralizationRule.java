package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.RuleMessageDescriptor;
import br.com.pm_2017.si_grade.utils.RulePackagePrefix;
import br.com.pm_2017.si_grade.utils.StudentFieldsConstants;
/**
 * Checks if the student is in need on delivering an integralization plan. 
 * This rule is applied to all the curriculum grades available through reflection. 
 * The reflectedRule class points to the exactly rule hat needs to be instantiated in execution time
 */
public class IntegralizationRule implements Rule{
	ReflectedRule reflected;
	
	public IntegralizationRule() {
		this.reflected = new ReflectedRuleImpl();
	}
	/**
	 * Tests if a student needs to delivery an integralization plan based on the type of curriculum 
	 * he is registered using the appropriate validation class.
	 */
	public boolean execute(Student student) {
		if( ( student.getYearOfRegistry() < StudentFieldsConstants.MIN_YEAR_OF_REGISTRY.getValue() ) )
			throw new StudentException(ExceptionConstants.STUDENT_REGISTRY_YEAR_LESS_THAN_LIMIT.getMessage());
		return reflected.getReflectedRule(student, RulePackagePrefix.INTEGRALIZATION_RULE_CLASS_NAME.getValue()).execute(student);
	}
	public String getMessage() {
		return RuleMessageDescriptor.INTEGRALIZATION_MESSAGE.getValue();
	}
}
