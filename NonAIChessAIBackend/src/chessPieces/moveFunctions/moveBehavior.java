package moveFunctions;

import pieceMovement.PieceMove;

public interface moveBehavior {
	public boolean isMoveValid( PieceMove proposedMove);
	public void moveEffect(PieceMove proposedMove);
}
