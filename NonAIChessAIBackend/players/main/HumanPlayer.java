package main;

import java.awt.Point;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import checkeredBoard.ChessBoard;
import pieceMovement.PieceMove;

public class HumanPlayer implements Player{
	private GameColour Colour;
	
	public HumanPlayer(GameColour Colour, CheckeredBoard starting_board ) {
		this.Colour = Colour;
	}
	
	public PieceMove pickMove(CheckeredBoard current_board, Set<PieceMove> RejectedMoves){
		throw new RuntimeException("Not Yet Implemented@!");
	}

}
