package board;


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
}
