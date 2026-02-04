package moveFunctions;

import pieceMovement.ChessMove;

public interface moveValidityChecker {
	public boolean isMoveValid( ChessMove proposedMove);
}
