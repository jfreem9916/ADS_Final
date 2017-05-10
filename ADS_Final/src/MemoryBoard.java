import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MemoryBoard extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6013876123920190103L;
	private int width, height, cardsFlipped;
	private int cardSize = 90;
	private JPanel cpuSide, playerSide, center;
	private boolean playerCanMove;
	private HashMap<String, MemoryCard> cards;
	public MemoryBoard() {
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

		cpuSide.setBounds(0, 0, 1200, 149);
		center.setBounds(0, 149, 1200, 357);
		playerSide.setBounds(0, 506, 1200, 169);

		cpuSide.setBackground(Color.DARK_GRAY);
		center.setBackground(Color.GRAY);
		playerSide.setBackground(Color.WHITE);

		playerCanMove = true;
		cardsFlipped = 0;
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				this.addCard(new MemoryCard("test"), i, j);
				
			}
		}

	}

	public void addCard(MemoryCard m, int x, int y) {
		center.add(m);
		m.setBounds((x * 120) + 10, (y * 125) + 10, cardSize, cardSize);
		m.updatePos(x, y);
		m.addMouseListener(new CardClick(m));
		
	}
	
	
	private class CardClick extends MouseAdapter{
		private MemoryCard myCard;
		public CardClick(MemoryCard m){
			myCard = m;
		}
		@Override
		public void mousePressed(MouseEvent e){
			if(playerCanMove && !myCard.isFlipped()){
				myCard.setFlipped(true);
				cardsFlipped++;
				if(cardsFlipped == 2){
					playerCanMove = false;
				}
			}
		}
	}

}
