public class A implements Greeter{
	private int x;
	private int y;

	public A() {}

	public A(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "A{" +
				"x=" + this.x +
				", y=" + this.y +
				'}';
	}
}
