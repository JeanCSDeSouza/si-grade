package br.com.pm_2017.si_grade.utils;

public enum RuleFloatConstants {
	CRA_INFERIOR_LIMIT( ( float ) 4.00),
	CRA_SUPERIOR_LIMIT( ( float ) 7.00),
	INTEGRALIZATION_PLAN_PERIODS_CR_INFERIOR_LIMIT((float) 5.0);
	
	
	private float value;
	
	RuleFloatConstants(Float value) {
		this.value = value;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
}
