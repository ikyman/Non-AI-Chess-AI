package ChessBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import ChessBoard.Coordinate;
import main.ChessColour;

// indexing starts at 1; In programming, this is odd, but indexing starting at 0 is non-existant in chessworld.
public class ChessBoard {
	static final float MIN_POSITION_VALUE = 1;
	static final float MAX_POSITION_VALUE = 5;
	int x_size;
	int y_size;
	
	public ChessBoard() {
		createChessBoard(8,8);
	}
	
	public ChessBoard(int size) {
		createChessBoard(size,size);
		
	}
	
	public ChessBoard(int x_size, int y_size) {
		createChessBoard(x_size, y_size);
	}
	
	public double DistanceFromCentre(Coordinate point) {
		double center_x = this.x_size +1 / 2;
		double center_y = this.y_size +1 / 2;
		
		return point.Distance(center_x, center_y);
	}
	
	private void createChessBoard(int x_size, int y_size) {
		this.x_size = x_size;
		this.y_size = y_size;
	}
	
	Set<Coordinate> dangerZone(ChessColour colourInDanger){
		Set<Coordinate> danger_coords = new HashSet<Coordinate>();
		
		for (ChessColour player : ChessColour.values() ) {
			if (player == colourInDanger){
				continue;
			}
		}
		
		return danger_coords;
	}
		
	Set<Coordinate> getMovesForColour(ChessColour colour){
		
		throw new RuntimeException("Not Yet Implemented!");
	}
	
	
}
