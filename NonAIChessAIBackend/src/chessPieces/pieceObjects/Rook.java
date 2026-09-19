package pieceObjects;

import main.GameColour;
import moveFunctions.CannotRecurse;
import moveFunctions.OptionalCapture;
import moveFunctions.RecurseIfNoCapture;
import pieceMovement.KnownMovements;
import pieceMovement.MoveGenerator;

public class Rook extends GamePiece{
	static int CASTLE_VALUE = 5;
	
	public Rook(GameColour teamColour){
		super(teamColour, CASTLE_VALUE);
		
		this.addMoveGenerator(new MoveGenerator(KnownMovements.KillCaptureWhereMove(KnownMovements.diagonals), new OptionalCapture(), new RecurseIfNoCapture()));
		this.addMoveGenerator(new MoveGenerator(KnownMovements.KillCaptureWhereMove(KnownMovements.horizontals), new OptionalCapture(), new RecurseIfNoCapture()));		
	}
}
