package Board;

import Markers.GameMarkers;

public class Connect4Board extends Board{

	/**
	 * Construct a grid with the given dimensions.
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
	 * 
	 * @param col
	 * @return true if a column is full
	 */
	
	public boolean isFull(int col) {
		return get(col, getHeight()-1).getMarker() != GameMarkers.SPACE;
	}
}
