package br.com.pm_2017.si_grade.exceptions;
/**
 * Marks the non instantiated state of an student and runtime exception
 *
 */
public class StudentNullException extends RuntimeException{
	private static final long serialVersionUID = -4369132438512114407L;
	
	public StudentNullException(String msg) {
		super(msg);
	}
	public StudentNullException(String msg, Throwable cause) {
		super(msg, cause);
	}
}