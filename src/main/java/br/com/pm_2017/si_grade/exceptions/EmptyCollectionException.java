package br.com.pm_2017.si_grade.exceptions;
/**
 * Marks an empty collection 
 */
public class EmptyCollectionException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4369132438512114407L;
	
	public EmptyCollectionException(String msg) {
		super(msg);
	}
	public EmptyCollectionException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
