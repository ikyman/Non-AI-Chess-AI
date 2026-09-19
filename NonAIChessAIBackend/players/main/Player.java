package main;

import checkeredBoard.CheckeredBoard;
import pieceMovement.PieceMove;

public interface Player {
	public PieceMove pickMove(CheckeredBoard current_board);
}
