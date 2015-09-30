
public class Board {
	private int rows;
	private int cols;
	private Tile[][] board;
	
	public Board(int r, int c) {
		rows = r;
		cols = c;
	}
	
	public void initialize() {
		board = new Tile[cols][rows];
		int i, j;
		for (i=0; i<cols;i++) {
			for (j=0; j<rows; j++) {
				Tile n = new Tile(j,i);
				board[i][j] = n;
			}
		}
	}
		
	public Tile[][] getBoard() {
		return board;
	}
}
