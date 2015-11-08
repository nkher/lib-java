package nkher.exception;

public class NodeDoesNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7179469613655720275L;
	
	public NodeDoesNotExistException() {
		super();
	}

	public NodeDoesNotExistException(String message) {
		super(message);
	}

}
