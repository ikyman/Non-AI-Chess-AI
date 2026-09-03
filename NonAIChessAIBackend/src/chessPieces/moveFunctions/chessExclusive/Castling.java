package moveFunctions.chessExclusive;

import java.awt.Point;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import main.GameColour;
import pieceMovement.PieceMove;
import pieceMovement.PointArithmetic;
import pieceObjects.GamePiece;
import pieceObjects.Rook;
import pieceObjects.VirginityStatus;

public class Castling implements moveFunctions.moveBehavior {

	@Override
	public boolean isMoveValid(PieceMove proposedMove) {
		CheckeredBoard board = proposedMove.getCurrent_board();
		GamePiece castle_guest = board.getPieceAt(proposedMove.getMove_from());
		GameColour player_colour = castle_guest.getTeamColour();
		
		if (castle_guest.getVirginity() != VirginityStatus.hasntMoved) {
			return false;
		}
						
		Point castle_location = getCastlingCastle(proposedMove);
		if (castle_location == null){
			return false;
		}
		
		Set<Point> zoc = board.dangerZone(player_colour);
		
		Point step = getDirection(proposedMove);	
		Point safetyCheckPosition = proposedMove.getMove_from();

		// Warning! What's preventing K R ? ==> ? R K
		// A More important question: What's preventing me from not caring?
		while (safetyCheckPosition != castle_location) {
			if (zoc.contains(safetyCheckPosition)){
				return false;
			}
			safetyCheckPosition = PointArithmetic.addPoints(safetyCheckPosition, step);
		}
		if (zoc.contains(castle_location)){
			return false;
		}		
		return true;
	}

	@Override
	public void moveEffect(PieceMove proposedMove){
		CheckeredBoard board = proposedMove.getCurrent_board();
		Point castle_location = getCastlingCastle(proposedMove);
		
		GamePiece castled_castle = board.getPieceAt(castle_location);
		
		Point step = getDirection(proposedMove);
		Point new_castle_location = PointArithmetic.addPoints(proposedMove.getMove_from(), step); 
		
		board.clearPoint(castle_location);
		try {
			board.placePiece(castled_castle, new_castle_location);
		}catch (Exception e){
			throw new RuntimeException("Translated Checked->Unchecked Exception. This exception should only be thrown if isMoveValid is wrongly implemented!");
		}
	}
	
	/* Returns a point with maximum x and y 1 describing the direction of the castle.
	 * */
	private Point getDirection(PieceMove proposedMove) {
		Point non_normalized = PointArithmetic.subtractPoints(proposedMove.getMove_to(), proposedMove.getMove_from() );
		
		int dx = Integer.signum(non_normalized.x);
		int dy = Integer.signum(non_normalized.y);

		return new Point(dx, dy);
	}
	
	// Returns the location of the Rook that can be used for such castling
	private Point getCastlingCastle(PieceMove proposedMove) {
		CheckeredBoard board = proposedMove.getCurrent_board();
		GamePiece castle_guest = board.getPieceAt(proposedMove.getMove_from());
		GameColour player_colour = castle_guest.getTeamColour();

		Point step = getDirection(proposedMove);	
		Point safetyCheckPosition = proposedMove.getMove_from();
		
		// What's preventing K R ? ==> ? R K
		// A More important question: What's preventing me from not caring?
		while (board.InBounds(safetyCheckPosition)) {
			GamePiece c_piece = board.getPieceAt(safetyCheckPosition); 
			if (c_piece != null) { 
				if( c_piece.getTeamColour() == player_colour && c_piece instanceof Rook && c_piece.getVirginity() == VirginityStatus.hasntMoved ) {
					return safetyCheckPosition;

				}
				return null;
			}
			safetyCheckPosition = PointArithmetic.addPoints(safetyCheckPosition, step);
		}
		return null;

	}
}
