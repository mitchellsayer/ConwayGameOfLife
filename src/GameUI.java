import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class GameUI {
	public JFrame frame;
	public JPanel panel;
	public JToggleButton[][] buttons;
	public JToggleButton buton;
	
	public GameUI(int rows, int cols) {
		buttons = new JToggleButton[cols][rows];
		frame = new JFrame("Conway And Suchlike Fanciness Y'all");
		panel = new JPanel();
		buton = new JToggleButton("go");
		for (int i=0;i<cols;i++) {
			for (int j=0;j<rows;j++) {
				buttons[i][j] = new JToggleButton();
				buttons[i][j].setSelected(false);
				buttons[i][j].setPreferredSize(new Dimension(10,10));
				panel.add(buttons[i][j]);
			}
		}
		panel.add(buton);
		frame.add(panel);
		frame.pack();
		frame.setSize(600, 660);
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public JToggleButton[][] getToggleArray() {
		return buttons;
	}
	
	public JToggleButton getGoGoButton() {
		return buton;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
