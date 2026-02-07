package moveFunctions;

import pieceMovement.ChessMove;

public interface moveBehavior {
	public boolean isMoveValid( ChessMove proposedMove);
	public void moveEffect(ChessMove proposedMove);
}
