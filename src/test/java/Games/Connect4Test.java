package Games;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Board.Connect4Board;
import Markers.GameMarkers;
import Markers.Markers;

public class Connect4Test {
	private Connect4Game game = new Connect4Game(0);
	Connect4Board board = new Connect4Board(7, 6);
	
	
//	@Test
//	public void checkWinTest() {
//		game.startGame();
//		assertEquals(board.checkWin(board.getWidth(), board.getHeight()), true);
//	}
	
	@Test
	public void horizontalWinTest() {
		board.initializeBoard();
		board.set(3, 4, new Markers(GameMarkers.RED));
		board.set(2, 4, new Markers(GameMarkers.RED));
		board.set(1, 4, new Markers(GameMarkers.RED));
		board.set(0, 4, new Markers(GameMarkers.RED));
		
		assertEquals(board.checkWin(0, 4), true); //Win conditions instead of 4? 
	}
	
	@Test
	public void verticalWinTest() {
		board.initializeBoard();
		board.set(4, 4, new Markers(GameMarkers.RED));
		board.set(4, 3, new Markers(GameMarkers.RED));
		board.set(4, 2, new Markers(GameMarkers.RED));
		board.set(4, 1, new Markers(GameMarkers.RED));
		
		assertEquals(board.checkWin(4, 1), true);
		
		//Three in a row, should return false
		board.initializeBoard();
		board.set(4, 4, new Markers(GameMarkers.RED));
		board.set(4, 3, new Markers(GameMarkers.RED));
		board.set(4, 2, new Markers(GameMarkers.RED));
		
		assertEquals(board.checkWin(4, 2), false);
	}
	
	@Test
	public void diagonalWinTest() {
		board.initializeBoard();
		board.set(0, 4, new Markers(GameMarkers.RED));
		board.set(1, 3, new Markers(GameMarkers.RED));
		board.set(2, 2, new Markers(GameMarkers.RED));
		board.set(3, 1, new Markers(GameMarkers.RED));
		
		assertEquals(board.checkWin(3, 1), true);
		
		board.initializeBoard();
		board.set(4, 4, new Markers(GameMarkers.RED));
		board.set(3, 3, new Markers(GameMarkers.RED));
		board.set(2, 2, new Markers(GameMarkers.RED));
		board.set(1, 1, new Markers(GameMarkers.RED));
		
		assertEquals(board.checkWin(1, 1), true);
	}

}
