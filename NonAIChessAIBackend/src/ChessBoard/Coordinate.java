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
	
	@Override
	public boolean equals(Object objOther) {
		if (!(objOther instanceof Coordinate)){
			return false;
		}
		if ( (this==null && objOther !=null) || (this!=null && objOther ==null)) {
			return false;
		}
		Coordinate other = (Coordinate) objOther;

		return this.x == other.x && this.y == other.y;
	}
	
	@Override
	public int hashCode() {
		// https://stackoverflow.com/questions/22826326/good-hashcode-function-for-2d-coordinates
		int tmp = ( this.y +  ((this.x+1)/2));
        return this.x +  ( tmp * tmp);
	}
}
