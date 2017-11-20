package br.com.pm_2017.si_grade.rules._2014;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.strategy.Strategy;

public class IntegralizationPlanPeriodsCrRespectedRule implements Strategy{

	public boolean execute(Student student) {
		if(student.getPeriodsCr().size() > 7) {
			for(int i = ( 7 ); i < student.getPeriodsCr().size(); i++) 	
				if(student.getPeriodsCr().get(i) < ((float) 5.0))
					return false;
		}	
		return true;
	}

}
