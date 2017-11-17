package br.com.pm_2017.si_grade.utils;

public enum DisciplineConstants {
	TOTAL_NUMBER_DISCIPLINES(50);
	
	private int value;

	private DisciplineConstants(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
