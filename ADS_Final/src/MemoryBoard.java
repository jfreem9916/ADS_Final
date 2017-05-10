import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MemoryBoard extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6013876123920190103L;
	private int width, height;
	private int cardSize = 90;
	private JPanel cpuSide, playerSide, center;
	private boolean playerCanMove;
	private CPU cpu;
	private ArrayList<MemoryCard> flippedCards;
	private int cpuScore, playerScore;
	private JLabel playerHUD;
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

		cpuScore = 0;
		playerScore = 0;

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

		playerHUD = new JLabel();
		
		playerSide.add(playerHUD);
		playerHUD.setBounds(0, 0, 300, 30);
		playerHUD.setText("Your score: " + playerScore);
		
		playerCanMove = true;

		flippedCards = new ArrayList<MemoryCard>();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				this.addCard(new MemoryCard("test"), i, j);

			}
		}

		cpu = new CPU();

	}

	public void addCard(MemoryCard m, int x, int y) {
		center.add(m);
		m.setBounds((x * 120) + 10, (y * 125) + 10, cardSize, cardSize);
		m.addMouseListener(new CardClick(m, x, y));
	}

	public void removeCardPair(MemoryCard m, MemoryCard m2) {
		Component[] comps = center.getComponents();
		for (int i = 0; i < comps.length; i++) {

			if (comps[i] instanceof MemoryCard) {
				MemoryCard m3 = (MemoryCard) comps[i];
				if (m3.equals(m) || m3.equals(m2)) {
					comps[i] = null;
					i--;
				}
			}
		}
	}

	public void checkIfMatch(boolean isPlayer) {
		if (flippedCards.get(0).matches(flippedCards.get(1))) {
			removeCardPair(flippedCards.get(0), flippedCards.get(1));
			if (isPlayer) {
				playerScore++;
				playerHUD.setText("Your score: " + playerScore);
			} else {
				cpuScore++;
			}
		} else {

		}
		flippedCards.clear();
	}

	private class CardClick extends MouseAdapter {
		private MemoryCard myCard;
		private int x, y;

		public CardClick(MemoryCard m, int x, int y) {
			myCard = m;
			this.x = x;
			this.y = y;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (playerCanMove && !myCard.isFlipped()) {
				myCard.setFlipped(true);
				flippedCards.add(myCard);
				cpu.addCard(myCard, x, y);
				if (flippedCards.size() == 2) {
					playerCanMove = false;
					checkIfMatch(true);
				}
			}
		}
	}

}
