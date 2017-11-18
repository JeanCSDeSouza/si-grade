package br.com.pm_2017.si_grade.utils;

public enum StudentFieldsConstants {
	REGISTRY_LENGTH(11);
	
	private int value;

	private StudentFieldsConstants(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
