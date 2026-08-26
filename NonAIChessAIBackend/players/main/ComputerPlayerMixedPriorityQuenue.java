package main;

import java.awt.Point;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import checkeredBoard.ChessBoard;
import pieceMovement.PieceMove;

public class ComputerPlayerMixedPriorityQuenue implements Player{
	static final float MIN_POSITION_VALUE = 1;
	static final float MAX_POSITION_VALUE = 5;

	private GameColour Colour;
	private int origOpponentPointValue;
	
	public ComputerPlayerMixedPriorityQuenue(GameColour Colour, CheckeredBoard starting_board ) {
		this.Colour = Colour;
		this.origOpponentPointValue = this.getTotalEnemyScore(starting_board);	
	}
	
	public PieceMove pickMove(CheckeredBoard current_board, Set<PieceMove> RejectedMoves){
		Set<PieceMove> possible_moves = current_board.getMovesForColour(this.Colour);
		
		PriorityQueue<PieceMove> moveRanker = new PriorityQueue<PieceMove>(new AIMoveComparator(current_board));
		for (PieceMove pmove : possible_moves ) {
			throw new RuntimeException("Comparitor function for Priority Queneu DNE, as no way to summarize Value of kills");
		}
		
		while (moveRanker.size() >= 1) {
			PieceMove chosenMove = moveRanker.poll(); // ! If cannot move, then that'll be a stalemate
			if (!RejectedMoves.contains(chosenMove)) {
				return chosenMove;
			}
		}
		return null;
	}
	
	private double getZoneValue(Point ZoneCoords, CheckeredBoard current_board) {
		double CenterDistance = current_board.DistanceFromCentre(ZoneCoords);
		double HalfBoardDiagonal = current_board.DistanceFromCentre(new Point(1,1));
		double boardDistanceFraction = ( HalfBoardDiagonal- CenterDistance) / (HalfBoardDiagonal);
		
		double centerScoreValue = ComputerPlayerMixedPriorityQuenue.MAX_POSITION_VALUE * boardDistanceFraction + ComputerPlayerMixedPriorityQuenue.MIN_POSITION_VALUE*(1 - boardDistanceFraction);
		
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
			double kingScoreValue = ComputerPlayerMixedPriorityQuenue.MAX_POSITION_VALUE * averageKingFrac + ComputerPlayerMixedPriorityQuenue.MIN_POSITION_VALUE*(1 - averageKingFrac);
			
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
	
	final class AIMoveComparator implements Comparator<PieceMove> {
		private CheckeredBoard board;

		public AIMoveComparator(CheckeredBoard current_board) {
			this.board = current_board;
		}

		@Override
		public int compare(PieceMove o1, PieceMove o2) {
			double o1PositionScore = getZoneValue(o1.getMove_to(), this.board) - getZoneValue(o1.getMove_from(), this.board);
			double o2PositionScore = getZoneValue(o2.getMove_to(), this.board) - getZoneValue(o2.getMove_from(), this.board);
			
			throw new RuntimeException("Obtaining Kill scores not yet Implemented. ");
			double o1KillScore = 0;
			double o2KillScore = 0;

			return (int) ( (o2PositionScore + o2KillScore) - (o1PositionScore + o1KillScore  ));
		}
		
	}
}
