package br.com.pm_2017.si_grade.exceptions;

public class PDFIsEncryptedException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4369132438512114407L;
	
	public PDFIsEncryptedException(String msg) {
		super(msg);
	}
	public PDFIsEncryptedException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
