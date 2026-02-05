package pieceMovement;

import ChessBoard.ChessBoard;
import ChessBoard.Coordinate;
import moveFunctions.moveValidityChecker;

public class ChessMove {
	private Coordinate move_from;
	private Coordinate move_to;
	private ChessBoard current_board;
	private moveValidityChecker moveValidFunc;
	private void onMoveFunc;
	
	public ChessMove(Coordinate move_from, Coordinate move_to, ChessBoard current_board, moveValidityChecker moveValidFunc, void onMoveFunc) {
		this.move_from = move_from;
		this.move_to = move_to;
		this.current_board = current_board;
		this.moveValidFunc = moveValidFunc;
		this.onMoveFunc = onMoveFunc;
	}
	
	public boolean isMoveValid() {
		return this.moveValidFunc.isMoveValid(this);
	}
	
	public ChessBoard makeMove(){
		if (this.isMoveValid()) {
			
		}
		return this.current_board;
	}
	
	public Coordinate getMove_from() {
		return move_from;
	}

	public Coordinate getMove_to() {
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
				(this.moveValidFunc == other.moveValidFunc) &&
				(this.onMoveFunc == other.onMoveFunc);
	}
	
	@Override
	public int hashCode() {
		return this.move_from.hashCode() + this.move_to.hashCode();
	}
}
