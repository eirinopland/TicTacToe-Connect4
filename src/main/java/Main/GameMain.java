package Main;

import java.util.Scanner;

import Games.TicTacToeGame;

public class GameMain {
	public static void main(String[] args) {
		System.out.println("Type 0 for a two-player game, 1 for a one-player game");
		Scanner in = new Scanner(System.in);
		int gameMode = in.nextInt();
		if(gameMode == 0) {
			TicTacToeGame game = new TicTacToeGame(0);
			game.startGame();
		}
		if(gameMode == 1) {
			TicTacToeGame game = new TicTacToeGame(1);
			game.startGame();
		}
		if(gameMode == 2) {
			TicTacToeGame game = new TicTacToeGame(2);
			game.startGame();
		}
	}
}
