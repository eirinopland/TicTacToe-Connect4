package Board;

import Markers.GameMarkers;

public interface IBoard {
	

	void dropMarker(int col, int row, GameMarkers marker);
	
	/**
	 * Checks if a player has won the game
	 * @param col
	 * @param row
	 * @return 
	 */
	boolean checkWin(int col, int row);
	
	boolean checkHorizontal(int col, int row);
	
	boolean checkVertical(int col, int row);
	
	boolean checkDiagonal(int col, int row); 
	
	/**
	 * 
	 * @return True if the board is full and there are no available cells left.
	 */
	boolean isDraw();
	
	/**
	 * Displays the board to the screen.
	 */
	void printBoard();
	
	/**
	 * Initializing the board, clearing it and giving each cell a SPACE marker. 
	 */
	void initializeBoard();
	
	/**
	 * 
	 * @param column
	 * @param row
	 * @return True if the current cell with these parameters is already taken.
	 */
	boolean isTaken(int column, int row);
}
