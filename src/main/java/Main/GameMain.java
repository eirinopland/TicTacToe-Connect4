package Main;

import java.util.Scanner;

import Games.Connect4Game;
import Games.TicTacToeGame;

public class GameMain {
	public static void main(String[] args) {
		System.out.println("Which game would you like to play?");
		System.out.println("1) TicTacToe? ");
		System.out.println("2) Connect4? ");
		Scanner sc = new Scanner(System.in);
		int gameChoice = sc.nextInt();
		if (gameChoice == 1) {
			System.out.println("Type 0 for a two-player game, 1 for a one-player game");
			int gameMode = sc.nextInt();
			if(gameMode == 0) {
				TicTacToeGame game = new TicTacToeGame(0);
				game.startGame();
			}
			if(gameMode == 1) {
				TicTacToeGame game = new TicTacToeGame(1);
				game.startGame();
			}
		}
		if (gameChoice == 2) {
			System.out.println("Type 0 for a two-player game, 1 for a one-player game");
			int gameMode = sc.nextInt();
			if(gameMode == 0) {
				Connect4Game game = new Connect4Game(0);
				game.startGame();
			}
			if(gameMode == 1) {
				Connect4Game game = new Connect4Game(1);
				game.startGame();
			}
		}
	}
}
		
		
		
//		System.out.println("Type 0 for a two-player game, 1 for a one-player game");
//		Scanner in = new Scanner(System.in);
//		int gameMode = in.nextInt();
//		if(gameMode == 0) {
//			TicTacToeGame game = new TicTacToeGame(0);
//			game.startGame();
//		}
//		if(gameMode == 1) {
//			TicTacToeGame game = new TicTacToeGame(1);
//			game.startGame();
//		}
//		if(gameMode == 2) {
//			TicTacToeGame game = new TicTacToeGame(2);
//			game.startGame();
//		}
//	}

