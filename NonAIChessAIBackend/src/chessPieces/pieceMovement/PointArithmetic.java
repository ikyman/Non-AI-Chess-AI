package pieceMovement;

import java.awt.Point;

public class PointArithmetic {
	public static Point addPoints(Point a, Point b) {
		return new Point(a.x+b.x, a.y+b.y);
	}
	
	public static Point subtractPoints(Point a, Point b) {
		return addPoints(a, scalarMultiply(-1, b));
	}
	
	public static Point scalarMultiply(int scalar, Point p) {
		return new Point(p.x*scalar, p.y*scalar );
	}

}
