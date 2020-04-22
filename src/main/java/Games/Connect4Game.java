package Games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Board.Connect4Board;
import Markers.GameMarkers;
import Players.AIPlayer;
import Players.HumanPlayer;
import Players.IPlayer;

public class Connect4Game implements IGame{
	public final List<IPlayer> players; 
	private final Connect4Board board;
	private GameMarkers marker;
	private final int winCondition = 4;
	
	public Connect4Game(int mode) {
		players = new ArrayList<IPlayer>();
		board = new Connect4Board(7, 6);
		
		switch(mode) {
			case 0: {
				players.add(new HumanPlayer(GameMarkers.YELLOW, "Player1"));
				players.add(new HumanPlayer(GameMarkers.RED, "Player2"));
				break;
			}
			case 1: {
				players.add(new HumanPlayer(GameMarkers.YELLOW, "Human player"));
				players.add(new AIPlayer(GameMarkers.RED, "AI player"));
				break;
			}		
		}
		board.initializeBoard();
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
				System.out.println("Current player is " + player.getName() + "(" + player.getMarker() + ")");
				int col;
				int row;
				do {
					col = player.pickColumn(board.getWidth());
					row = validMove(col, player);
				} while(row < 0);
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
	
	
	public int validMove(int col, IPlayer player) {
		if(col >= board.getWidth() || col < 0) {
			System.out.println("Not a valid move, please enter a column between 1-7!");
			return -1; //-1 means that it is not a valid move.
		}
		if (board.isFull(col)) {
			System.out.println("Column " + (col+1) + " is full, try another one!");
			return -1;
		}
		for(int i = 0; i < board.getHeight(); i++) {
			if (!board.isTaken(col, i)) {
				board.get(col, i).setMarker(marker);
				return i;
			}
		}
		return -1;
	}	
}


