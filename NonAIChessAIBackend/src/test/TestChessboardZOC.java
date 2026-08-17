package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import checkeredBoard.ChessBoard;
import checkeredBoard.CheckeredBoard;
import main.GameColour;
import pieceObjects.GamePiece;
import pieceObjects.Knight;


public class TestChessboardZOC {
	@Test
    void testOwnPiecesNoDanger() throws Exception {
        CheckeredBoard board = new CheckeredBoard(3);
        GamePiece testKnight = new Knight(GameColour.WHITE);
        board.placePiece(testKnight, new Point(2, 2));
        
        Set<Point> expectDangerZone = new HashSet<>();
        expectDangerZone.add(new Point(0,1));
        expectDangerZone.add(new Point(1,0));
        
        Set<Point> testDangerZone = board.dangerZone(GameColour.WHITE);
        
        assertEquals(testDangerZone.size(), 0);
	}

}
