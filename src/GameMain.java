import javax.swing.JToggleButton;

public class GameMain {
	private static int rows = 40;
	private static int cols = 40;
	public static Tile[][] board;
	public static GameUI game;
	public static JToggleButton[][] buttons;
	
	public GameMain() {
		
		game = new GameUI(rows,cols);
		buttons = game.getToggleArray();
		board = initialize(board);
	}
	
	public static void advance(){
		Tile[][] newBoard = initialize(board);
		for(int col=0; col<cols; col++){
			for(int row=0; row<rows; row++){
				newBoard[col][row].changeState(aliveNextRound(board[col][row]));
				buttons[col][row].setSelected(newBoard[col][row].getState());
			}
		}
		board=newBoard;
	}
	
	public static boolean aliveNextRound(Tile t) {
		int n = aliveNeighbors(t.getX(),t.getY());
		if (t.getState()) {
			if (n<2) return false;
			else if (n==2 || n==3) return true;
			else return false;
		} 
		return (!t.getState() && n==3);
	}
	
	public static void main(String[]  args) throws InterruptedException {
		GameMain g = new GameMain();
		while (true) {
			if (game.getGoGoButton().isSelected()) {
				advance();
				Thread.sleep(50);
			} else {
				for (int i=0; i<cols;i++) {
					for (int j=0; j<rows; j++) {
						board[i][j].changeState(buttons[i][j].isSelected());
					}
				}
			}
			
		}
	}
	
	public static int aliveNeighbors(int x, int y) {
		int count = 0;
		//All neighboring tiles 
		Tile[] tiles = {
			board[posMod(x-1,cols)][posMod(y+1,rows)],
			board[posMod(x,cols)][posMod(y+1,rows)],
			board[posMod(x+1,cols)][posMod(y+1,rows)],
			board[posMod(x-1,cols)][posMod(y,rows)],
			board[posMod(x+1,cols)][posMod(y,rows)],
			board[posMod(x-1,cols)][posMod(y-1,rows)],
			board[posMod(x,cols)][posMod(y-1,rows)],
			board[posMod(x+1,cols)][posMod(y-1,rows)],
		};
		for (Tile i: tiles) {
			if (i.getState()) count++;
		}
		return count;
	}
	
	private static int posMod(int x, int y) {
		return ((x%y)+y)%y;
	}
	
	private static Tile[][] initialize(Tile[][] b) {
		b = new Tile[rows][cols];
		int i, j;
		for (i=0; i<cols;i++) {
			for (j=0; j<rows; j++) {
				Tile n = new Tile(i,j);
				n.changeState(buttons[i][j].isSelected());
				b[i][j] = n;
			}
		}
		return b;
	}
}
