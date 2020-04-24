package players;

import markers.GameMarkers;

public interface IPlayer {
	
	/**
	 * Gets the name of the player 
	 * @return name
	 */
	String getName();
	
	/**
	 * Gets the players marker
	 * @return marker
	 */
	GameMarkers getMarker();

	/**
	 * 
	 * @param max is maximum column input inside of the board
	 * @return column input
	 */
	int pickColumn(int max);
	
	/**
	 * 
	 * @param max is maximum row input inside of the board
	 * @return row input
	 */
	int pickRow(int max);
}
