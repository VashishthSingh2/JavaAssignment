package assignment3.vashishth.singh;

public class Rectangle {
	private int length,breadth;

	public Rectangle() {
		super();
		this.length = 0;
		this.breadth = 0;
	}
	public Rectangle(int length, int breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", breadth=" + breadth + "]";
	}
	public int getArea() {
		return(length*breadth);
	}
}
