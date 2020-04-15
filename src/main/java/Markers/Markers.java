package Markers;


public class Markers {
private GameMarkers marker; 
	
	public Markers(GameMarkers marker) {
		this.marker = (GameMarkers) marker; 
	}
	
	public String getMarkerSymbol() {
		switch(marker) {
		case CROSS:
			return "X";
		case CIRCLE:
			return "O";
		case SPACE: 
			return " ";
		}
		return null;
	}
	
	public GameMarkers getMarker() {
		return marker; 
	}
	
	public boolean isFilled() {
		if (marker == GameMarkers.SPACE) {
			return false; 
		}
		else {
			return true; 
		}	 
	}
	
	public void setMarker(GameMarkers marker) {
		this.marker = marker; 
	}
}
