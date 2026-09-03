package pieceMovement;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import moveFunctions.capturing.KillOnCapture;
import moveFunctions.capturing.OnCapture;

public class KnownMovements {
	public static final Set<Point> diagonals = new HashSet<>(Arrays.asList(
			new Point(1,1),
			new Point(1,-1),
			new Point(-1,1),
			new Point(-1,-1)
	)); 
	
	public static final Set<Point> verticals = new HashSet<>(Arrays.asList(
			new Point(0,1),
			new Point(0,-1)
	)); 
	public static final Set<Point> horizontals = new HashSet<>(Arrays.asList(
			new Point(1,0),
			new Point(-1,0)
	));  
	
	public static final Map<Point,CaptureList> KillCaptureWhereMove(Set<Point> move_locations){
		Map<Point,CaptureList> ret_map = new HashMap<Point,CaptureList>();
		for (Point move_location: move_locations) {
			Map<Point,OnCapture> capture_point_map = new HashMap<Point,OnCapture>();
			capture_point_map.put(move_location, new KillOnCapture());
			ret_map.put(move_location, new CaptureList(capture_point_map));
		}
		return ret_map;		
	}
}
