package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.strategy.Strategy;

public class IntegralizationRule implements Strategy{
	@Override
	public boolean execute(Student student) {
		// TODO Auto-generated method stub
		if( is2014Applied(student.getYearOfRegistry()) ) {
			
		}else {
			
		}
		return false;
	}
	public boolean is2014Applied(int year) {
		if( year >= 2014 )
			return true;
		else
			return false;
	}


}
