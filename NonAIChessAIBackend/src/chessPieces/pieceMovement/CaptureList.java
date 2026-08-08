package pieceMovement;

import java.awt.Point;
import java.util.Set;

public class CaptureList {
	private Set<Point> optionalCaptures;
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
