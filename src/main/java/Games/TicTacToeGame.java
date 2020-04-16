package Games;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Board.TicTacToeBoard;
import Markers.GameMarkers;
import Players.AIPlayer;
import Players.HumanPlayer;
import Players.IPlayer;


public class TicTacToeGame implements IGame{
	private final List<IPlayer> players; 
	private final TicTacToeBoard board;
	private GameMarkers marker; 
	
	public TicTacToeGame(int mode) {
		players = new ArrayList<IPlayer>();
		board = new TicTacToeBoard(3, 3);
		
		switch(mode) {
			case 0: {
				players.add(new HumanPlayer(GameMarkers.CROSS));
				players.add(new HumanPlayer(GameMarkers.CIRCLE));
				break;
			}
			case 1: {
				players.add(new HumanPlayer(GameMarkers.CROSS));
				players.add(new AIPlayer(GameMarkers.CIRCLE));
				break;
			}
			case 2: {
				players.add(new AIPlayer(GameMarkers.CROSS));
				players.add(new AIPlayer(GameMarkers.CIRCLE));
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
		while (!finished) {	
			for (IPlayer player : players) {
				System.out.println("It is " + player.getMarker() + "'s turn!");
				int col;
				int row;
				do {
					col = player.pickColumn(board.getWidth());
					row = player.pickRow(board.getHeight());
				} while(!validMove(col, row, player));
				board.dropMarker(col, row, player.getMarker());
				board.printBoard();
				if(board.checkWin(col, row)) {
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
	
	public boolean validMove(int col, int row, IPlayer player) {
		if(col >= board.getWidth() || col < 0 || row >= board.getHeight() || row < 0) {
			return false; 
		}
		return !board.isTaken(col, row);
	}
}
