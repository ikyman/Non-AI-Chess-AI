package main;

import java.util.PriorityQueue;
import java.util.Set;

import checkeredBoard.ChessBoard;
import pieceObjects.ChessPiece;
import pieceObjects.King;

public class ComputerPlayer implements Player{
	/*static final float MIN_POSITION_VALUE = 1;
	static final float MAX_POSITION_VALUE = 5;*/

	private ChessColour Colour;
	private int origOpponentPointValue;
	
	public ComputerPlayer(ChessColour Colour, ChessBoard starting_board ) {
		this.Colour = Colour;
	}
	
	public void MakeMove(ChessBoard current_board){
		Set<Point> possible_moves = current_board.getMovesForColour(this.Colour);
		Point EnemyKingLocation = FindEnemyKing(current_board)
		
		PriorityQueue<> = new PriorityQueue<>();
		for (Point pmove : possible_moves ) {
			
		}
	}
	
}
