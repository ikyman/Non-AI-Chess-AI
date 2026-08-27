package moveFunctions.capturing;

import java.awt.Point;

import checkeredBoard.CheckeredBoard;

public class KillOnCapture implements OnCapture{

	@Override
	public void captureEffect(CheckeredBoard game_board, Point capture_point) {
		game_board.clearLocation(capture_point);		
	}

}
