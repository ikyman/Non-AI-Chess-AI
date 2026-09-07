package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import checkeredBoard.ChessBoard;
import pieceMovement.PieceMove;

public class PlayChessGame {
	public static void main(String[] args) {
		ChessBoard chessboard = new ChessBoard();
		// Fill out starting locations.

		Player playerWhite = new HumanPlayer(GameColour.WHITE);
		Player playerBlack = new ComputerPlayerMixedPriorityQuenue(GameColour.BLACK, chessboard);
		
		List<Player> players = new ArrayList<Player>( Arrays.asList(playerWhite, playerBlack) );
		int currentPlayer = players.size();
		
		boolean gameWon = false;
		
		while (! gameWon) {
			currentPlayer++;
			if (currentPlayer >= players.size()) {
				currentPlayer = 0;
			}
			PieceMove proposedMove;

			proposedMove = players.get(currentPlayer).pickMove(chessboard);
			
			gameWon = true;
			throw new RuntimeException("Winning and losing. But what about a stalemate?");
		}
	}
}
