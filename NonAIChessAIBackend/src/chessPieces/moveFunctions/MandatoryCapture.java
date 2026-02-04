package moveFunctions;

import pieceMovement.ChessMove;
import pieceObjects.ChessPiece;

public class MandatoryCapture implements moveValidityChecker {
	public boolean isMoveValid(ChessMove proposedMove) {
		ChessPiece capturing_piece = proposedMove.getCurrent_board().PieceAt(proposedMove.getMove_from());
		ChessPiece captureable_piece = proposedMove.getCurrent_board().PieceAt(proposedMove.getMove_to());
		return (captureable_piece != null && (captureable_piece.getTeamColour() != capturing_piece.getTeamColour()) );
	}
}
