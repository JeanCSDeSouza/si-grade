package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.DisciplineCodHelper;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.RuleMessageDescriptor;
import br.com.pm_2017.si_grade.utils.RulePackagePrefix;
import br.com.pm_2017.si_grade.utils.StudentFieldsConstants;

/**
 * If the student has to deliver an integralization plan this rule is than
 * applied to him. This rule checks all the types of curricular grade available
 * through the reflect rule that points to what type of
 * IntegralizationPlanPeriodsCrRespectedRule is necessary at the execution time
 *
 */
public class IntegralizationPlanPeriodsCrRespectedRule implements Rule {
	ReflectedRule reflected;

	public IntegralizationPlanPeriodsCrRespectedRule() {
		this.reflected = new ReflectedRuleImpl();
	}

	/**
	 * Execute the call to the ReflectedRule that then makes reflection in the rule
	 * that applies to the student passed.
	 * 
	 * @param Student
	 * @return true with the rule is applied to the student
	 */
	public boolean execute(Student student) {
		if (student == null)
			throw new StudentException(ExceptionConstants.STUDENT_NULL.getMessage());
		if (student.getPeriodsCr() == null || student.getPeriodsCr().isEmpty())
			throw new EmptyCollectionException(ExceptionConstants.STUDENT_CR_LIST_EMPTY.getMessage());
		if ((student.getYearOfRegistry() < StudentFieldsConstants.MIN_YEAR_OF_REGISTRY.getValue()))
			throw new StudentException(ExceptionConstants.STUDENT_REGISTRY_YEAR_LESS_THAN_LIMIT.getMessage());
		if (student.getDisciplines().containsKey(DisciplineCodHelper.TRANCAMENTO_GERAL)) {
			for (int i = 0; i < student.getDisciplines().get(DisciplineCodHelper.TRANCAMENTO_GERAL)
					.getTimesAttended(); i++)
				student.getPeriodsCr().remove((float) 0.0);
		}
		return reflected
				.getReflectedRule(student, RulePackagePrefix.INTEGRALIZATION_PLAN_PERIODS_CR_RESPECTED_RULE.getValue())
				.execute(student);
	}

	public String getMessage() {
		return RuleMessageDescriptor.INTEGRALIZATION_PLAN_PERIODS_CR_RESPECTED_MESSAGE.getValue();
	}
}
