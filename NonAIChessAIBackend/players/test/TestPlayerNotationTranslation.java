package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.GameColour;
import main.HumanPlayer;


public class TestPlayerNotationTranslation {
	@Test
    void testInitialWhiteKnight() throws Exception {
		HumanPlayer notationTranslator = new HumanPlayer(GameColour.WHITE);
		
		// Cannot be done, because chessNotationToPoint is private.
		// notationTranslator.

	}

}
