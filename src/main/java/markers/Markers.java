package markers;


public class Markers {
private GameMarkers marker; 
	
	public Markers(GameMarkers marker) {
		this.marker = (GameMarkers) marker; 
	}
	
	/**
	 * Get the printable marker symbol for each marker. 
	 * @return
	 */
	public String getMarkerSymbol() {
		switch(marker) {
		case CROSS:
			return "\u274c";
		case CIRCLE:
			return "\u2B55";
		case YELLOW:
			return "\ud83d\udfe1";
		case RED:
			return "\uD83D\uDD34";
		case SPACE: 
			return "  ";
		}
		return null;
	}
	
	public GameMarkers getMarker() {
		return marker; 
	}
	
	public void setMarker(GameMarkers marker) {
		this.marker = marker; 
	}
	
	/**
	 * 
	 * @return true if a cell contains a marker that is not SPACE. 
	 */
	public boolean isFilled() {
		if (marker == GameMarkers.SPACE) {
			return false; 
		}
		else {
			return true; 
		}	 
	}
}
