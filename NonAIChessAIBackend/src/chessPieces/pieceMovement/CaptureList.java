package pieceMovement;

import java.awt.Point;
import java.util.Map;
import java.util.Set;

import moveFunctions.capturing.OnCapture;

public class CaptureList {
	private Map<Point, OnCapture> captures;
	private Set<Point> mandatoryCaptures;
	
	public void addOptionalCapture(Point p){
		optionalCaptures.add(p);
	}
	public void addMandatoryCapture(Point p){
		mandatoryCaptures.add(p);
	}
	
	public Set<Point> getOptionalCaptures(){
		return optionalCaptures;
	}
	
	public Set<Point> getMandatoryCaprutes(){
		return mandatoryCaptures;
	}

}
