package gameTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import board.TicTacToeBoard;
import games.TicTacToeGame;
import markers.GameMarkers;
import markers.Markers;
import players.HumanPlayer;
import players.IPlayer;

public class TicTacToeTest {
	TicTacToeBoard board = new TicTacToeBoard(3, 3);
	TicTacToeGame game = new TicTacToeGame(0); 
	IPlayer player = new HumanPlayer(GameMarkers.CROSS, "Player1"); 
	private final int winCondition = 3; 
	
	
	/**
	 * Tests that when you start a new game, the game contains two players 
	 * and contains the right amount of cells. 
	 */
	@Test
	void testStartNewGame() {
		TicTacToeGame game1 = new TicTacToeGame(0); 
		TicTacToeBoard board1 = new TicTacToeBoard(3, 3);
		assertEquals(game1.players.size(), 2); 
		assertEquals(board1.cells.size(), 3*3);
	}
	
	/**
	 * Tests that putting your marker outside the board is not a valid move. 
	 */
	@Test
	void testNotValidMoveOutsideBoard() {
		board.initializeBoard();
		assertFalse(board.validMove(4, 4, player));
	}
	
	@Test
	void testIsValidMove() {
		board.initializeBoard();
		assertTrue(board.validMove(0, 1, player));
	}
	
	/**
	 * Tests that it is not possible to put a marker if it is already taken. 
	 */
	@Test
	void testCanNotPlaceMarkerIfTaken() {
		board.initializeBoard();
		board.dropMarker(2, 2, player.getMarker());
		assertFalse(board.validMove(2, 2, player));
	}
	
	/**
	 * Tests that two in a row is not a win.
	 */
	@Test
	void testNotAWin() {
		board.initializeBoard();
		board.set(0, 1, new Markers(GameMarkers.CROSS));
		board.set(1, 1, new Markers(GameMarkers.CROSS));
		assertFalse(board.checkWin(1, 1, winCondition));
	}
	
	/**
	 * Tests if you have a horizontal win, and that it is not a vertical or diagonal win.
	 */
	@Test
	void testHorizontalWin() {
		board.initializeBoard();
		board.set(0, 1, new Markers(GameMarkers.CROSS));
		board.set(1, 1, new Markers(GameMarkers.CROSS));
		board.set(2, 1, new Markers(GameMarkers.CROSS));
		assertTrue(board.checkHorizontal(1, 1, winCondition));
		assertFalse(board.checkVertical(1, 1, winCondition));
		assertFalse(board.checkDiagonal(1, 1, winCondition));
	}
	
	/**
	 * Tests if you have a vertical win, and that it is not a horizontal or diagonal win. 
	 */
	@Test
	void testVerticalWin() {
		board.initializeBoard();
		board.set(1, 0, new Markers(GameMarkers.CROSS));
		board.set(1, 1, new Markers(GameMarkers.CROSS));
		board.set(1, 2, new Markers(GameMarkers.CROSS));
		assertTrue(board.checkVertical(1, 2, winCondition));
		assertFalse(board.checkHorizontal(1, 2, winCondition));
		assertFalse(board.checkDiagonal(1, 2, winCondition));
	}
	
	/**
	 * Tests both ways diagonals if it is a win. 
	 */
	@Test
	void testDiagonalWin() {
		board.initializeBoard();
		board.set(0, 0, new Markers(GameMarkers.CROSS));
		board.set(1, 1, new Markers(GameMarkers.CROSS));
		board.set(2, 2, new Markers(GameMarkers.CROSS));
		assertTrue(board.checkDiagonal(2, 2, winCondition));
		
		board.set(2, 0, new Markers(GameMarkers.CROSS));
		board.set(1, 1, new Markers(GameMarkers.CROSS));
		board.set(0, 2, new Markers(GameMarkers.CROSS));
		assertTrue(board.checkDiagonal(0, 2, winCondition));
		
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
				assertEquals(mark.getMarker(), GameMarkers.CROSS);
			}
		}
	}

	/**
	 * Tests that if we drop a marker into a position, this position is taken.
	 */
	@Test
	 void testPositionIsTaken() {
		board.initializeBoard();
		board.dropMarker(2, 2, player.getMarker());
		assertTrue(board.isTaken(2, 2));	
	}		
	
	/**
	 * Tests that when there is not dropped any markers, the position is not taken. 
	 */
	@Test
	void testPositionIsNotTaken() {
		board.initializeBoard();
		assertFalse(board.isTaken(2, 2));
		assertFalse(board.isTaken(1, 1));
	}
	
	/**
	 * Tests that when the board is initialized, every cell contains the marker SPACE. 
	 */
	@Test
	public void testInitializeBoard() {
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
		board.set(2, 0, new Markers(GameMarkers.CROSS));
		board.set(2, 2, new Markers(GameMarkers.CROSS));
		board.set(1, 1, new Markers(GameMarkers.CROSS));
		board.set(0, 0, new Markers(GameMarkers.CROSS));
		board.printBoard();
		
		board.initializeBoard();
		board.dropMarker(1, 2, GameMarkers.CIRCLE);
		board.dropMarker(2, 1, GameMarkers.CIRCLE);
		board.dropMarker(0, 1, GameMarkers.CIRCLE);
		board.dropMarker(1, 1, GameMarkers.CIRCLE);
		board.printBoard();
		
	}
	
	/**
	 * Tests dropping markers to the board.
	 */
	@Test
	public void dropMarkerTest() {
		board.initializeBoard();
		board.dropMarker(0, 1, GameMarkers.CROSS);
		board.dropMarker(1, 1, GameMarkers.CROSS);
		board.dropMarker(2, 1, GameMarkers.CROSS);
		for (int i = 0; i < board.getWidth(); i++) {
			for(int j = 0; j < board.getHeight(); j++) {
				if (board.isTaken(i, j)) {
					Markers mark = ((Markers) board.get(i, j));
					assertEquals(mark.getMarker(), GameMarkers.CROSS);
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
		board.dropMarker(1, 2, player.getMarker());
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
				board.get(i, j).setMarker(GameMarkers.CROSS);
			}
		}
		assertTrue(board.isDraw());
	}
}

