package pieceObjects;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import main.GameColour;
import pieceMovement.MoveGenerator;
import pieceMovement.PieceMove;

public abstract class GamePiece {
	protected GameColour teamColour;
	protected Set<MoveGenerator> pieceMoves; 

	public GameColour getTeamColour() {
		return this.teamColour;
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
}
