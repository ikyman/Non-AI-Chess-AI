package pieceObjects;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import pieceMovement.MoveGenerator;
import pieceMovement.PieceMove;

enum VirginityStatus{
	hasntMoved,
	firstMove,
	moved,
}

public abstract class VirginityPiece extends GamePiece{
	private VirginityStatus virginity;
	
	public VirginityPiece() {
		this.virginity = VirginityStatus.hasntMoved;
	}

	public Set<PieceMove> getMoves(Point piece_location, CheckeredBoard current_board){
		Set<PieceMove> available_moves = new HashSet<PieceMove>();
		for (MoveGenerator mg: pieceMoves) {
			available_moves.addAll(mg.MoveGenerate(piece_location, current_board, null));
		} 
		return available_moves;
	}
	
	protected void addMoveGenerator(MoveGenerator mg){
		pieceMoves.add(mg);
	}

	public VirginityStatus getVirginity() {
		return virginity;
	}

}
