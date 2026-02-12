package pieceMovement;

import java.awt.Point;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import checkeredBoard.ChessBoard;
import checkeredBoard.Coordinate;
import main.ChessColour;
import moveFunctions.moveBehavior;

public class MoveGenerator {
	private Set<Point> steps;
	private moveBehavior mb;
	private void recurseIf;
	
	public MoveGenerator(Set<Point> steps, moveBehavior mb,  void recurseIf  ){
		this.steps = steps;
		this.mb = mb;
		this.recurseIf = recurseIf;
	}
	
	public Set<ChessMove> MoveGenerate(Point piece_location, ChessBoard current_board, Optional<Point> last_point){
		HashSet<ChessMove> available_moves= new HashSet<ChessMove>();
		
		for (Point step: this.steps) {
			Point new_loc = PointAddition.addPoints( piece_location,  step;);
			if (last_point.isPresent() && new_loc == last_point.get() ) {
				continue;
			}
			ChessMove newMove = new ChessMove(piece_location, new_loc, current_board, this.mb);

			if (recurseIf.canRecurse(newMove) ) {
				available_moves.addAll( this.MoveGenerate(new_loc, current_board, Optional.of(piece_location) ) );
			}
			
		}
		return available_moves;
	}
}
