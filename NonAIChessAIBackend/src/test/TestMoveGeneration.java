package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import checkeredBoard.CheckeredBoard;
import pieceMovement.ChessMove;
import pieceObjects.ChessPiece;

public class TestMoveGeneration {
	@Test 
	void testNoMovesAvailable() {
        CheckeredBoard board = new CheckeredBoard(3);
        ChessPiece stuckKnight = new Knight();
        Set<ChessMove> all_moves = stuckKnight.getMoves(new Point(2,2), board);
        assertEquals(all_moves.size(),0);
	}
	@Test
	void testMoves() {
		CheckeredBoard board = new CheckeredBoard(3);
        ChessPiece knight_2_moves = new Knight();
        Set<ChessMove> all_moves = stuckKnight.getMoves(new Point(1,1), board);
        assertEquals(all_moves.size(),2);
        Set<Point> move_locations = new HashSet<Point>();
        for (ChessMove cm: all_moves) {
        	move_locations.add(cm.getMove_to());
        }
        assertTrue(move_locations.contains(new Point(2,3)));
        assertTrue(move_locations.contains(new Point(3,2)));
	}
	@Test
	void testRecursiveMoves() {
		CheckeredBoard board = new CheckeredBoard(5,2);
        ChessPiece castle = new Rook();
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
