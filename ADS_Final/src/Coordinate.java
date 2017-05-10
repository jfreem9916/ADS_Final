
public class Coordinate {
	private int x,y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	public boolean equalsInts(int x, int y){
		return this.x == x && this.y == y;
	}
	@Override 
	public boolean equals(Object o){
		if(!(o instanceof Coordinate)){
			return false;
		}
		Coordinate c = (Coordinate) o;
		return (c.getX() == x && c.getY() == y);
	}
}
