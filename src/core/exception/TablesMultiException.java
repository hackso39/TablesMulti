package core.exception;

public class TablesMultiException extends Exception {

	private static final long serialVersionUID = 1L;

	public TablesMultiException() {
		super();
	}

	public TablesMultiException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TablesMultiException(String message, Throwable cause) {
		super(message, cause);
	}

	public TablesMultiException(String message) {
		super(message);
	}

	public TablesMultiException(Throwable cause) {
		super(cause);
	}

}
