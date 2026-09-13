package pieceObjects;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import main.GameColour;
import moveFunctions.CannotRecurse;
import moveFunctions.OptionalCapture;
import pieceMovement.KnownMovements;
import pieceMovement.MoveGenerator;

public class Knight extends GamePiece {
	static int KNIGHT_VALUE = 3;

	static final Set<Point> list_of_Ls = new HashSet<>(Arrays.asList(
			new Point(1,2),
			new Point(2,1),
			new Point(-1,2),
			new Point(-2,1),
			new Point(1,-2),
			new Point(2,-1),
			new Point(-1,-2),
			new Point(-2,-1)
			)); 
	
	public Knight(GameColour teamColour){
		super(teamColour, KNIGHT_VALUE);
		this.addMoveGenerator(new MoveGenerator(KnownMovements.KillCaptureWhereMove(list_of_Ls), new OptionalCapture(), new CannotRecurse()));
		
	}
}
