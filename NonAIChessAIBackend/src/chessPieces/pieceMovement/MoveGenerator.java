package pieceMovement;

import java.util.HashSet;
import java.util.Set;

import ChessBoard.ChessBoard;
import ChessBoard.Coordinate;
import main.ChessColour;

enum CaptureBehavior{
	cannotCapture,
	optionalCapture,
	mandatoryCapture,
}

public class MoveGenerator {
	private Coordinate moveBy;
	private boolean recursive;
	private CaptureBehavior captureBehavior;
	
	public MoveGenerator(Coordinate moveBy, boolean recursive, CaptureBehavior captureBehavior ){
		this.moveBy = moveBy;
		this.recursive = recursive;
		this.captureBehavior = captureBehavior;
	}
	
	public Set<Coordinate> MoveGenerate(Coordinate piece_location, ChessBoard current_board, ChessColour player_colour){
		HashSet<Coordinate> available_moves= new HashSet<Coordinate>();
		
		Coordinate current_location = piece_location;
		Coordinate next_location = current_location.add(moveBy);

		while (!this.moveBlocked(next_location, current_board, player_colour)){
			available_moves.add(next_location);
			if (!recursive) {
				break;
			}
			current_location = next_location;
			next_location = current_location.add(moveBy);
		}
		return available_moves;
	}
	
	private boolean moveBlocked(Coordinate move, ChessBoard current_board, ChessColour move_colour){
		if (! current_board.InBounds(move)){
			return false;
		} 
		ChessPiece occupant = current_board.PieceAt(move);
		if (occupant == null) {
			return  this.captureBehavior != CaptureBehavior.mandatoryCapture;
		}
		if (occupant.getTeamColour() == move_colour){
				return false;
		}
		return this.captureBehavior != CaptureBehavior.cannotCapture;
		
	}
}
