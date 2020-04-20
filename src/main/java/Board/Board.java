package Board;
import Markers.GameMarkers;
import Markers.Markers;
import inf101.v20.lab4.grid.Grid;

public class Board extends Grid<Markers>{
	
	public Board(int width, int height) {
		super(width, height, null);
	}

	/**
	 * Drop the given marker in a specified column and row. 
	 * @param column
	 * @param row
	 * @param marker
	 */
	public void dropMarker(int column, int row, GameMarkers marker) {
		if(column < 0 || column >= getWidth() || row < 0 || row >= getHeight()) {
			throw new IndexOutOfBoundsException();
		}
		get(column, row).setMarker(marker);
	}
	
	/**
	 * 
	 * @param column
	 * @param row
	 * @return true if the current cell with the given parameters is already taken. 
	 */
	public boolean isTaken(int column, int row) {
		Markers m = get(column, row);
		return m.isFilled();		
	}
	
	/**
	 * Initializing the board by clearing it, and giving each cell a "SPACE" marker.
	 */
	public void initializeBoard() {
		cells.clear();
		for(int i = 0; i < getHeight()*getWidth(); i++) {
			cells.add(new Markers(GameMarkers.SPACE));
		}	
	}
	
	/**
	 * 
	 * @return true if the board is full and there are no available cells left. 
	 */
	public boolean isDraw() {
		for (int col = 0; col < getWidth(); col++) {
			for (int row = 0; row < getHeight(); row++) {
				if (!get(col, row).isFilled()) {
					return false; 
				}
			}
		}
		return true; 
	}
	
	public boolean checkWin(int col, int row, int winCondition) {
		if(checkHorizontal(col, row, winCondition)) {
			return true;
		}
		if(checkVertical(col, row, winCondition)) {
			return true;
		}
		if(checkDiagonal(col, row, winCondition)) {
			return true;
		}
		return false; 
	}

	public boolean checkHorizontal(int col, int row, int winCondition) {
		GameMarkers m = get(col, row).getMarker();
		int count = 1; 
		int r = row;
		while ((++r < getHeight()-1) && (get(col, r).getMarker() == m)) {
			count++; 
		}
		r = row; 
		while ((--r >= 0) && (get(col, r).getMarker() == m)) {
			count++; 
		}
		return count == winCondition;
	}

	public boolean checkVertical(int col, int row, int winCondition) {
		GameMarkers m = get(col, row).getMarker();
		int count = 1;
		int c = col; 
		while ((++c < getHeight()) && (get(c, row).getMarker() == m)) {
			count++; 
		}
		c = col;
		while ((--c >= 0) && (get(c, row).getMarker() == m)) {
			count++; 
		}
		return count == winCondition;
	}

	public boolean checkDiagonal(int col, int row, int winCondition) {
		GameMarkers m = get(col, row).getMarker();
		int count = 1;
		int r = row;
		int c = col; 
		while ((++c < getWidth()) && (++r < getHeight()) && (get(c, r).getMarker() == m)) {
			count++; 
		}
		r = row;
		c = col;
		while ((--c >= 0) && (--r >= 0) && (get(c, r).getMarker() == m)) {
			count++; 
		}
		if (count == winCondition) {
			return true;
		}
		count = 1;
		r = row;
		c = col; 
		while ((++c < getHeight()) && (--r >= 0) && (get(c, r).getMarker() == m)) {
			count++; 
		}
		r = row; 
		c = col; 
		while ((--c >= 0) && (++r < getHeight()) && (get(c, r).getMarker() == m)) {
			count++; 
		}
		return count == winCondition; 
	}
}
