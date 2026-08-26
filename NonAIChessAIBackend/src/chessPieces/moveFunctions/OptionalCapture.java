package moveFunctions;

import pieceMovement.CaptureList;
import pieceMovement.PieceMove;
import pieceObjects.GamePiece;

public class OptionalCapture implements moveBehavior {
	public boolean isMoveValid(PieceMove proposedMove) {
		GamePiece capturing_piece = proposedMove.getCurrent_board().PieceAt(proposedMove.getMove_from());
		GamePiece captureable_piece = proposedMove.getCurrent_board().PieceAt(proposedMove.getMove_to());
		return (captureable_piece == null || (captureable_piece.getTeamColour() != capturing_piece.getTeamColour()) );
	}
	
	@Override
	public CaptureList getCaptures(PieceMove proposedMove) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveEffect(PieceMove proposedMove) {
		// TODO Auto-generated method stub
		
	}
}
