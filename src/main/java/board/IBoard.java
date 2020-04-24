package board;

import markers.GameMarkers;

public interface IBoard {
	

	void dropMarker(int col, int row, GameMarkers marker);
	
	/**
	 * Checks if a player has achieved x markers in a row, horizontal, vertical or diagonal. 
	 * @param col
	 * @param row
	 * @return true if a player has won.
	 */
	boolean checkWin(int col, int row);
	
	/**
	 * Checking horizontal win from the location of the last printed marker with the given parameters.
	 * Checks if the cells in horizontal direction contains the same marker as the given cell. 
	 * @param col
	 * @param row
	 * @return
	 */
	
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
	 * @return True if the current cell with the given parameters is already taken.
	 */
	boolean isTaken(int column, int row);
}
