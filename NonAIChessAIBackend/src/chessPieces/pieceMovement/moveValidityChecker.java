package pieceMovement;

import ChessBoard.ChessBoard;
import ChessBoard.Coordinate;

public interface moveValidityChecker {
	public boolean isMoveValid( ChessMove proposedMove, ChessBoard current_board);
}
