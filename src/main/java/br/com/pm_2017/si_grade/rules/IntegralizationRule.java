package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.strategy.Strategy;
import br.com.pm_2017.si_grade.validation.ValidateStudentCurriculumType;
import br.com.pm_2017.si_grade.utils.CurricularGradeConstants;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.StudentFieldsConstants;

public class IntegralizationRule implements Strategy{
	Strategy curriculumValidator;
	
	public IntegralizationRule() {
		this.curriculumValidator = new ValidateStudentCurriculumType();
	}
	/**
	 * Tests if a student needs to delivery an integralization plan based on the type of curriculum 
	 * he is registered using the appropriate validation class
	 */
	public boolean execute(Student student) {
		if( ( student.getYearOfRegistry() < StudentFieldsConstants.MIN_YEAR_OF_REGISTRY.getValue() ) )
			throw new StudentException(ExceptionConstants.STUDENT_REGISTRY_YEAR_LESS_THAN_LIMIT.getMessage());
		if( curriculumValidator.execute(student) ) {
			if( student.getPeriodsCr().size() >= CurricularGradeConstants.MIN_VALUE_FOR_INTEGRALIZATION_PLAN_FROM_2014.getValue() )
				return true;
		}else {
			if( student.getPeriodsCr().size() >= CurricularGradeConstants.MIN_VALUE_FOR_INTEGRALIZATION_PLAN_UNTIL_2013_2.getValue() )
				return true;
		}
		return false;
	}
}
