package pieceObjects;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import main.GameColour;
import moveFunctions.CannotRecurse;
import moveFunctions.OptionalCapture;
import pieceMovement.MoveGenerator;

public class Knight extends GamePiece {
	static int KNIGHT_VALUE = 3;

	static final Set<Point> list_of_Ls = new HashSet<>(Arrays.asList(
			new Point(2,3),
			new Point(3,2),
			new Point(-2,3),
			new Point(-3,2),
			new Point(2,-3),
			new Point(3,-2),
			new Point(-2,-3),
			new Point(-3,-2)
			)); 
	
	public Knight(GameColour teamColour){
		super(teamColour, KNIGHT_VALUE);
		this.addMoveGenerator(new MoveGenerator(list_of_Ls, new OptionalCapture(), new CannotRecurse()));
		
	}
}
