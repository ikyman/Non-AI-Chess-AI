package pieceObjects;

import main.GameColour;
import moveFunctions.OptionalCapture;
import moveFunctions.RecurseIfNoCapture;
import pieceMovement.KnownMovements;
import pieceMovement.MoveGenerator;

public class Queen extends GamePiece{
	static int QUEEN_VALUE = 9;
	
	public Queen(GameColour teamColour){
		super(teamColour, QUEEN_VALUE);
		
		this.addMoveGenerator(new MoveGenerator(KnownMovements.KillCaptureWhereMove(KnownMovements.verticals), new OptionalCapture(), new RecurseIfNoCapture()));
		this.addMoveGenerator(new MoveGenerator(KnownMovements.KillCaptureWhereMove(KnownMovements.horizontals), new OptionalCapture(), new RecurseIfNoCapture()));		
		this.addMoveGenerator(new MoveGenerator(KnownMovements.KillCaptureWhereMove(KnownMovements.bend), new OptionalCapture(), new RecurseIfNoCapture()));		
		this.addMoveGenerator(new MoveGenerator(KnownMovements.KillCaptureWhereMove(KnownMovements.bend_sinister), new OptionalCapture(), new RecurseIfNoCapture()));		
	}
}
