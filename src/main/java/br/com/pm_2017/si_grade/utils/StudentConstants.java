package br.com.pm_2017.si_grade.utils;

/**
 * Describes the constants for instantiating a student from the PDF 
 * text used by the parse class
 * @author Araragi-san
 */
public enum StudentConstants {
	STUDENT_NAME("Nome Aluno:", 12, -1),
	//The line where this information is, was previously tested having 103 characters 
	STUDENT_CRA( "Coeficiente de Rendimento Geral", 96, 102 ),
	//The student registry is 11 characters long and is 11 characters after the beginning of the String   
	STUDENT_REGISTRY( "Matrícula:", 11, 22 ),
	//The last line hasn't the same length of the rest, then the numbers here are use to subtract from total 
	STUDENT_PERIOD_CR("Coeficiente de Rendimento:", 7, 1);
	
	String value;
	int begin;
	int end;
	
	StudentConstants(String value, int begin, int end){
		this.value = value;
		this.begin = begin;
		this.end = end;
	}

	public String getValue() {
		return value;
	}

	public int getBegin() {
		return begin;
	}

	public int getEnd() {
		return end;
	}
}
