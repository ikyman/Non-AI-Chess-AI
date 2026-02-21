package pieceObjects;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import checkeredBoard.ChessBoard;
import main.GameColour;
import pieceMovement.ChessMove;
import pieceMovement.MoveGenerator;

public abstract class ChessPiece {
	protected GameColour teamColour;
	protected Set<MoveGenerator> pieceMoves; 

	public GameColour getTeamColour() {
		return this.teamColour;
	}
	public Set<ChessMove> getMoves(Point piece_location, ChessBoard current_board){
		Set<ChessMove> available_moves = new HashSet<ChessMove>();
		for (MoveGenerator mg: pieceMoves) {
			available_moves.addAll(mg.MoveGenerate(piece_location, current_board, null));
		} 
		return available_moves;
	}
	
	protected void addMoveGenerator(MoveGenerator mg){
		pieceMoves.add(mg);
	}
}
