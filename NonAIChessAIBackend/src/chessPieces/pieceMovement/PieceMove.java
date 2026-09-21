package pieceMovement;

import java.awt.Point;

import checkeredBoard.CheckeredBoard;
import moveFunctions.moveBehavior;
import pieceObjects.GamePiece;

public class PieceMove {
	protected Point move_from;
	protected Point move_to;
	private CheckeredBoard current_board;
	protected moveBehavior move_effect;
	
	private CaptureList captures;
	
	public PieceMove(Point move_from, Point move_to, CheckeredBoard current_board, moveBehavior move_effect, CaptureList captures) {
		this.move_from = move_from;
		this.move_to = move_to;
		this.current_board = current_board;
		this.move_effect = move_effect;
		this.captures = captures;
	}
	
	public boolean isMoveValid() {
		return this.move_effect.isMoveValid(this);
	}
	
	public CheckeredBoard makeMove() throws Exception{ 
		if (this.isMoveValid()) {
			for (Point capture_point: this.getCaptures().captures.keySet()) {
				this.getCaptures().captures.get(capture_point).captureEffect(current_board, capture_point);				
			}
			GamePiece moved_piece = this.current_board.getPieceAt(move_from);
			moved_piece.DemoteVirginity();
			this.current_board.clearPoint(this.move_from);
			this.current_board.placePiece(moved_piece, this.move_to);
			this.move_effect.moveEffect(this);


		}
		return this.current_board;
	}
	
	public Point getMove_from() {
		return move_from;
	}

	public Point getMove_to() {
		return move_to;
	}

	public CheckeredBoard getCurrent_board() {
		return current_board;
	}
	
	@Override
	public boolean equals(Object objOther) {
		if (!(objOther instanceof PieceMove)){
			return false;
		}
		if ( (this==null && objOther !=null) || (this!=null && objOther ==null)) {
			return false;
		}
		PieceMove other = (PieceMove) objOther;

		return (this.move_from == other.move_from) &&
				(this.move_to == other.move_to) &&
				(this.move_effect == other.move_effect);
	}
	
	@Override
	public int hashCode() {
		return this.move_from.hashCode() + this.move_to.hashCode();
	}

	public CaptureList getCaptures() {
		return this.captures;
	}
}
