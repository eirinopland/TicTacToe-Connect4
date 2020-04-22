package Board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Games.Connect4Game;
import Markers.GameMarkers;
import Markers.Markers;
import Players.HumanPlayer;
import Players.IPlayer;

public class Connect4BoardTest {
	Connect4Game game = new Connect4Game(1);
	Connect4Board board = new Connect4Board(7, 6);
	IPlayer player = new HumanPlayer(GameMarkers.YELLOW, "Player1");
	
//	@BeforeEach
//	public void setUp() {
//		board = new Connect4Board(7, 6);
//		board.initializeBoard();
//	}
	
	/**
	 * Tests if it is possible to add a marker to an empty board.
	 */
	@Test
	void testAddToEmptyBoard() {
		board.initializeBoard();
		Connect4Board board = new Connect4Board(7,6);
		IPlayer player = new HumanPlayer(GameMarkers.YELLOW, "Player1");
		board.get(4, 3).setMarker(player.getMarker());
		assertEquals(board.get(4, 3), "\ud83d\udfe1");
	}
	
	/**
	 * Tests that we can put a marker in every cell of the board. 
	 */
	@Test
	void testCanPutMarker() {
		board.initializeBoard();
		Connect4Board board = new Connect4Board(7,6);
	}
	
	/**
	 * Tests that it is not possible to put a marker if it is already taken. 
	 */
	@Test
	void testCanNotPlaceMarkerIfTaken() {
		board.initializeBoard();
		board.dropMarker(2, 2, GameMarkers.YELLOW);
		assertEquals(game.validMove(2, player), true);
	}		
	
	
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
	void testInitializing() {
		board.initializeBoard();
		board.dropMarker(2, 3, player.getMarker());
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
	
	@Test
	public void testEmptyBoardIsNotDraw() {
		board.initializeBoard();
		assertFalse(board.isDraw());
	}
	
	@Test
	public void testFullBoardIsDraw() {
		board.initializeBoard(); 
		for (int i = 0; i < board.getWidth(); i++) {
			for (int j = 0; j < board.getHeight(); j++) {
				board.get(i, j).setMarker(GameMarkers.YELLOW);
			}
		}
		assertTrue(board.isDraw());
	}
		
}


