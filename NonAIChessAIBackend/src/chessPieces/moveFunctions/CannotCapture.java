package moveFunctions;

import pieceMovement.ChessMove;

public class CannotCapture implements moveBehavior {
	public boolean isMoveValid(ChessMove proposedMove) {
		return (proposedMove.getCurrent_board().PieceAt(proposedMove.getMove_to()) == null);
	}

	@Override
	public void moveEffect(ChessMove proposedMove) {
		return;
	}
}
