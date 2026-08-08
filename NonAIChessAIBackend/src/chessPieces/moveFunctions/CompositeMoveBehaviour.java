package moveFunctions;

import java.util.HashSet;
import java.util.Set;

import pieceMovement.PieceMove;

public class CompositeMoveBehaviour implements moveBehavior {
	
	private Set<moveBehavior> moveBehaviors;
	
	public CompositeMoveBehaviour(){
		this.moveBehaviors = new HashSet<moveBehavior>();
	}
	
	public void addMoveBehavior(moveBehavior mb) {
		this.moveBehaviors.add(mb);
	}

	@Override
	public boolean isMoveValid(PieceMove proposedMove) {
		boolean move_valid = true;
		for (moveBehavior mb: moveBehaviors) {
			move_valid = move_valid && mb.isMoveValid(proposedMove);
		}
		
		// TODO Auto-generated method stub
		return move_valid;
	}

	@Override
	public void moveEffect(PieceMove proposedMove) {
		// TODO Auto-generated method stub
		
	}
}
