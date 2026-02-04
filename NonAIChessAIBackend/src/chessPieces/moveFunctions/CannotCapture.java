package moveFunctions;

import pieceMovement.ChessMove;

public class CannotCapture implements moveValidityChecker {
	public boolean isMoveValid(ChessMove proposedMove) {
		return (proposedMove.getCurrent_board().PieceAt(proposedMove.getMove_to()) == null);
	}
}
