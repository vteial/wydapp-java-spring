package wyd;


public class WydException extends Exception {

	public WydException() {
		super();
	}

	public WydException(String message) {
		super(message);
	}

	public WydException(String message, Throwable throwable) {
		super(message);
	}
}
