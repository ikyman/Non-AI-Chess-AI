package pieceObjects;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import main.GameColour;
import moveFunctions.CannotRecurse;
import moveFunctions.OptionalCapture;
import moveFunctions.chessExclusive.Castling;
import pieceMovement.CaptureList;
import pieceMovement.KnownMovements;
import pieceMovement.MoveGenerator;

public class King extends GamePiece {
	static int KING_VALUE = 3;

	public King(GameColour teamColour){
		super(teamColour, KING_VALUE);
		this.addMoveGenerator(new MoveGenerator(KnownMovements.KillCaptureWhereMove(KnownMovements.diagonals), new OptionalCapture(), new CannotRecurse()));
		this.addMoveGenerator(new MoveGenerator(KnownMovements.KillCaptureWhereMove(KnownMovements.horizontals), new OptionalCapture(), new CannotRecurse()));
		this.addMoveGenerator(new MoveGenerator(KnownMovements.KillCaptureWhereMove(KnownMovements.verticals), new OptionalCapture(), new CannotRecurse()));
		
		
		//Castling
		Map<Point, CaptureList> jumpTwoSpots = new HashMap<Point, CaptureList>();
		jumpTwoSpots.put(new Point(-2,0), CaptureList.EmptyCaptureList());
		jumpTwoSpots.put(new Point(2,0), CaptureList.EmptyCaptureList());
		this.addMoveGenerator(new MoveGenerator(jumpTwoSpots, new Castling(), new CannotRecurse()));

	}
}
