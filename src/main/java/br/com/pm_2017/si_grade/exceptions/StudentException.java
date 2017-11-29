package br.com.pm_2017.si_grade.exceptions;

/**
 * Marks any problem with student as runtime exception
 *
 */
public class StudentException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1800616277412923483L;
	public StudentException(String msg) {
		super(msg);
	}

	public StudentException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
