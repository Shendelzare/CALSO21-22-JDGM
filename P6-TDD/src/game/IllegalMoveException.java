package game;

public class IllegalMoveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3186380612037088200L;

	public IllegalMoveException(String errorMessage) {
		super(errorMessage);
	}

}
