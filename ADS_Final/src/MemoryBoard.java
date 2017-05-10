import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

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
	private JLabel playerHUD, cpuHUD;
	private ArrayList<MemoryCard> allCards;
	private HashMap<Coordinate, MemoryCard> cardMap;
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
		cpuHUD = new JLabel();
		cpuHUD.setForeground(Color.white);
		
		playerSide.add(playerHUD);
		playerHUD.setBounds(10, 0, 300, 30);
		playerHUD.setText("Your score: " + playerScore);

		cpuSide.add(cpuHUD);
		cpuHUD.setBounds(10, 0, 300, 30);
		cpuHUD.setText("CPU score: " + cpuScore);
		
		playerCanMove = true;

		allCards = new ArrayList<MemoryCard>();
		flippedCards = new ArrayList<MemoryCard>();
		cardMap = new HashMap<Coordinate, MemoryCard>();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				this.addCard(new MemoryCard("test"+j), i, j);

			}
		}

		cpu = new CPU();

	}

	public void addCard(MemoryCard m, int x, int y) {
		center.add(m);
		m.setBounds((x * 120) + 10, (y * 125) + 10, cardSize, cardSize);
		m.addMouseListener(new CardClick(m, x, y));
		allCards.add(m);
		cardMap.put(new Coordinate(x, y), m);
	}

	public void removeCardPair(MemoryCard m, MemoryCard m2) {
		center.remove(m);
		center.remove(m2);
		center.repaint();

	}

	public boolean checkIfMatch(boolean isPlayer) {
		if (flippedCards.get(0).matches(flippedCards.get(1))) {
			if (isPlayer) {
				playerScore++;
				playerHUD.setText("Your score: " + playerScore);
			} else {
				cpuScore++;
			}
			return true;
		}
		return false;
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
					boolean isMatched = checkIfMatch(true);

					if (!isMatched) {
						
						Timer t = new Timer();
						t.schedule(new FlipTask(), 1000);
						t.schedule(new ClearTask(), 1010);
						t.schedule(new CpuTask(), 1500);
					} else {
						Timer t = new Timer();
						t.schedule(new RemoveTask(), 1000);
						t.schedule(new ClearTask(), 1010);
						t.schedule(new PlayerTask(), 1020);

					}

				}
			}
		}
	}

	private class RemoveTask extends TimerTask {
		@Override
		public void run() {
			removeCardPair(flippedCards.get(0), flippedCards.get(1));
		}
	}

	private class ClearTask extends TimerTask {
		@Override
		public void run() {
			flippedCards.clear();
		}
	}
	private class PlayerTask extends TimerTask {
		@Override
		public void run() {
			playerCanMove = true;
		}
	}
	private class CpuTask extends TimerTask {
		@Override
		public void run() {
			MemoryCard[] move = cpu.getCpuMove(allCards, cardMap);
			move[0].setFlipped(true);
			move[1].setFlipped(true);

		}
	}
	private class FlipTask extends TimerTask {
		@Override
		public void run() {
			for (MemoryCard c : flippedCards) {
				c.setFlipped(false);
			}
		}
	}

}
