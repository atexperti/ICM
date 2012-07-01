package org.icm.token;

/**
 * Exception thrown when a token factory cant be initialized
 */
public class TokenInstantiationException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7875797094496639363L;

	public TokenInstantiationException() {
        super();
    }

    public TokenInstantiationException(String message) {
        super(message);
    }

    public TokenInstantiationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenInstantiationException(Throwable cause) {
        super(cause);
    }
}
