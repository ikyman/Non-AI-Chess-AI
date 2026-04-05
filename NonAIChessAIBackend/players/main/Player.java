package main;

import java.util.Set;

import checkeredBoard.CheckeredBoard;
import pieceMovement.PieceMove;

public interface Player {
	public PieceMove pickMove(CheckeredBoard current_board, Set<PieceMove> RejectedMoves);
}
