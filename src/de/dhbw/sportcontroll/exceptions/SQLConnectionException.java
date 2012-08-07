/**
 * 
 */
package de.dhbw.sportcontroll.exceptions;

/**
 * @author schoko
 *
 */
public class SQLConnectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1768070141615777084L;

	/**
	 * 
	 */
	public SQLConnectionException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SQLConnectionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public SQLConnectionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SQLConnectionException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SQLConnectionException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
