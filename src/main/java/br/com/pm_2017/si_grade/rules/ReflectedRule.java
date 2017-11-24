package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.model.Student;

interface ReflectedRule {
	public Rule getReflectedRule(Student student, String className);
}
