package game;

public class GameInProgressException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3186380612037088200L;

	public GameInProgressException(String errorMessage) {
		super(errorMessage);
	}

}
