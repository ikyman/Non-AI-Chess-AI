package checkeredBoard;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import main.ChessColour;
import pieceMovement.ChessMove;
import pieceObjects.ChessPiece;

// indexing starts at 1; In programming, this is odd, but indexing starting at 0 is non-existant in chessworld.
public class CheckeredBoard {
	protected int x_size;
	protected int y_size;
	
	private Map<Point, ChessPiece> BoardPeices = new HashMap<Point, ChessPiece>();
	
	public CheckeredBoard() {
		createChessBoard(8,8);
	}
	
	public CheckeredBoard(int size) {
		createChessBoard(size,size);
		
	}
	
	public CheckeredBoard(int x_size, int y_size) {
		createChessBoard(x_size, y_size);
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
	
	private void createChessBoard(int x_size, int y_size) {
		this.x_size = x_size;
		this.y_size = y_size;
	}
	
	Set<Point> dangerZone(ChessColour colourInDanger){
		Set<Point> danger_coords = new HashSet<Point>();
		for (ChessColour player : ChessColour.values() ) {
			if (player == colourInDanger){
				continue;
			}
			Set<> player_ZOC = this.getMovesForColour(player);
			
		}
		return danger_coords;
	}
		
	public Set<Point> getMovesForColour(ChessColour colour){
		throw new RuntimeException("Not Yet Implemented!");
		Set<ChessMove> all_moves = new HashSet<>();
		for (Map.Entry<Point, ChessPiece> cp:  BoardPeices.entrySet()) {
			Set<ChessMove> pieceZOC = cp.getValue().getMoves(cp.getKey(), this);
			all_moves += pieceZOC;
		}	
		return all_moves;
	}

	public ChessPiece PieceAt(Point coord) {
		return BoardPeices.get(coord);
	}
	
	
}
