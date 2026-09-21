package checkeredBoard;

import java.awt.Point;
import java.util.Set;

import main.GameColour;
import pieceMovement.PieceMove;
import pieceObjects.GamePiece;
import pieceObjects.King;

public class ChessBoard extends CheckeredBoard {
	public Point getKingLocation(GameColour kingColour) throws RuntimeException {
		for (int x = 1; x < this.x_size; x++) {
			for (int y = 1; y < this.y_size; y++) {
				Point coord = new Point(x,y);
				GamePiece piece_at_coord = this.getPieceAt(coord);
				if ((piece_at_coord instanceof King )&& piece_at_coord.getTeamColour() == kingColour) {
					return coord;
				}
			}
		}
		throw new RuntimeException("King of Colour" + kingColour + " Not Found on Chess Board!");
	}
	
	@Override
	public boolean moveFitsGameRules(PieceMove proposed_move) {
		// Thanks, I hate this. Why not simply Write rulesets as functions, and then add them to the Checkered board?
		// Save the current state of the board. AI written
		
		/* AI Prompt for when I once again have AI Juice:
		 * Why are we Having the Chessboard govern anything? We already have an interface for determining if a move is valid:
		 * the moveBehavior interface.
		 * 
		 * Take this Chessboard moveFitsGameRules. This checks that no MOVE puts a king in check. AKA, it checks move validity.
		 * Why not instead add that requirement upon generating moves? PeiceMove has a CompositeMoveBehaviour, and when generating moves, add
		 * the "cannot put king in check" moveBehaviour to any generated PieceMove
		 * */ 
		PieceMove testMove = proposed_move.clone();
	
        // Get the team whose move is being tested
		GameColour teamColour = proposed_move.getCurrent_board().getPieceAt(proposed_move.getMove_from()).getTeamColour();
		try {
			testMove.makeMove();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Point kingLocation = ((ChessBoard) testMove.getCurrent_board()).getKingLocation(teamColour);

        // If the king is in the danger zone, the move is invalid
        Set<Point> danger = testMove.getCurrent_board().dangerZone(teamColour);
                
        return !danger.contains(kingLocation);
	}
	
	@Override
	public ChessBoard clone() {
		return (ChessBoard) super.clone();
	}
}
