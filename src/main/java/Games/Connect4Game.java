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
	private final List<IPlayer> players; 
	private final Connect4Board board;
	private GameMarkers marker;
	private final int winCondition = 4;
	
	public Connect4Game(int mode) {
		players = new ArrayList<IPlayer>();
		board = new Connect4Board(7, 6);
		
		switch(mode) {
			case 0: {
				players.add(new HumanPlayer(GameMarkers.YELLOW));
				players.add(new HumanPlayer(GameMarkers.RED));
				break;
			}
			case 1: {
				players.add(new HumanPlayer(GameMarkers.YELLOW));
				players.add(new AIPlayer(GameMarkers.RED));
				break;
			}
			case 2: {
				players.add(new AIPlayer(GameMarkers.YELLOW)); //fjern denne moden? 
				players.add(new AIPlayer(GameMarkers.RED));
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
				System.out.println("It is " + player.getMarker() + "'s turn!");
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
			return -1;
		}
		if (isFull(col)) {
			System.out.println("The column is full, try another one!");
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
	
	/**
	 * 
	 * @param col
	 * @return true if a column is full
	 */
	
	public boolean isFull(int col) {
		return board.get(col, board.getHeight()-1).getMarker() != GameMarkers.SPACE;
	}
	//Sette denne metoden i Board? 
	

	
}
