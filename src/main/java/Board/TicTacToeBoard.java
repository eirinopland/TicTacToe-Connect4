package Board;


public class TicTacToeBoard extends Board{
	
	/**
	 * Construct a grid with the given dimensions.
	 * @param width
	 * @param height
	 */
	public TicTacToeBoard(int width, int height) {
		super(width, height);
	}

	public void printBoard() {
		System.out.println("________________");
		for (int row = 0; row < getHeight(); row++) {
			System.out.print("|");
			for (int col = 0; col < getWidth(); col++) {
				System.out.print(" " + cells.get(coordinateToIndex(col, row)).getMarkerSymbol() + " |"); //X skal være elementet i cellen 
			}	
			System.out.println();
			System.out.println("________________");
		}
	}
}
