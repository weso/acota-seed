package es.weso.acota.core.exceptions;

/**
 * An exception that occurs while executing Acota
 * @author César Luis Alvargonzález
 */
public class AcotaModelException extends RuntimeException {

	private static final long serialVersionUID = -2568767031496911589L;

	/**
	 * Constructs a new AcotaModelException with the 
	 * specified cause
	 * @param cause the cause
	 */
	public AcotaModelException(Exception cause) {
		super(cause);
	}

	/**
	 * Constructs a new AcotaModelException with 
	 * the specified detail message.
	 * @param message the detail message
	 */
	public AcotaModelException(String message) {
		super(message);
	}

	/**
	 * Constructs a new AcotaModelException with the
	 *  specified detail message and cause.
	 * @param message the detail message
	 * @param cause the cause
	 */
	public AcotaModelException(Exception message, String cause) {
		super(cause, message);
	}
	
}
