/**
 * 
 */
package de.dhbw.sportcontroll.exceptions;

/**
 * @author schoko
 *
 */
public class SQLDriverNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8574064485476893729L;

	/**
	 * 
	 */
	public SQLDriverNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param s
	 */
	public SQLDriverNotFoundException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param s
	 * @param ex
	 */
	public SQLDriverNotFoundException(String s, Throwable ex) {
		super(s, ex);
		// TODO Auto-generated constructor stub
	}

	public SQLDriverNotFoundException(Exception e) {
		super(e);
	}

}
