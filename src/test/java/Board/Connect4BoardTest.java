package Board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Games.Connect4Game;
import Markers.GameMarkers;
import Markers.Markers;

public class Connect4BoardTest {
	Connect4Game game = new Connect4Game(1);
	Connect4Board board = new Connect4Board(7, 6);
	
	@Test
	public void initializeBoardTest() {
		int width = 7;
		int height = 6;
		Connect4Board board1 = new Connect4Board(width, height);
		board1.initializeBoard();
		for (int i = 0; i < (width * height); i++) {
			assertEquals(board1.cells.get(i), GameMarkers.SPACE);
		}
	}
	
	@Test
	public void printBoardTest() {
		board.initializeBoard();
		board.set(4, 3, new Markers(GameMarkers.RED));
		board.set(3, 2, new Markers(GameMarkers.RED));
		board.set(2, 1, new Markers(GameMarkers.RED));
		board.set(1, 0, new Markers(GameMarkers.RED));
		
		board.printBoard();
		
		board.initializeBoard();
		board.dropMarker(1, 2, GameMarkers.YELLOW);
		board.dropMarker(3, 1, GameMarkers.YELLOW);
		board.dropMarker(4, 1, GameMarkers.YELLOW);
		board.dropMarker(4, 4, GameMarkers.YELLOW);
		
		board.printBoard();
		
	}
	
	@Test
	public void dropMarkerTest() {
		board.initializeBoard();
		board.dropMarker(2, 4, GameMarkers.YELLOW);
		board.dropMarker(3, 4, GameMarkers.YELLOW);
		board.dropMarker(4, 4, GameMarkers.YELLOW);
		board.dropMarker(5, 4, GameMarkers.YELLOW);
	
		Markers mark = ((Markers) board.get(2, 4));
		assertEquals(mark.getMarker(), GameMarkers.YELLOW);
		}
		
}


