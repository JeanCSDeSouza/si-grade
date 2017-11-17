package br.com.pm_2017.si_grade.utils;

public enum PdfCharacterRaplacer {
	PDF_DECIMAL_MARKER(','),
	PDF_DECIMAL_MARKER_REPLACER('.');
	
	char value;
	
	PdfCharacterRaplacer(char value){
		this.value = value;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}
}
