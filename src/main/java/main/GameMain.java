package main;

import java.util.Scanner;

import games.Connect4Game;
import games.TicTacToeGame;

public class GameMain {
	public static void main(String[] args) {
		System.out.println("Which game would you like to play?");
		System.out.println("1) TicTacToe? ");
		System.out.println("2) Connect4? ");
		Scanner sc = new Scanner(System.in);
		int gameChoice = sc.nextInt();
		System.out.println("Choose players:");
		System.out.println("1) Human against human");
		System.out.println("2) Human against AI");
		int gameMode = sc.nextInt();
		if (gameChoice == 1) {			
			if(gameMode == 1) {
				TicTacToeGame game = new TicTacToeGame(0);
				game.startGame();
			}
			if(gameMode == 2) {
				TicTacToeGame game = new TicTacToeGame(1);
				game.startGame();
			}
		}
		if (gameChoice == 2) {
			if(gameMode == 1) {
				Connect4Game game = new Connect4Game(0);
				game.startGame();
			}
			if(gameMode == 2) {
				Connect4Game game = new Connect4Game(1);
				game.startGame();
			}
		}
	}
}
		
		
		
