package moveFunctions;

import java.awt.Point;

import pieceMovement.CaptureList;
import pieceMovement.PieceMove;

public class RecurseIfNoCapture implements recurseIf {

	@Override
	public boolean canRecurse(PieceMove newMove) {
		for (Point p : newMove.getCaptures().captures.keySet()) {
			if (newMove.getCurrent_board().getPieceAt(p) != null) {
				return false;
			}
		}
		return true;
	}
}
