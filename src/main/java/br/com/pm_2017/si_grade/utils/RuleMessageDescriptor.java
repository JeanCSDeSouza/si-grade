package br.com.pm_2017.si_grade.utils;

public enum RuleMessageDescriptor {
	CRA_MESSAGE("cra"),
	GRADUATION_TIME_MESSAGE("graduationTime"),
	INTEGRALIZATION_PLAN_PERIODS_CR_RESPECTED_MESSAGE("integralizationPlanCrs"),
	INTEGRALIZATION_MESSAGE("integralization"),
	JUBILATE_MESSAGE("jubilate"),
	REGISTERED_DISCIPLINES_MESSAGE("registeredDisciplines"),
	NOT_APPLICABLE("not applicable");
	
	private String value;
	
	RuleMessageDescriptor(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
