package moveFunctions;

import pieceMovement.CaptureList;
import pieceMovement.PieceMove;

public interface moveBehavior {
	public boolean isMoveValid( PieceMove proposedMove);
	public void moveEffect(PieceMove proposedMove);
}
