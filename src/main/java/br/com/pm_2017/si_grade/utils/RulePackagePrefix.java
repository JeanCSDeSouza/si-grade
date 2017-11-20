package br.com.pm_2017.si_grade.utils;

public enum RulePackagePrefix {
	PACAKGE_PREFIX("br.com.pm_2017.si_grade.rules."),
	INTEGRALIZATION_RULE_CLASS_NAME(".IntegralizationRule"),
	INTEGRALIZATION_PLAN_PERIODS_CR_RESPECTED_RULE(".IntegralizationPlanPeriodsCrRespectedRule");
	private String value;
	
	RulePackagePrefix(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
