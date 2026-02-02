package chessPieces;
import java.util.HashSet;
import java.util.Set;

import ChessBoard.ChessBoard;
import ChessBoard.Coordinate;
import main.ChessColour;

public abstract class ChessPiece {
	protected ChessColour teamColour;
	protected Set<MoveGenerator> pieceMoves; 

	public ChessColour getTeamColour() {
		return this.teamColour;
	}
	Set<Coordinate> getMoves(Coordinate piece_location, ChessBoard current_board){
		Set<Coordinate> available_moves = new HashSet<Coordinate>();
		for (MoveGenerator mg: pieceMoves) {
			available_moves.addAll(mg.MoveGenerate(piece_location, current_board, this.getTeamColour()));
		} 
		return available_moves;
	}
	
	protected void addMoveGenerator(MoveGenerator mg){
		pieceMoves.add(mg);
	}
}
