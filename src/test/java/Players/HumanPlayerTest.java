package Players;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Board.Board;
import Markers.GameMarkers;
import Markers.Markers;

public class HumanPlayerTest {
	IPlayer human = new HumanPlayer(GameMarkers.YELLOW, "Player1");
	
	@Test
	void testGetName() {
		assertEquals("Player1", human.getName());
	}
	
	@Test
	void getMarkerSymbol() {
		Markers mark = human.getMarker();
		assertEquals("Y", getMarkerSymbol());
	}
	
	@Test
	void testPickCol() {
		HumanPlayer.pickColumn(1);
		
	}
	
	@Test
	void testPickRow() {
		
	}
	

	Markers mark = ((Markers) board.get(2, 4));
	assertEquals(mark.getMarker(), GameMarkers.YELLOW);
	}
}
