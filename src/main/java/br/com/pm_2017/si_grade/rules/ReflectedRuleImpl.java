package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.configuration.Configuration;
import br.com.pm_2017.si_grade.configuration.ConfigurationImpl;
import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.RulePackagePrefix;
import br.com.pm_2017.si_grade.utils.StudentFieldsConstants;

/**
 * implements the reflection required to instantiate a rule that is only known
 * if it will be used in execution time
 */
public class ReflectedRuleImpl implements ReflectedRule {
	Configuration configuration;

	public ReflectedRuleImpl() {
		this.configuration = new ConfigurationImpl();
	}

	/**
	 * Generate a class that implements Rule class based on the student year and the
	 * name passed
	 * 
	 * @param student
	 *            A valid student
	 * @param className
	 *            a valid name of an instantiable class.
	 * @return return an implementation of Rule based on the name, null otherwise.
	 */
	public Rule getReflectedRule(Student student, String className) {
		if ((student.getYearOfRegistry() < StudentFieldsConstants.MIN_YEAR_OF_REGISTRY.getValue()))
			throw new StudentException(ExceptionConstants.STUDENT_REGISTRY_YEAR_LESS_THAN_LIMIT.getMessage());
		String replacer = RulePackagePrefix.PACAKGE_PREFIX.getValue();
		replacer = replacer.concat(configuration.getRuleConfigutarion(student.getYearOfRegistry()));
		replacer = replacer.concat(className);
		Rule inExecutionTime = null;
		try {
			Class<?> integralizationRule = Class.forName(replacer);
			inExecutionTime = (Rule) integralizationRule.newInstance();
		} catch (Exception e) {
			e.getMessage();
		}
		return inExecutionTime;
	}
}
