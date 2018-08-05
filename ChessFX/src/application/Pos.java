package application;

public class Pos {
	private int x,y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Pos() {
		this(0,0);
	}
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
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	public void bounds(int minX, int minY,int maxX, int maxY) {
		if(x < minX) {
			x = minX;
		}
		if(x > maxX) {
			x = maxX;
		}
		if(y < minY) {
			y = minY;
		}
		if(y > maxY) {
			y = maxY;
		}
	}
}
