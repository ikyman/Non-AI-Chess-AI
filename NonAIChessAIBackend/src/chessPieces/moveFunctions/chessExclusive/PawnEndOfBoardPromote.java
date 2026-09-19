package moveFunctions.chessExclusive;

import java.awt.Point;

import main.GameColour;
import moveFunctions.moveBehavior;
import pieceMovement.PieceMove;
import pieceObjects.Queen;

public class PawnEndOfBoardPromote implements moveBehavior{

	@Override
	public boolean isMoveValid(PieceMove proposedMove) {
		return true;
	}

	@Override
	public void moveEffect(PieceMove proposedMove) {
		Point promotionSpot = proposedMove.getMove_to();
		if (promotionSpot.y == 1 || promotionSpot.y == proposedMove.getCurrent_board().get_y_dim()) {
			GameColour promotion_team = proposedMove.getCurrent_board().getPieceAt(promotionSpot).getTeamColour();
			proposedMove.getCurrent_board().clearPoint(promotionSpot);
			Queen promotedQueen = new Queen(promotion_team);
			proposedMove.getCurrent_board().placePiece(promotedQueen, promotionSpot);
		}
	}
}
