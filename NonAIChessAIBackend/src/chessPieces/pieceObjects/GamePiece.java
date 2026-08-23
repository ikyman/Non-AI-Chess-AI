package pieceObjects;
import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import main.GameColour;
import pieceMovement.MoveGenerator;
import pieceMovement.PieceMove;

public abstract class GamePiece {
	protected GameColour teamColour;
	protected Set<MoveGenerator> pieceMoves;
	protected int pieceScore;
	
	private VirginityStatus virginity;
	
	protected static final Set<Point> diagonals = new HashSet<>(Arrays.asList(
			new Point(1,1),
			new Point(1,-1),
			new Point(-1,1),
			new Point(-1,-1)
	)); 
	
	protected static final Set<Point> straights = new HashSet<>(Arrays.asList(
			new Point(0,1),
			new Point(0,-1),
			new Point(1,0),
			new Point(-1,0)
	)); 
	
	protected GamePiece(GameColour teamColour, int pieceScore) {
		this.teamColour = teamColour;
		this.pieceScore = pieceScore;
		this.pieceMoves = new HashSet<MoveGenerator>();
		this.virginity = VirginityStatus.hasntMoved;
	}

	public GameColour getTeamColour() {
		return this.teamColour;
	}
	public Set<PieceMove> getMoves(Point piece_location, CheckeredBoard current_board){
		Set<PieceMove> available_moves = new HashSet<PieceMove>();
		for (MoveGenerator mg: pieceMoves) {
			available_moves.addAll(mg.MoveGenerate(piece_location, current_board));
		} 
		return available_moves;
	}
	
	public int getScore() {
		return pieceScore;
	}
	
	protected void addMoveGenerator(MoveGenerator mg){
		pieceMoves.add(mg);
	}
	
	public VirginityStatus getVirginity() {
		return virginity;
	}
}
