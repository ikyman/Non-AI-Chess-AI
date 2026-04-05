package checkeredBoard;

import java.awt.Point;

import main.GameColour;
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
}
