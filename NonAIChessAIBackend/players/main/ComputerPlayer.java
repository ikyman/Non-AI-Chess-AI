package main;

import java.awt.Point;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import checkeredBoard.ChessBoard;
import pieceMovement.PieceMove;

public class ComputerPlayer implements Player{
	static final float MIN_POSITION_VALUE = 1;
	static final float MAX_POSITION_VALUE = 5;

	private GameColour Colour;
	private int origOpponentPointValue;
	
	public ComputerPlayer(GameColour Colour, CheckeredBoard starting_board ) {
		this.Colour = Colour;
		this.origOpponentPointValue = this.getTotalEnemyScore(starting_board);	
	}
	
	public PieceMove pickMove(CheckeredBoard current_board, Set<PieceMove> RejectedMoves){
		Set<PieceMove> possible_moves = current_board.getMovesForColour(this.Colour);
		
		PriorityQueue<PieceMove> moveRanker = new PriorityQueue<PieceMove>();
		for (PieceMove pmove : possible_moves ) {
			break;
		}
		throw new RuntimeException("Not Yet Implemented@!");
		//return possible_moves.iterator().next(); Temporary random move, in case Everything non-non-AI-related is done, and I want something, at least something to poke around with.
	}
	
	private double getZoneValue(Point ZoneCoords, CheckeredBoard current_board) {
		double CenterDistance = current_board.DistanceFromCentre(ZoneCoords);
		double HalfBoardDiagonal = current_board.DistanceFromCentre(new Point(1,1));
		double boardDistanceFraction = ( HalfBoardDiagonal- CenterDistance) / (HalfBoardDiagonal);
		
		double centerScoreValue = ComputerPlayer.MAX_POSITION_VALUE * boardDistanceFraction + ComputerPlayer.MIN_POSITION_VALUE*(1 - boardDistanceFraction);
		
		if (current_board instanceof ChessBoard) {
			double scorePercentRemaining = (this.getTotalEnemyScore(current_board))/this.origOpponentPointValue;
			
			/* Currently, the Computer player doesn't know which colour the enemy king is. Use the average of king location distances.
			 * Should work for a Computer player playing against 1 opponent. 
			 * Liable to get confused if there's more than one king. I do not plan to implement 3-player chess, so it shouldn't be a problem.
			 */
			Set<Double> kingDistances = new HashSet<Double>();
			for (GameColour col: GameColour.values() ) {
				Point EnemyKingLocation = ( (ChessBoard)current_board).getKingLocation(col);
				 double kingDistanceFraction = ( 2* HalfBoardDiagonal- EnemyKingLocation.distance(ZoneCoords)) / ( 2*HalfBoardDiagonal);
				 kingDistances.add(kingDistanceFraction);
			}
			double averageKingFrac = kingDistances.stream().reduce(0.0, (Double a, Double b) -> a+b)/kingDistances.size();
			double kingScoreValue = ComputerPlayer.MAX_POSITION_VALUE * averageKingFrac + ComputerPlayer.MIN_POSITION_VALUE*(1 - averageKingFrac);
			
			return (centerScoreValue * scorePercentRemaining + kingScoreValue*(1 - scorePercentRemaining) );
			
		}else {
			return centerScoreValue;
		}
	}
	
	private int getTotalEnemyScore(CheckeredBoard cb) {
		int totalEnemyScore = 0;
		for (GameColour col: GameColour.values() ) {
			if (col == Colour) { continue; };
			totalEnemyScore += cb.PlayersPieceScore(col);
		}
		return totalEnemyScore;
	}
	
}
