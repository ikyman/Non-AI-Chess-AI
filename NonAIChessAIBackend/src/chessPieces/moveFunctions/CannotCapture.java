package moveFunctions;

import pieceMovement.PieceMove;

public class CannotCapture implements moveBehavior {
	public boolean isMoveValid(PieceMove proposedMove) {
		return (proposedMove.getCurrent_board().PieceAt(proposedMove.getMove_to()) == null);
	}

	@Override
	public void moveEffect(PieceMove proposedMove) {
		return;
	}
}
