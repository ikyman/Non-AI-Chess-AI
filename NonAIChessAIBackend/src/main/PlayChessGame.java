package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import checkeredBoard.ChessBoard;

public class PlayChessGame {
	public static void main(String[] args) {
		ChessBoard chessboard = new ChessBoard();
		// Fill out starting locations.

		Player playerWhite;
		Player playerBlack;
		
		List<Player> players = new ArrayList<Player>( Arrays.asList(playerWhite, playerBlack) );
		int currentPlayer = players.size();
		
		boolean gameWon = false;
		
		while (! gameWon) {
			currentPlayer++;
			if (currentPlayer >= players.size()) {
				currentPlayer = 0;
			}
			PieceMove proposedMove = players.get(currentPlayer).pickMove(chessboard); //, null);
			
			
			gameWon = true;
		}
	}
}
