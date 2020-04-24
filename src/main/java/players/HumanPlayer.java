package players;

import java.util.Scanner;

import markers.GameMarkers;


public class HumanPlayer implements IPlayer {
	private GameMarkers marker;
	private String name; 
	
	/**
	 * Construct a human player with the given marker and name.
	 * @param marker
	 * @param name
	 */
	public HumanPlayer(GameMarkers marker, String name) {
		this.marker = marker; 
		this.name = name; 
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public GameMarkers getMarker() {
		return marker;
	}

	@Override
	public int pickColumn(int max) {
		System.out.println("In what column would you like to place your marker?");
		Scanner in = new Scanner(System.in);
		while (!in.hasNextInt()) {
			System.out.println("Invalid column number. Please enter only digits.");
			in.next();
		}
		int colInput = in.nextInt()-1;
		return colInput;
		
	}

	@Override
	public int pickRow(int max) {
		System.out.println("In what row would you like to place your marker?");
		Scanner in = new Scanner(System.in);
		while (!in.hasNextInt()) {
			System.out.println("Invalid row number. Please enter only digits.");
			in.next();
		}
		int rowInput = in.nextInt()-1;
		return rowInput;
	}

}
