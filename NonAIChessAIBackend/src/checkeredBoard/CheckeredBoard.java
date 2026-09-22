package checkeredBoard;

import java.awt.Point;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import main.GameColour;
import pieceMovement.PieceMove;
import pieceObjects.GamePiece;

// indexing starts at 1; In programming, this is odd, but indexing starting at 0 is non-existant in chessworld.
public class CheckeredBoard {
	protected int x_size;
	protected int y_size;
	
	private Map<Point, GamePiece> boardPeices = new HashMap<Point, GamePiece>();
		
	public CheckeredBoard() {
		createCheckeredBoard(8,8);
	}
	
	public CheckeredBoard(int size) {
		createCheckeredBoard(size,size);
		
	}
	
	public CheckeredBoard(int x_size, int y_size) {
		createCheckeredBoard(x_size, y_size);
	}
	
	public boolean InBounds(Point point){
		if (point.x <= 0 || point.y <= 0){
			return false;
		} 
		if (point.x > this.x_size || point.y > this.y_size){
			return false;
		} 
		
		return true;
	}
	
	public double DistanceFromCentre(Point point) {
		double center_x = this.x_size +1 / 2;
		double center_y = this.y_size +1 / 2;
		
		return point.distance(center_x, center_y);
	}
	
	private void createCheckeredBoard(int x_size, int y_size) {
		this.x_size = x_size;
		this.y_size = y_size;
	}
	
	public Set<Point> dangerZone(GameColour colourInDanger){
		Set<Point> danger_coords = new HashSet<Point>();
		for (GameColour player : GameColour.values() ) {
			if (player == colourInDanger){
				continue;
			}
			Set<PieceMove> player_ZOC = this.getMovesForColour(player);
			for (PieceMove possible_move : player_ZOC ) {
				danger_coords.add(possible_move.getMove_to());
			} 
		}
		return danger_coords;
	}
		
	public Set<PieceMove> getMovesForColour(GameColour colour){
		Set<PieceMove> all_moves = new HashSet<>();
		for (Map.Entry<Point, GamePiece> cp:  boardPeices.entrySet()) {
			if (cp.getValue().getTeamColour() != colour) {
				continue;
			}
			Set<PieceMove> pieceZOC = cp.getValue().getMoves(cp.getKey(), this);
			all_moves.addAll(pieceZOC);
		}	
		return all_moves;
	}

	public GamePiece getPieceAt(Point coord) {
		return boardPeices.get(coord);
	}
	
	public void clearPoint(Point p) {
		boardPeices.remove(p);		
	}
	
	public boolean moveFitsGameRules(PieceMove proposed_move) {
		return true;
	}
	
	/* @Returns the sum of all the piece scores for every piece belonging to the player with color colour. 
	 * 
	 * */
	public int PlayersPieceScore(GameColour colour) {
		int pieceScoreSum = 0;
		for (Map.Entry<Point, GamePiece> cp:  boardPeices.entrySet()) {
			if (cp.getValue().getTeamColour() != colour) {
				continue;
			}
			pieceScoreSum += cp.getValue().getScore();
		}
		return pieceScoreSum;
	}

	public void placePiece(GamePiece gamePiece, Point point) throws Exception {
		if (this.boardPeices.get(point) != null) {
			throw new Exception("Piece Already Exists at given Point");
		}
		this.boardPeices.put(point, gamePiece);
		
	}
	
	public int get_y_dim() {
		return y_size;
	}
	
	public void printPieceList(PrintStream out) {
	    for (Map.Entry<Point, GamePiece> entry : boardPeices.entrySet()) {
	        Point point = entry.getKey();
	        GamePiece piece = entry.getValue();

	        out.printf("(%d, %d): %s %s%n",
	                point.x,
	                point.y,
	                piece.getTeamColour(),
	                piece.getClass().getSimpleName());
	    }
	}
	
	@Override
	public CheckeredBoard clone() {
		CheckeredBoard copy = new CheckeredBoard(this.x_size, this.y_size);
		copy.boardPeices = new HashMap<Point, GamePiece>(this.boardPeices);
		return copy;
	}
}
