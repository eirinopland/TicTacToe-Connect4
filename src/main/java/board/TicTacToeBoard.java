package board;

import players.IPlayer;

public class TicTacToeBoard extends Board{
	
	/**
	 * Construct a game board with the given dimensions. 
	 * @param width
	 * @param height
	 */
	public TicTacToeBoard(int width, int height) {
		super(width, height);
	}

	/**
	 * Displays the board to the screen. 
	 */
	public void printBoard() {
		System.out.println("________________");
		for (int row = 0; row < getHeight(); row++) { 
			System.out.print("|");
			for (int col = 0; col < getWidth(); col++) { 
				System.out.print(" " + cells.get(coordinateToIndex(col, row)).getMarkerSymbol() + " |"); 
			}	
			System.out.println();
			System.out.println("________________");
		}
	}
	
	/**
	 * Checks if a given column and row is outside the board or taken, or if it is a valid move. 
	 * @param col
	 * @param row
	 * @param player
	 * @return false if it is not a valid move, true if it is a valid move
	 */
	public boolean validMove(int col, int row, IPlayer player) {
		if(col >= getWidth() || col < 0 || row >= getHeight() || row < 0) {
			System.out.println("Not a valid move! Please type row and column number between 1-3.");
			return false; 
		}
		if (isTaken(col, row)) {
			System.out.println("This cell is taken! Please try another one.");
			return false; 
		}
		return !isTaken(col, row);
	}
}
