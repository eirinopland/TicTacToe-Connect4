package games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import board.TicTacToeBoard;
import markers.GameMarkers;
import players.AIPlayer;
import players.HumanPlayer;
import players.IPlayer;


public class TicTacToeGame implements IGame{
	public final List<IPlayer> players; 
	private final TicTacToeBoard board;
	private final int winCondition = 3; //How many markers you need in a row to win the game.
	
	/**
	 * Construct a tic tac toe game with the given player mode. 
	 * @param mode
	 */
	public TicTacToeGame(int mode) {
		players = new ArrayList<IPlayer>();
		board = new TicTacToeBoard(3, 3);
		
		switch(mode) {
			case 0: {
				players.add(new HumanPlayer(GameMarkers.CROSS, "Player1"));
				players.add(new HumanPlayer(GameMarkers.CIRCLE, "Player2"));
				break;
			}
			case 1: {
				players.add(new HumanPlayer(GameMarkers.CROSS, "Human player"));
				players.add(new AIPlayer(GameMarkers.CIRCLE, "AI player"));
				break;
			}		
		}	
	}

	@Override
	public void startGame() {
		Scanner in = new Scanner(System.in);
		do {
			board.initializeBoard();
			doTurns();
			System.out.println("Type 1 to play again, type 0 to exit:");
		} while (in.nextInt() == 1);
	}
	
	@Override
	public void doTurns() {
		boolean finished = false; 
		board.printBoard();
		Collections.shuffle(players); //Changes who starts the game randomly
		while (!finished) {	
			for (IPlayer player : players) {
				System.out.println("Turn: " + player.getName() + "(" + player.getMarker() + ")");
				int col;
				int row;
				do {
					col = player.pickColumn(board.getWidth());
					row = player.pickRow(board.getHeight());
				} while(!board.validMove(col, row, player));
				board.dropMarker(col, row, player.getMarker());
				board.printBoard();
				if(board.checkWin(col, row, winCondition)) {
					System.out.println("The winner is: " + player.getName());
					finished = true; 
					break; 
				} 
				if(board.isDraw()) {
					System.out.println("It's a draw");
					finished = true; 
					break;
				}
			}
		}
	}
}
