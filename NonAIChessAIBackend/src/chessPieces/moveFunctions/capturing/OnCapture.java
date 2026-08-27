package moveFunctions.capturing;

import java.awt.Point;

import checkeredBoard.CheckeredBoard;

public interface OnCapture {
	void captureEffect(CheckeredBoard game_board, Point capture_point);
}
