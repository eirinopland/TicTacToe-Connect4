package games;

public interface IGame {
	
	/**
	 * Called by main, and runs the game until finished.
	 */
	void startGame();
	
	/**
	 * Goes through the list of players, changing player turns, and interacts with the
	 * game board by adding markers to the board until there is a win or a draw.   
	 */
	void doTurns();
	
}
