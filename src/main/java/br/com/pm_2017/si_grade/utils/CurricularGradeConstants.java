package br.com.pm_2017.si_grade.utils;

public enum CurricularGradeConstants {
	TOTAL_NUMBER_DISCIPLINES(50),
	MIN_VALUE_FOR_INTEGRALIZATION_PLAN_UNTIL_2013_2(13),
	MIN_VALUE_FOR_INTEGRALIZATION_PLAN_FROM_2014(7);
	
	private int value;

	private CurricularGradeConstants(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
