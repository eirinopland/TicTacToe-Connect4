package gameTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import board.Connect4Board;
import games.Connect4Game;
import markers.GameMarkers;
import markers.Markers;
import players.HumanPlayer;
import players.IPlayer;

public class Connect4Test {
	Connect4Board board = new Connect4Board(7, 6);
	Connect4Game game = new Connect4Game(0);
	IPlayer player = new HumanPlayer(GameMarkers.RED, "Player1");
	private final int winCondition = 4; 
	
	/**
	 * Tests that there are two players when starting a new game
	 * Checks that there are 7*6 = 42 empty cells when starting a game
	 */
	@Test
	void testStartNewGame() {
		Connect4Game game = new Connect4Game(0);
		assertEquals(game.players.size(), 2);
		Connect4Board board = new Connect4Board(7, 6);
		assertEquals(board.cells.size(), board.getWidth()*board.getHeight());
	}
	
	/**
	 * Tests that putting your marker outside the board is not a valid move. 
	 */
	@Test
	void testNotValidMoveOutsideBoard() {
		Connect4Board board = new Connect4Board(7, 6);
		board.initializeBoard();
		assertEquals(game.validMove(8, player), -1); //-1 means that it is not a valid move 
	}
	
	@Test
	void testNotValidMoveFullColumn() {
		
	}
	
	/**
	 * Tests that three in a row is not a win. 
	 */
	@Test
	void testNotAWin() {
		board.initializeBoard();
		board.set(4, 4, new Markers(GameMarkers.RED));
		board.set(4, 3, new Markers(GameMarkers.RED));
		board.set(4, 2, new Markers(GameMarkers.RED));
		assertFalse(board.checkWin(4, 2, winCondition));
	}
	
	/**
	 * Tests if you have a horizontal win, and it is not a vertical or horizontal win.
	 */
	@Test
	public void testHorizontalWin() {
		Connect4Board board = new Connect4Board(7, 6);
		board.initializeBoard();
		board.set(3, 4, new Markers(GameMarkers.RED));
		board.set(2, 4, new Markers(GameMarkers.RED));
		board.set(1, 4, new Markers(GameMarkers.RED));
		board.set(0, 4, new Markers(GameMarkers.RED));
		assertTrue(board.checkHorizontal(0, 4, winCondition)); 
		assertFalse(board.checkVertical(0, 4, winCondition));
		assertFalse(board.checkDiagonal(0, 4, winCondition));
	}
	
	/**
	 * Tests if you have a vertical win, and that it is not a horizontal or diagonal win. 
	 */
	@Test
	public void testVerticalWin() {
		board.initializeBoard();
		board.set(4, 4, new Markers(GameMarkers.RED));
		board.set(4, 3, new Markers(GameMarkers.RED));
		board.set(4, 2, new Markers(GameMarkers.RED));
		board.set(4, 1, new Markers(GameMarkers.RED));
		assertTrue(board.checkVertical(4, 1, winCondition));
		assertFalse(board.checkHorizontal(4, 1, winCondition));
		assertFalse(board.checkDiagonal(4, 1, winCondition));
	}
	
	/**
	 * Tests both ways diagonals if it is a win. 
	 */
	@Test
	public void testDiagonalWin() {
		board.initializeBoard();
		board.set(0, 4, new Markers(GameMarkers.RED));
		board.set(1, 3, new Markers(GameMarkers.RED));
		board.set(2, 2, new Markers(GameMarkers.RED));
		board.set(3, 1, new Markers(GameMarkers.RED));
		assertTrue(board.checkDiagonal(3, 1, winCondition));
		
		board.initializeBoard();
		board.set(4, 4, new Markers(GameMarkers.RED));
		board.set(3, 3, new Markers(GameMarkers.RED));
		board.set(2, 2, new Markers(GameMarkers.RED));
		board.set(1, 1, new Markers(GameMarkers.RED));
		assertTrue(board.checkDiagonal(1, 1, winCondition));
	}
	
	/**
	 * Tests that we can put a marker in every cell of the board. 
	 */
	@Test
	void testCanPutMarker() {
		board.initializeBoard();
		for (int i = 0; i < board.getWidth(); i++) {
			for (int j = 0; j < board.getHeight(); j++) {
				board.dropMarker(i, j, player.getMarker());
				Markers mark = ((Markers) board.get(i, j));
				assertEquals(mark.getMarker(), GameMarkers.RED);
			}
		}
	}
	
	/**
	 * Tests that if we drop a marker into a position, this position is taken. 
	 */
	@Test
	 void testPositionIsTaken() {
		board.initializeBoard();
		board.dropMarker(2, 2, GameMarkers.YELLOW);
		assertTrue(board.isTaken(2, 2));
	}	
	
	/**
	 * Tests that when it is not dropped any markers, the position is not taken. 
	 */
	@Test 
	void testPositionIsNotTaken() {
		board.initializeBoard();
		assertFalse(board.isTaken(2, 2));
		assertFalse(board.isTaken(1, 5));
	}
	
	/**
	 * Tests that when the board is initialized, every cell contains the marker SPACE.
	 */
	@Test
	public void initializeBoardTest() {
		board.initializeBoard();
		for (int i = 0; i < board.getWidth(); i++) {
			for (int j = 0; j < board.getHeight(); j++) {
				Markers mark = ((Markers) board.get(i, j));
				assertEquals(mark.getMarker(), GameMarkers.SPACE);
			}
		}
	}
	
	/**
	 * Prints a board to see that the markers are where they are supposed to be. 
	 */
	@Test
	public void testPrintBoardWithMarkers() {
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
	
	/**
	 * Tests dropping markers to the board. 
	 */
	@Test
	public void dropMarkerTest() {
		board.initializeBoard();
		board.dropMarker(2, 4, GameMarkers.YELLOW);
		board.dropMarker(5, 1, GameMarkers.YELLOW);
		board.dropMarker(3, 3, GameMarkers.YELLOW);
		for (int i = 0; i < board.getWidth(); i++) {
			for(int j = 0; j < board.getHeight(); j++) {
				if (board.isTaken(i, j)) {
					Markers mark = ((Markers) board.get(i, j));
					assertEquals(mark.getMarker(), GameMarkers.YELLOW);
				}
			}
		}
	}
	
	/**
	 * Tests that it is not a draw if the board is not full.
	 */
	@Test
	public void testBoardIsNotDraw() {
		board.initializeBoard();
		assertFalse(board.isDraw());
		board.dropMarker(1, 3, player.getMarker());
		assertFalse(board.isDraw());
	}
	
	/**
	 * Tests that it is a draw if the board is full.
	 */
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
