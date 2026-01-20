package chessPieces;
import java.util.Set;

import ChessBoard.Coordinate;

public interface ChessPiece {
	private Set<MoveGenerator> peiceMoves();
	Set<Coordinate> getMoves();
}
