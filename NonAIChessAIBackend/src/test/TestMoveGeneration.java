package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import checkeredBoard.CheckeredBoard;
import main.GameColour;
import pieceMovement.ChessMove;
import pieceMovement.PieceMove;
import pieceObjects.Knight;
import pieceObjects.GamePiece;

public class TestMoveGeneration {
	/* TODO: I foresee it quite likely that I fail to add "This point IS NOT within the possible moves of a piece"
	 Not Good: Where a missile is not is about as important as where the missile is. */
	@Test 
	void testNoMovesAvailable() {
        CheckeredBoard board = new CheckeredBoard(3);
        GamePiece stuckKnight = new Knight(GameColour.WHITE);
        Set<PieceMove> all_moves = stuckKnight.getMoves(new Point(2,2), board);
        assertEquals(all_moves.size(),0);
	}
	@Test
	void testMoves() {
		CheckeredBoard board = new CheckeredBoard(3);
		GamePiece knight_2_moves = new Knight(GameColour.WHITE);
        Set<PieceMove> all_moves = knight_2_moves.getMoves(new Point(1,1), board);
        assertEquals(all_moves.size(),2);
        Set<Point> move_locations = new HashSet<Point>();
        for (PieceMove cm: all_moves) {
        	move_locations.add(cm.getMove_to());
        }
        assertTrue(move_locations.contains(new Point(2,3)));
        assertTrue(move_locations.contains(new Point(3,2)));
        
        assertFalse(move_locations.contains(new Point(1,1)));
        assertFalse(move_locations.contains(new Point(3,3)));
	}
	@Test
	void testRecursiveMoves() {
		CheckeredBoard board = new CheckeredBoard(5,2);
		GamePiece castle = new Rook();
        Set<ChessMove> all_moves = castle.getMoves(new Point(2,2), board);
        assertEquals(all_moves.size(),5);
        Set<Point> move_locations = new HashSet<Point>();
        for (ChessMove cm: all_moves) {
        	move_locations.add(cm.getMove_to());
        }
        assertTrue(move_locations.contains(new Point(5,2)));
        assertTrue(move_locations.contains(new Point(2,1)));
	}
	
	void testConditionalRecursion(){
		// I.E Stops if hits pawn
		
	}
}
