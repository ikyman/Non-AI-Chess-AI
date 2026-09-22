package moveFunctions.chessExclusive;

import pieceMovement.CaptureList;
import pieceMovement.PieceMove;

public class EnPassant implements moveFunctions.moveBehavior{

	@Override
	public boolean isMoveValid(PieceMove proposedMove) {
		// TODO Auto-generated method stub
		throw new RuntimeError("Ugh, Do I have ot implement a pawn-specific bool for 'did a double-move recently'? Utterly No!");
		return false;
	}


	@Override
	public void moveEffect(PieceMove proposedMove) {
		// TODO Auto-generated method stub
		
	}

}
