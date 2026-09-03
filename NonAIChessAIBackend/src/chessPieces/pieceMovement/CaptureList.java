package pieceMovement;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import moveFunctions.capturing.OnCapture;

public class CaptureList {
	public Map<Point, OnCapture> captures;
	
	public static CaptureList EmptyCaptureList() {
		Map<Point, OnCapture> EmptyMap = new HashMap<Point, OnCapture>();
		return new CaptureList(EmptyMap);		
	}
	
	CaptureList(Map<Point, OnCapture> captures){
		this.captures = captures;
	}

	public CaptureList concat(CaptureList captureList) {
	    Map<Point, OnCapture> result = new HashMap<Point, OnCapture>(this.captures);

	    for (Map.Entry<Point, OnCapture> entry : captureList.captures.entrySet()) {
	        if (result.containsKey(entry.getKey())) {
	            throw new IllegalArgumentException(
	                "Duplicate Point found while concatenating CaptureLists. " +
	                "Future improvement: consider storing a Set<OnCapture> per Point."
	            );
	        }

	        result.put(entry.getKey(), entry.getValue());
	    }

	    return new CaptureList(result);
	}
}
