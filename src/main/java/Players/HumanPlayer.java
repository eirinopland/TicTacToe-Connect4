package Players;

import java.util.Scanner;

import Markers.GameMarkers;


public class HumanPlayer implements IPlayer {
	private GameMarkers marker;
	private String name; 
	
	public HumanPlayer(GameMarkers marker) {
		this.marker = marker; 
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
		int colInput = in.nextInt()-1;
		return colInput;
		
	}

	@Override
	public int pickRow(int max) {
		System.out.println("In what row would you like to place your marker?");
		Scanner in = new Scanner(System.in);
		int rowInput = in.nextInt()-1;
		return rowInput;
	}

}