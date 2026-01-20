package ChessBoard;

public class Coordinate {
	public int x;
	public int y;
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public double Distance(Coordinate other) {
		return Distance(other.x, other.y);
	}	
	public double Distance(double x, double y) {
		return Math.sqrt( Math.pow( (this.x-x) , 2) +  Math.pow((this.y-y) , 2) );
	}

	public Coordinate add(Coordinate other) {
		return new Coordinate(this.x+other.x, this.y+other.y);

	}
}
