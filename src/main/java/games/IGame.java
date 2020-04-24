package games;

public interface IGame {
	
	/**
	 * Called by main, and runs the game until finished.
	 */
	void startGame();
	
	/**
	 * Changes players turns, and drops markers until a win or a draw; 
	 */
	void doTurns();
	
}
