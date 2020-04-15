package Players;

import Markers.GameMarkers;

public interface IPlayer {
	String getName();
	
	GameMarkers getMarker();

	int pickColumn(int max);
	
	int pickRow(int max);
}
