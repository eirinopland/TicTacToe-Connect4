package board;

import markers.GameMarkers;
import players.IPlayer;

public class Connect4Board extends Board{
	private GameMarkers marker;

	/**
	 * Construct a game board with the given dimensions. 
	 * @param width
	 * @param height
	 */
	public Connect4Board(int width, int height) {
		super(width, height);
	}
	
	/**
	 * Displays the board to the screen. 
	 */
	public void printBoard() {
		for (int row = getHeight()-1; row >= 0; row--) { //Want the first row to be at the bottom, and then counting upwards. 
			System.out.print("| ");
			for (int col = 0; col < getWidth(); col++) {
				System.out.print(cells.get(coordinateToIndex(col, row)).getMarkerSymbol() + " | ");  
			}	
			System.out.println();
		}
		System.out.println("____________________________________");
	}
	
	/**
	 * Checks if your column input is a valid move, or if it is outside the board. 
	 * @param col
	 * @param player
	 * @return -1 if it is not a valid move, i(row) if it is a valid move
	 */
	public int validMove(int col, IPlayer player) {
		if(col >= getWidth() || col < 0) {
			System.out.println("Not a valid move, please enter a column between 1-7!");
			return -1; 
		}
		if (isFull(col)) {
			System.out.println("Column " + (col+1) + " is full, try another one!");
			return -1;
		}
		for(int i = 0; i < getHeight(); i++) { 
			if (!isTaken(col, i)) {
				get(col, i).setMarker(marker);
				return i; //Get the lowest row(i) available
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @param col
	 * @return true if a column is full
	 */
	public boolean isFull(int col) {
		return get(col, getHeight()-1).getMarker() != GameMarkers.SPACE;
	}
}
