import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MemoryBoard extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6013876123920190103L;
	private int width, height;
	private int cardSize = 100;
	private JPanel cpuSide, playerSide, center;
	public MemoryBoard(){
		super("Memory");
		this.setResizable(false);
		width = 1200;
		height = 675;
		this.setSize(width, height);
		this.setLayout(null);
		this.setLocation((1600 - width) / 2, (900 - height) / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		cpuSide = new JPanel();
		center = new JPanel();
		playerSide = new JPanel();
		
		cpuSide.setLayout(null);
		center.setLayout(null);
		playerSide.setLayout(null);

		
		this.add(cpuSide);
		this.add(center);
		this.add(playerSide);
		
		cpuSide.setBounds(0, 0, 1200, 169);
		center.setBounds(0, 168, 1200, 505);
		center.setBounds(0, 505, 1200, 675);
		
		cpuSide.setBackground(Color.DARK_GRAY);
		center.setBackground(Color.GRAY);
		playerSide.setBackground(Color.white);

	}
	
	
	public void addCard(MemoryCard m, int x, int y){
		center.add(m);
		m.setBounds(x, y, cardSize, cardSize);
		m.updatePos(x, y);
	}
	
	
	
}	