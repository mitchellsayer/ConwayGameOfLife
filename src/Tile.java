
public class Tile {
	private int x;
	private int y;
	private boolean state;
	
	public Tile(int w, int h) {
		x = w;
		y = h;
		state = false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean getState() {
		return state;
	}
	
	public void changeState(boolean s) {
		state = s;
	}
	
}
