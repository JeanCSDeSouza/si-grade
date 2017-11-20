package br.com.pm_2017.si_grade.rules._2013;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.strategy.Strategy;
import br.com.pm_2017.si_grade.utils.CurricularGradeConstants;

public class IntegralizationRule implements Strategy{

	public boolean execute(Student student) {
		if( student.getPeriodsCr().size() >= CurricularGradeConstants.MIN_VALUE_FOR_INTEGRALIZATION_PLAN_UNTIL_2013_2.getValue() )
			return true;
		else
			return false;
	}

}
