package main;

import java.awt.Point;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import checkeredBoard.CheckeredBoard;
import pieceMovement.PieceMove;

/* I don't remember a single commit on for HumanPlayer that wasn't me tasking AI with something.
 * I am forced to dub this class as "AI Written". AI Written with oversight, but AI written nonetheless.
 * 
 * Ironic
 */
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

		Set<PieceMove> legalMoves = new HashSet<PieceMove>();
		for (PieceMove possible_move : current_board.getMovesForColour(this.Colour)) {
			if (possible_move.isMoveValid()) {
				legalMoves.add(possible_move);
			}
		}
		if (legalMoves.isEmpty()) {
			return null;
		}

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter move (Source Destination): ");
			String input = scanner.nextLine();
			String[] parts = input.trim().split("\\s+");

			if (parts.length != 2) {
				System.out.println("Invalid input. Expected: Source Destination");
				continue;
			}

			Point move_from;
			Point move_to;
			try {
				move_from = chessNotationToPoint(parts[0]);
				move_to = chessNotationToPoint(parts[1]);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				continue;
			}

			for (PieceMove possible_move : legalMoves) {
				if (possible_move.getMove_from().equals(move_from)
						&& possible_move.getMove_to().equals(move_to)) {
					return possible_move;
				}
			}

			System.out.println("That is not a legal move. Try again.");
		}
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
