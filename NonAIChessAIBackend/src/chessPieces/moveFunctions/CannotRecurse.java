package moveFunctions;

import pieceMovement.PieceMove;

public class CannotRecurse implements recurseIf {

	@Override
	public boolean canRecurse(PieceMove newMove) {
		return false;
	}

}
