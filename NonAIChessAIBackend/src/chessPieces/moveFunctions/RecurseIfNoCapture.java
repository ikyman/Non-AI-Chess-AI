package moveFunctions;

import pieceMovement.CaptureList;
import pieceMovement.PieceMove;

public class RecurseIfNoCapture implements recurseIf {

	@Override
	public boolean canRecurse(PieceMove newMove) {
		if (newMove.getCaptures() == CaptureList.EmptyCaptureList()) {
			return true;
		}
		return false;
	}

}
