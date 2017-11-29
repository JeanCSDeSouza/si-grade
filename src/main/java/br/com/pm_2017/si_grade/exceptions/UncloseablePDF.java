package br.com.pm_2017.si_grade.exceptions;
/**
 * Marks the the runtime exception of an uncloseable pdf
 */
public class UncloseablePDF extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 172254030521880960L;
	public UncloseablePDF(String msg) {
		super(msg);
	}
	public UncloseablePDF(String msg, Throwable cause) {
		super(msg, cause);
	}
}
