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
				GamePiece piece_at_coord = this.PieceAt(coord);
				if ((piece_at_coord instanceof King )&& piece_at_coord.getTeamColour() == kingColour) {
					return coord;
				}
			}
		}
		throw new RuntimeException("King of Colour" + kingColour + " Not Found on Chess Board!");
	}
	
	@Override
	public boolean moveFitsGameRules(PieceMove proposed_move) {
		// Save the current state of the board. AI written
		ChessBoard testingBoard = this.clone();
		
        // Get the team whose move is being tested
		GameColour teamColour = proposed_move.getTeamColour();
		testingBoard.makeMove(proposed_move);
		Point kingLocation = testingBoard.getKingLocation(teamColour);

        // If the king is in the danger zone, the move is invalid
        Set<Point> danger = testingBoard.dangerZone(teamColour);
        return !danger.contains(kingLocation);
	}
}
