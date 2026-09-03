package pieceObjects;

import main.GameColour;
import moveFunctions.CannotCapture;
import moveFunctions.CannotRecurse;
import moveFunctions.OptionalCapture;
import pieceMovement.MoveGenerator;

public class King extends GamePiece {
	static int KING_VALUE = 3;

	public King(GameColour teamColour){
		super(teamColour, KING_VALUE);
		this.addMoveGenerator(new MoveGenerator(diagonals, new OptionalCapture(), new CannotRecurse()));
		this.addMoveGenerator(new MoveGenerator(straights, new OptionalCapture(), new CannotRecurse()));
		
		//Castling
		this.addMoveGenerator(new MoveGenerator(jumpTwoSpots, new Castling(), new CannotRecurse()));

	}
}
