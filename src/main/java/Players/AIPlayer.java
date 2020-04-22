package Players;

import java.util.Random;

import Markers.GameMarkers;


public class AIPlayer implements IPlayer{
	private GameMarkers marker;
	public static final Random random = new Random();
	private String name;
	
	public AIPlayer(GameMarkers marker, String name) {
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
		int r = random.nextInt(max);
		return r;
	}

	@Override
	public int pickRow(int max) {
		int r = random.nextInt(max);
		return r; 
	}
}
