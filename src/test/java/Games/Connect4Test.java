package Games;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Board.Connect4Board;
import Markers.GameMarkers;
import Markers.Markers;
import Players.HumanPlayer;
import Players.IPlayer;

public class Connect4Test {
	Connect4Board board = new Connect4Board(7, 6);
	private Connect4Game game = new Connect4Game(0);
	private ArrayList<IPlayer> players;
	IPlayer player = new HumanPlayer(GameMarkers.RED, "Player1");
	
	private final int winCondition = 4; 
	
	
//	@Test
//	public void checkWinTest() {
//		game.startGame();
//		assertEquals(board.checkWin(board.getWidth(), board.getHeight()), true);
//	}
	
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
//		board.initializeBoard();
//		assertEquals(board.cells, GameMarkers.SPACE);
//		assertEquals(board.checkWin(4, 5, winCondition), null);
	}
	
	@Test
	void testPlayersHaveNotMadeMove() {
		
	}
	
	/**
	 * Tests if a move is valid 
	 */
	@Test
	void testValidMove() {
		Connect4Board board = new Connect4Board(7, 6);
		board.initializeBoard();
//		board.dropMarker(2, 2, GameMarkers.RED);
//		assertEquals(game.validMove(2, player), -1);
		assertEquals(game.validMove(8, player), -1); //-1 means that it is not a valid move 
		board.dropMarker(1, 0, player.getMarker());
		board.dropMarker(1, 1, player.getMarker());
		board.dropMarker(1, 2, player.getMarker());
		board.dropMarker(1, 3, player.getMarker());
		board.dropMarker(1, 4, player.getMarker());
		board.dropMarker(1, 5, player.getMarker());
		assertEquals(game.validMove(1, player), -1);
	}
	
	@Test
	public void horizontalWinTest() {
		Connect4Board board = new Connect4Board(7, 6);
		board.initializeBoard();
		board.set(3, 4, new Markers(GameMarkers.RED));
		board.set(2, 4, new Markers(GameMarkers.RED));
		board.set(1, 4, new Markers(GameMarkers.RED));
		board.set(0, 4, new Markers(GameMarkers.RED));
		
		assertEquals(board.checkWin(0, 4, winCondition), true); //Win conditions instead of 4? 
	}
	
	@Test
	public void verticalWinTest() {
		board.initializeBoard();
		board.set(4, 4, new Markers(GameMarkers.RED));
		board.set(4, 3, new Markers(GameMarkers.RED));
		board.set(4, 2, new Markers(GameMarkers.RED));
		board.set(4, 1, new Markers(GameMarkers.RED));
		
		assertEquals(board.checkWin(4, 1, winCondition), true);
		
		//Three in a row, should return false
		board.initializeBoard();
		board.set(4, 4, new Markers(GameMarkers.RED));
		board.set(4, 3, new Markers(GameMarkers.RED));
		board.set(4, 2, new Markers(GameMarkers.RED));
		
		assertEquals(board.checkWin(4, 2, winCondition), false);
	}
	
	@Test
	public void diagonalWinTest() {
		board.initializeBoard();
		board.set(0, 4, new Markers(GameMarkers.RED));
		board.set(1, 3, new Markers(GameMarkers.RED));
		board.set(2, 2, new Markers(GameMarkers.RED));
		board.set(3, 1, new Markers(GameMarkers.RED));
		
		assertEquals(board.checkWin(3, 1, winCondition), true);
		
		board.initializeBoard();
		board.set(4, 4, new Markers(GameMarkers.RED));
		board.set(3, 3, new Markers(GameMarkers.RED));
		board.set(2, 2, new Markers(GameMarkers.RED));
		board.set(1, 1, new Markers(GameMarkers.RED));
		
		assertEquals(board.checkWin(1, 1, winCondition), true);
	}
	
	

}
