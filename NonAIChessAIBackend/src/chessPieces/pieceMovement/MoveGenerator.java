package pieceMovement;

import java.awt.Point;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import moveFunctions.moveBehavior;
import moveFunctions.recurseIf;

public class MoveGenerator {
	private Map<Point,CaptureList> moves_captures;
	private moveBehavior mb;
	private recurseIf ri;
	
	public MoveGenerator(Map<Point,CaptureList> moves_captures, moveBehavior mb, recurseIf ri  ){
		this.moves_captures = moves_captures;
		this.mb = mb;
		this.ri = ri;
	}
	
	public Set<PieceMove> MoveGenerate(Point piece_location, CheckeredBoard current_board){
		return MoveGenerate(piece_location, current_board, null, new CaptureList());
	}
	
	private Set<PieceMove> MoveGenerate(Point piece_location, CheckeredBoard current_board, Optional<Point> last_point, CaptureList capturesSoFar){
		HashSet<PieceMove> available_moves= new HashSet<PieceMove>();
		
		for (Point step: this.moves_captures.keySet()) {
			Point new_loc = PointArithmetic.addPoints( piece_location,  step);
			if (last_point.isPresent() && new_loc == last_point.get() ) {
				continue;
			}
			CaptureList move_captures = capturesSoFar.concat(moves_captures.get(step));
			PieceMove newMove = new PieceMove(piece_location, new_loc, current_board, this.mb, move_captures);
			if (! this.mb.isMoveValid(newMove) ) {
				continue;
			}

			if (this.ri.canRecurse(newMove) ) {
				available_moves.addAll( this.MoveGenerate(new_loc, current_board, Optional.of(piece_location), newMove.getCaptures() ) );
			}
			available_moves.add(newMove);
			
		}
		return available_moves;
	}
}
