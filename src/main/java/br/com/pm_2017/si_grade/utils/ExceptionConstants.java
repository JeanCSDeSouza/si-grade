package br.com.pm_2017.si_grade.utils;

public enum ExceptionConstants {
	STUDENT_MAP_EMPTY("The disciplines map is empty"),
	STUDENT_NULL("The Student class is null"),
	STUDENT_REGISTRY_YEAR_LESS_THAN_LIMIT("The year of registry is bellow limit"),
	STUDENT_CR_LIST_EMPTY("The periodsCr is empty"),
	RULES_CONFIGURATION_LIST("The configuration list for rules is empty"),
	STUDENT_REGISTRY_YEAR_LESS_NOT_RECONIZED("The student year of registry is wrong");
	
	String message;
	
	ExceptionConstants( String message ){
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
