package test;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ChessBoard.ChessBoard;
import ChessBoard.Coordinate;
import checkeredBoard.CheckeredBoard;


public class TestChessboardZOC {
	@Test
    void testDangerZoneForWhitePlayer() {
        CheckeredBoard board = new CheckeredBoard(3);
        board.placePiece(new Knight(PlayerColor.WHITE), new Point(2, 2));
        
        Set<Point> expected = new HashSet<>();

}
