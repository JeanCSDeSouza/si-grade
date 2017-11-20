package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.strategy.Strategy;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.RulePackagePrefix;
import br.com.pm_2017.si_grade.utils.StudentFieldsConstants;

public class IntegralizationPlanPeriodsCrRespectedRule implements Strategy{
	ReflectedRule reflected;
	public IntegralizationPlanPeriodsCrRespectedRule(){
		this.reflected = new ReflectedRuleImpl();
	}
	public boolean execute(Student student) {
		if(student == null)
			throw new StudentException( ExceptionConstants.STUDENT_NULL.getMessage() );
		if( student.getPeriodsCr( ) == null || student.getPeriodsCr( ).isEmpty( ) )
			throw new EmptyCollectionException( ExceptionConstants.STUDENT_CR_LIST_EMPTY.getMessage() );
		if( ( student.getYearOfRegistry() < StudentFieldsConstants.MIN_YEAR_OF_REGISTRY.getValue() ) )
			throw new StudentException(ExceptionConstants.STUDENT_REGISTRY_YEAR_LESS_THAN_LIMIT.getMessage());
		return reflected.getReflectedRule(student, RulePackagePrefix.INTEGRALIZATION_PLAN_PERIODS_CR_RESPECTED_RULE.getValue()).execute(student);
	}
}
