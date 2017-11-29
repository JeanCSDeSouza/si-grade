package br.com.pm_2017.si_grade.exceptions;

/**
 * Marks any problem with the pdf as an runtime exception
 */
public class PdfProblemException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4369132438512114407L;

	public PdfProblemException(String msg) {
		super(msg);
	}

	public PdfProblemException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
