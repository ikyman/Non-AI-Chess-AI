package main;

import java.awt.Point;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import checkeredBoard.ChessBoard;
import pieceMovement.PieceMove;
import pieceObjects.GamePiece;

public class HumanPlayer implements Player{
	private GameColour Colour;
	
	public HumanPlayer(GameColour Colour ) {
		this.Colour = Colour;
	}
	
	public PieceMove pickMove(CheckeredBoard current_board) {
		if (!current_board.InBounds(new Point(26, 0))) {
			throw new RuntimeException("Chess notation impossible because Board Width exceeds number of letters in alphabet.");
			// Using the board inbounds instead of querying the size directly? The 26 magic number? Both are problematic decisions.
		}

	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter move (Source Destination): ");
	    String input = scanner.nextLine();
	    
	    scanner.close();

	    String[] parts = input.trim().split("\\s+");

	    if (parts.length != 2) {
	        throw new IllegalArgumentException(
	            "Invalid input. Expected: Piece Source Destination"
	        );
	    }

	    String source = parts[0];
	    String destination = parts[1];

	    Point move_from = chessNotationToPoint(source);
	    Point move_to = chessNotationToPoint(destination);
	    
	    GamePiece moved_piece = current_board.getPieceAt(move_from);
	    
	    Set<PieceMove> possible_moves = moved_piece.getMoves(move_from, current_board);
	    
	    for ( PieceMove possible_move : possible_moves) {
	    	if (possible_move.getMove_to() == move_to && possible_move.isMoveValid()){
	    		return possible_move;
	    	}
	    }
	    
	    return null;
	    
	    throw new RuntimeException("... Not ideal. It looks like the 'Null' return value means different info for humans & priority Quenue. Priority Quenue = no more moves, stalemate me."
	    		+ "For Humans, it means the dunderhead input an illegitimate move.");
	}
	
	
	// AI Generated. If it doesn't work, give the AI a good smackin'.
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
