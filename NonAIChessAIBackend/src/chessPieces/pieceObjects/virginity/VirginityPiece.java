package pieceObjects.virginity;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import main.GameColour;
import pieceMovement.MoveGenerator;
import pieceMovement.PieceMove;
import pieceObjects.GamePiece;

public abstract class VirginityPiece extends GamePiece{
	private VirginityStatus virginity;
	
	public VirginityPiece(GameColour teamColour, int pieceScore) {
		super(teamColour, pieceScore);
		this.virginity = VirginityStatus.hasntMoved;
	}
	
	protected void addMoveGenerator(MoveGenerator mg){
		pieceMoves.add(mg);
	}

	public VirginityStatus getVirginity() {
		return virginity;
	}

}
