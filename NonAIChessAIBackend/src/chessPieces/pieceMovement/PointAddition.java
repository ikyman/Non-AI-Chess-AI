package pieceMovement;

import java.awt.Point;

public class PointAddition {
	public static Point addPoints(Point a, Point b) {
		return new Point(a.x+b.x, a.y+b.y);
	}

}
