package chessPieces;
import java.util.Set;

import ChessBoard.Coordinate;

public interface ChessPiece {
	Set<Coordinate> getMoves();
}
