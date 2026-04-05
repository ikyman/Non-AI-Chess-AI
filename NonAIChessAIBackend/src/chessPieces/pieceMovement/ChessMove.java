package pieceMovement;

import java.awt.Point;

import checkeredBoard.ChessBoard;
import moveFunctions.moveBehavior;

public class ChessMove extends PieceMove {
	private Point move_from;
	private Point move_to;
	private ChessBoard current_board;
	private moveBehavior move_effect;
	
	public ChessMove(Point move_from, Point move_to, ChessBoard current_board, moveBehavior move_effect) {
		super(move_from, move_to, current_board, move_effect);
	}
	
	public boolean isMoveValid() {
		return this.move_effect.isMoveValid(this);
	}
	
	public ChessBoard makeMove(){
		if (this.isMoveValid()) {
			
		}
		return this.current_board;
	}
	
	public Point getMove_from() {
		return move_from;
	}

	public Point getMove_to() {
		return move_to;
	}

	public ChessBoard getCurrent_board() {
		return current_board;
	}

	@Override
	public boolean equals(Object objOther) {
		if (!(objOther instanceof ChessMove)){
			return false;
		}
		if ( (this==null && objOther !=null) || (this!=null && objOther ==null)) {
			return false;
		}
		ChessMove other = (ChessMove) objOther;

		return (this.move_from == other.move_from) &&
				(this.move_to == other.move_to) &&
				(this.move_effect == other.move_effect);
	}
	
	@Override
	public int hashCode() {
		return this.move_from.hashCode() + this.move_to.hashCode();
	}
}
