package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.strategy.Strategy;

interface ReflectedRule {
	public Strategy getReflectedRule(Student student, String className);
}
