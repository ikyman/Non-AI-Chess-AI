package moveFunctions.chessExclusive;

import java.awt.Point;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import main.GameColour;
import pieceMovement.PieceMove;
import pieceMovement.PointArithmetic;
import pieceObjects.GamePiece;
import pieceObjects.Rook;
import pieceObjects.virginity.VirginityStatus;

public class Castling implements moveFunctions.moveBehavior {

	@Override
	public boolean isMoveValid(PieceMove proposedMove) {
		CheckeredBoard board = proposedMove.getCurrent_board();
		GamePiece castle_guest = board.PieceAt(proposedMove.getMove_from());
		GameColour player_colour = castle_guest.getTeamColour();
		
		if (castle_guest.getVirginity() != VirginityStatus.hasntMoved) {
			return false;
		}
				
		Set<Point> zoc = board.dangerZone(player_colour);
		
		Point direction = PointArithmetic.subtractPoints(proposedMove.getMove_to(), proposedMove.getMove_from() );
		
		int dx = Integer.signum(direction.x);
		int dy = Integer.signum(direction.y);

		Point step = new Point(dx, dy);
		Point safetyCheckPosition = proposedMove.getMove_from();
		
		// Warning! What's preventing K R ? ==> ? R K
		// A More important question: What's preventing me from not caring?
		while (board.InBounds(safetyCheckPosition)) {
			if (zoc.contains(safetyCheckPosition)){
				return false;
			}
			GamePiece c_piece = board.PieceAt(safetyCheckPosition); 
			if (c_piece != null) { 
				if( c_piece.getTeamColour() == player_colour && c_piece instanceof Rook ) {
					Rook r_piece = (Rook) c_piece;
					if (r_piece.getVirginity() == VirginityStatus.hasntMoved) {
						return true;
					}
					return false;
				}
				return false;
			}
			safetyCheckPosition = PointArithmetic.addPoints(safetyCheckPosition, step);
		}
		return false;
	}

	@Override
	public void moveEffect(PieceMove proposedMove) {
		// TODO Auto-generated method stub
		
	}

}
