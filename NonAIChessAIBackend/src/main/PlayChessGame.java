package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import checkeredBoard.ChessBoard;
import pieceMovement.PieceMove;
import pieceObjects.*;

public class PlayChessGame {
	public static void main(String[] args) throws Exception {
		ChessBoard chessboard = new ChessBoard();
		// Fill out starting locations.
		chessboard.placePiece(new Rook(GameColour.WHITE), new Point(1,1));
		chessboard.placePiece(new Knight(GameColour.WHITE), new Point(2,1));
		
		chessboard.placePiece(new Queen(GameColour.WHITE), new Point(4,1));
		chessboard.placePiece(new King(GameColour.WHITE), new Point(5,1));
		

		chessboard.placePiece(new Knight(GameColour.WHITE), new Point(7,1));
		chessboard.placePiece(new Rook(GameColour.WHITE), new Point(8,1));
		
		chessboard.placePiece(new Rook(GameColour.BLACK), new Point(1,8));
		chessboard.placePiece(new Knight(GameColour.BLACK), new Point(2,8));
		
		chessboard.placePiece(new Queen(GameColour.BLACK), new Point(4,8));
		chessboard.placePiece(new King(GameColour.BLACK), new Point(5,8));
		

		chessboard.placePiece(new Knight(GameColour.BLACK), new Point(7,8));
		chessboard.placePiece(new Rook(GameColour.BLACK), new Point(8,8));

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
			
			chessboard.printPieceList(System.out);
			
			proposedMove = players.get(currentPlayer).pickMove(chessboard);
						
			if (proposedMove == null) {
				gameWon = true;
				break;
			}
			
			chessboard = (ChessBoard) proposedMove.makeMove();
		}
		
		if (  chessboard.dangerZone(GameColour.WHITE).contains(chessboard.getKingLocation(GameColour.WHITE)) ) {
			System.out.println("Black Wins!");
		}else if (  chessboard.dangerZone(GameColour.BLACK).contains(chessboard.getKingLocation(GameColour.BLACK)) ) {
			System.out.println("White Wins!");
		}else {
			System.out.println("Stalemate!");		
		}
	}
}
