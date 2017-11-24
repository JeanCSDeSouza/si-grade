package br.com.pm_2017.si_grade.utils;

public enum HtmlConstants {
	SVG_MARKER("${svg}"),
	STUDENT_NAME_PROPERTY("${student.name}"),
	STUDENT_REGISTRY_PROSPERTY("${student.registry}"),
	STUDENT_YEAR_OF_REGISTRY_PROPERTY("${student.yearOfRegistry}"),
	STUDENT_CRA_PROPERTY("${student.cra}"),
	STUDENT_PERIODS_CR_PROPERTY("${student.periodsCr}"),
	JUBILATE_RULE_PROPERTY("${jubilate}"),
	CRA_RULE_PROPERTY("${cra}"),
	GRADUATION_TIME_RULE_PROPERTY("${graduationTime}"),
	INTEGRALIZATION_RULE_PROPERTY("${integralization}"),
	REGISTERED_DISCIPLINES_RULE_PROPERTY("${registeredDisciplines}"),
	INTEGRALIZATION_PLAN_CR_RESPECTED_RULE_PROPERTY("${integralizationPlanCrs}"),
	RULE_FLAG_TRUE("Sim"),
	RULE_FLAG_FALSE("Não"),
	RULE_FLAG_NOT_APPLICABLE("Não se aplica");
	
	private String value; 
	
	HtmlConstants(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
