package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.strategy.Strategy;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.StudentFieldsConstants;
import br.com.pm_2017.si_grade.validation.ValidateStudentCurriculumType;

public class IntegralizationPlanPeriodsCrRespectedRule implements Strategy{
	Strategy curriculumValidator;
	public IntegralizationPlanPeriodsCrRespectedRule(){
		curriculumValidator = new ValidateStudentCurriculumType();
	}
	public boolean execute(Student student) {
		if(student == null)
			throw new StudentException( ExceptionConstants.STUDENT_NULL.getMessage() );
		if( student.getPeriodsCr( ) == null || student.getPeriodsCr( ).isEmpty( ) )
			throw new EmptyCollectionException( ExceptionConstants.STUDENT_CR_LIST_EMPTY.getMessage() );
		if( ( student.getYearOfRegistry() < StudentFieldsConstants.MIN_YEAR_OF_REGISTRY.getValue() ) )
			throw new StudentException(ExceptionConstants.STUDENT_REGISTRY_YEAR_LESS_THAN_LIMIT.getMessage());
		return isIntegralizationPlanPeriodsCrRespected(student);
		
	}
	public boolean isIntegralizationPlanPeriodsCrRespected(Student student) {
		if(curriculumValidator.execute(student)) {
			@SuppressWarnings("unused")
			int value = student.getPeriodsCr().size();
			if(student.getPeriodsCr().size() > 7) {
				for(int i = ( 7 ); i < student.getPeriodsCr().size(); i++) 	
					if(student.getPeriodsCr().get(i) < ((float) 5.0))
						return false;
					return true;
			}	
		}else {
			for(int i = ( 13 - 1 ); i < student.getPeriodsCr().size(); i++)	
				if(student.getPeriodsCr().get(i) < ((float) 5.0))
					return false;
			return true;
		}
		return true;
	}
}
