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
	
	public HumanPlayer(GameColour Colour ) {
		this.Colour = Colour;
	}
	
	public PieceMove pickMove(CheckeredBoard current_board, Set<PieceMove> RejectedMoves) {

	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter move (Piece Source Destination): ");
	    String input = scanner.nextLine();

	    String[] parts = input.trim().split("\\s+");

	    if (parts.length != 3) {
	        throw new IllegalArgumentException(
	            "Invalid input. Expected: Piece Source Destination"
	        );
	    }

	    String pieceType = parts[0];
	    String source = parts[1];
	    String destination = parts[2];

	    Point move_from = chessNotationToPoint(source);
	    Point move_to = chessNotationToPoint(destination);
	    
	    throw new RuntimeException("Wuery Piece at move_from for All Possible moves. If there is a move that gets the Piece to move_to, go with that. Otherwise, query user again.");
	}
	
	private Point chessNotationToPoint(String notation) {

	    if (notation == null || notation.length() < 2) {
	        throw new IllegalArgumentException("Invalid square: " + notation);
	    }

	    notation = notation.toUpperCase();

	    char column = notation.charAt(0);

	    // A-Z -> 0-25
	    int x = column - 'A';

	    // Everything after the letter is the row number
	    int y;
	    try {
	        y = Integer.parseInt(notation.substring(1)) - 1;
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Invalid square: " + notation);
	    }

	    if (x < 0 || x > 25 || y < 0) {
	        throw new IllegalArgumentException("Invalid square: " + notation);
	    }

	    return new Point(x, y);
	}

}
