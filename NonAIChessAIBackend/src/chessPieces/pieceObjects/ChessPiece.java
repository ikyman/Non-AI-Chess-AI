package pieceObjects;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import checkeredBoard.ChessBoard;
import checkeredBoard.Coordinate;
import main.ChessColour;
import pieceMovement.ChessMove;
import pieceMovement.MoveGenerator;

public abstract class ChessPiece {
	protected ChessColour teamColour;
	protected Set<MoveGenerator> pieceMoves; 

	public ChessColour getTeamColour() {
		return this.teamColour;
	}
	public Set<ChessMove> getMoves(Point piece_location, ChessBoard current_board){
		Set<ChessMove> available_moves = new HashSet<ChessMove>();
		for (MoveGenerator mg: pieceMoves) {
			available_moves.addAll(mg.MoveGenerate(piece_location, current_board, this.getTeamColour()));
		} 
		return available_moves;
	}
	
	protected void addMoveGenerator(MoveGenerator mg){
		pieceMoves.add(mg);
	}
}
