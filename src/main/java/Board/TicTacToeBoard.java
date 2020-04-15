package Board;

import Markers.GameMarkers;
import Markers.Markers;
import inf101.v20.lab4.grid.Grid;

public class TicTacToeBoard extends Grid<Markers> {
	public TicTacToeBoard(int width, int height) {
		super(width, height, null);
	}
	
	public void dropMarker(int column, int row, GameMarkers marker) {
		if(column < 0 || column >= getWidth() || row < 0 || row >= getHeight()) {
			throw new IndexOutOfBoundsException();
		}
//		for(int ro = 0; ro < getHeight(); ro++) {
//			for(int col = 0; col < getWidth(); col++) {
//				if(get(col, ro) != null) {
//					continue;
//				}
		get(column, row).setMarker(marker);

	}
	
	public void clearBoard() {
		for(int i = 0; i < cells.size(); i++) {
			cells.set(i, null);
		}
	}
	
	public boolean isTaken(int column, int row) {
		Markers m = get(column, row);
		return m.isFilled();		
	}

	public boolean checkWin(int col, int row) {
		if(checkHorizontal(col, row)) {
			return true;
		}
		if(checkVertical(col, row)) {
			return true;
		}
		if(checkDiagonal(col, row)) {
			return true;
		}
		return false; 
	}
	
	public boolean checkHorizontal(int col, int row) {
		GameMarkers m = get(col, row).getMarker();
		int count = 1; 
		int r = row;
		while ((++r < getWidth()) && (get(col, r).getMarker() == m)) {
			count++; 
		}
		r = row; 
		while ((--r >= 0) && (get(col, r).getMarker() == m)) {
			count++; 
		}
		return count == 3;
	}
	
	public boolean checkVertical(int col, int row) {
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
		return count == 3;
	}
	
	public boolean checkDiagonal(int col, int row) {
		GameMarkers m = get(col, row).getMarker();
		int count = 1;
		int r = row;
		int c = col; 
		while ((++c < getHeight()) && (++r < getWidth()) && (get(c, r).getMarker() == m)) {
			count++; 
		}
		r = row;
		c = col;
		while ((--c >= 0) && (--r >= 0) && (get(c, r).getMarker() == m)) {
			count++; 
		}
		if (count == 3) {
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
		while ((--c >= 0) && (++r < getWidth()) && (get(c, r).getMarker() == m)) {
			count++; 
		}
		return count == 3; 
	}

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
	
	public void printBoard() {
		System.out.println("-------------");
		for (int row = 0; row < getHeight(); row++) {
			System.out.print("| ");
			for (int col = 0; col < getWidth(); col++) {
				System.out.print(cells.get(coordinateToIndex(col, row)).getMarkerSymbol() + " | "); //X skal være elementet i cellen 
			}	
			System.out.println();
			System.out.println("-------------");
		}
	}

	public void initializeBoard() {
		cells.clear();
		for(int i = 0; i < getHeight()*getWidth(); i++) {
			cells.add(new Markers(GameMarkers.SPACE));
		}
		
	}
}
