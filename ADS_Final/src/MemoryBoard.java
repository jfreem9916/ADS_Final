import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MemoryBoard extends JFrame {
	/**
	 * 
	 */

	private static final long serialVersionUID = -6013876123920190103L;
	private int width, height;
	private int cardSize = 90;
	private JPanel center;
	private Side cpuSide, playerSide;
	private boolean playerCanMove;
	private CPU cpu;
	private ArrayList<MemoryCard> flippedCards;
	private int playerScore;
	private ArrayList<MemoryCard> allCards;
	private HashMap<Coordinate, MemoryCard> cardMap;
	private ArrayList<Coordinate> coords;
	private HUD h;

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
		//Ask what CPU user wants
		String AI = JOptionPane.showInputDialog("Advanced AI(Y/N)?:");
		if (AI != null && AI.trim().equalsIgnoreCase("Y")) {
			cpu = new AdvCPU();
		} else {
			cpu = new CPU();
		}

		playerScore = 0;

		cpuSide = new Side();
		center = new JPanel();
		playerSide = new Side();

		center.setLayout(null);

		h = new HUD(playerScore, cpu.getScore());

		this.add(cpuSide);
		this.add(center);
		this.add(playerSide);
		cpuSide.setBounds(0, 0, 1200, 149);
		center.setBounds(0, 149, 1200, 357);
		playerSide.setBounds(0, 506, 1200, 169);

		center.setBackground(Color.GRAY);

		playerCanMove = true;

		allCards = new ArrayList<MemoryCard>();
		flippedCards = new ArrayList<MemoryCard>();
		cardMap = new HashMap<Coordinate, MemoryCard>();
		coords = new ArrayList<Coordinate>();

		//Creates a stack of cards and shuffles them, then places them on the board
		Stack<MemoryCard> initialCards = new Stack<MemoryCard>();
		initialCards.add(new MemoryCard("red"));
		initialCards.add(new MemoryCard("red"));
		initialCards.add(new MemoryCard("green"));
		initialCards.add(new MemoryCard("green"));
		initialCards.add(new MemoryCard("blue"));
		initialCards.add(new MemoryCard("blue"));
		initialCards.add(new MemoryCard("brown"));
		initialCards.add(new MemoryCard("brown"));
		initialCards.add(new MemoryCard("cyan"));
		initialCards.add(new MemoryCard("cyan"));
		initialCards.add(new MemoryCard("darkgreen"));
		initialCards.add(new MemoryCard("darkgreen"));
		initialCards.add(new MemoryCard("lilac"));
		initialCards.add(new MemoryCard("lilac"));
		initialCards.add(new MemoryCard("maroon"));
		initialCards.add(new MemoryCard("maroon"));
		initialCards.add(new MemoryCard("navy"));
		initialCards.add(new MemoryCard("navy"));
		initialCards.add(new MemoryCard("orange"));
		initialCards.add(new MemoryCard("orange"));
		initialCards.add(new MemoryCard("pink"));
		initialCards.add(new MemoryCard("pink"));
		initialCards.add(new MemoryCard("purple"));
		initialCards.add(new MemoryCard("purple"));
		initialCards.add(new MemoryCard("skyblue"));
		initialCards.add(new MemoryCard("skyblue"));
		initialCards.add(new MemoryCard("white"));
		initialCards.add(new MemoryCard("white"));
		initialCards.add(new MemoryCard("yellow"));
		initialCards.add(new MemoryCard("yellow"));

		Collections.shuffle(initialCards);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				this.addCard(initialCards.pop(), i, j);

			}
		}

	}
	public MemoryBoard(String name){
		super(name);
		this.setResizable(false);
		width = 1200;
		height = 675;
		this.setSize(width, height);
		this.setLayout(null);
		this.setLocation((1600 - width) / 2, (900 - height) / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		String AI = JOptionPane.showInputDialog("Advanced AI(Y/N)?:");
		if (AI != null && AI.trim().equalsIgnoreCase("Y")) {
			cpu = new AdvCPU();
		} else {
			cpu = new CPU();
		}

		playerScore = 0;

		cpuSide = new Side();
		center = new JPanel();
		playerSide = new Side();

		center.setLayout(null);

		h = new HUD(playerScore, cpu.getScore());

		this.add(cpuSide);
		this.add(center);
		this.add(playerSide);
		cpuSide.setBounds(0, 0, 1200, 149);
		center.setBounds(0, 149, 1200, 357);
		playerSide.setBounds(0, 506, 1200, 169);

		center.setBackground(Color.GRAY);

		playerCanMove = true;

		allCards = new ArrayList<MemoryCard>();
		flippedCards = new ArrayList<MemoryCard>();
		cardMap = new HashMap<Coordinate, MemoryCard>();
		coords = new ArrayList<Coordinate>();

		ArrayList<MemoryCard> initialCards = new ArrayList<MemoryCard>();
		initialCards.add(new MemoryCard("red"));
		initialCards.add(new MemoryCard("red"));
		initialCards.add(new MemoryCard("green"));
		initialCards.add(new MemoryCard("green"));
		initialCards.add(new MemoryCard("blue"));
		initialCards.add(new MemoryCard("blue"));
		initialCards.add(new MemoryCard("brown"));
		initialCards.add(new MemoryCard("brown"));
		initialCards.add(new MemoryCard("cyan"));
		initialCards.add(new MemoryCard("cyan"));
		initialCards.add(new MemoryCard("darkgreen"));
		initialCards.add(new MemoryCard("darkgreen"));
		initialCards.add(new MemoryCard("lilac"));
		initialCards.add(new MemoryCard("lilac"));
		initialCards.add(new MemoryCard("maroon"));
		initialCards.add(new MemoryCard("maroon"));
		initialCards.add(new MemoryCard("navy"));
		initialCards.add(new MemoryCard("navy"));
		initialCards.add(new MemoryCard("orange"));
		initialCards.add(new MemoryCard("orange"));
		initialCards.add(new MemoryCard("pink"));
		initialCards.add(new MemoryCard("pink"));
		initialCards.add(new MemoryCard("purple"));
		initialCards.add(new MemoryCard("purple"));
		initialCards.add(new MemoryCard("skyblue"));
		initialCards.add(new MemoryCard("skyblue"));
		initialCards.add(new MemoryCard("white"));
		initialCards.add(new MemoryCard("white"));
		initialCards.add(new MemoryCard("yellow"));
		initialCards.add(new MemoryCard("yellow"));

		Collections.shuffle(initialCards);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				this.addCard(initialCards.get((i * 3) + j), i, j);

			}
		}

	}
	public void addCard(MemoryCard m, int x, int y) {
		//Places a card on the board at x, y
		center.add(m);
		m.setBounds((x * 120) + 10, (y * 125) + 10, cardSize, cardSize);
		m.addMouseListener(new CardClick(m, x, y));
		allCards.add(m);
		Coordinate c = new Coordinate(x, y);
		cardMap.put(c, m);
		coords.add(c);

	}

	public void removeCardPair(MemoryCard m, MemoryCard m2, boolean isPlayer) {
		//Removes matched cards from board and updates CPU's knowledge
		center.remove(m);
		center.remove(m2);
		allCards.remove(m);
		allCards.remove(m2);
		Coordinate toRemove1 = null;
		Coordinate toRemove2 = null;

		for (Coordinate c : coords) {
			if (cardMap.get(c).equals(m)) {
				toRemove1 = c;
			} else if (cardMap.get(c).equals(m2)) {
				toRemove2 = c;
			}
		}
		cardMap.remove(toRemove1);
		cardMap.remove(toRemove2);
		coords.remove(toRemove1);
		coords.remove(toRemove2);
		if (cpu instanceof AdvCPU) {
			((AdvCPU) cpu).clearCards(m, m2);
		}
		if (isPlayer) {
			playerSide.addCard(m);

		} else {
			cpuSide.addCard(m);
		}
		center.repaint();

	}

	public boolean checkIfMatch(boolean isPlayer) {
		//Check if the 2 flipped cards are matches or not, and update score
		if (flippedCards.get(0).matches(flippedCards.get(1))) {
			if (isPlayer) {
				playerScore++;
				h.updatePlayerScore(playerScore);
			} else {
				cpu.incScore();
				h.updateCPUScore(cpu.getScore());
			}
			return true;
		}
		return false;
	}
	
	private class CardClick extends MouseAdapter {
		//Checks if card clicked, flip if it can/is allowed to be
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
				if (cpu instanceof AdvCPU) {
					((AdvCPU) cpu).addCard(myCard, x, y);
				}

				if (flippedCards.size() == 2) {
					playerCanMove = false;
					boolean isMatched = checkIfMatch(true);

					if (!isMatched) {
						//If not match, let cpu go
						Timer t = new Timer();
						t.schedule(new FlipTask(), 1500);
						t.schedule(new ClearTask(), 1510);
						t.schedule(new CpuTask(), 2000);

					} else {
						//Let user go again if match
						Timer t = new Timer();
						t.schedule(new RemoveTask(true), 1500);
						t.schedule(new ClearTask(), 1510);
						t.schedule(new PlayerTask(), 1550);

					}
					if (allCards.size() == 0 || cpu.getScore() > 7 || playerScore > 7) {
						winGame();
					}
				}
			}
		}
	}
	//Timer + task objects allow delays on actions such as putting cards face down again
	//Allows user to see what cpu does
	private class RemoveTask extends TimerTask {
		boolean wasPlayer;

		public RemoveTask(boolean wP) {
			wasPlayer = wP;
		}

		@Override
		public void run() {
			removeCardPair(flippedCards.get(0), flippedCards.get(1), wasPlayer);
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

			MemoryCard[] move = cpu.getCpuMove(allCards, cardMap, coords);
			move[0].setFlipped(true);
			move[1].setFlipped(true);
			/*
			for (Coordinate c : coords) {
				if (cardMap.get(c).equals(move[0])) {
					System.out.println(move[0].getType() + ": " + c);
				}
				if (cardMap.get(c).equals(move[1])) {
					System.out.println(move[1].getType() + ": " + c);
				}
			}
			System.out.println("=====================");
			*/
			flippedCards.add(move[0]);
			flippedCards.add(move[1]);
			boolean isMatched = checkIfMatch(false);
			if (!isMatched) {
				//If not a match, let player go
				Timer t = new Timer();
				t.schedule(new FlipTask(), 1500);
				t.schedule(new ClearTask(), 1510);
				t.schedule(new PlayerTask(), 2000);
			} else {
				//If matched, cpu goes again
				Timer t = new Timer();
				t.schedule(new RemoveTask(false), 1500);
				t.schedule(new ClearTask(), 1510);
				if (allCards.size() == 0 || cpu.getScore() > 7 || playerScore > 7) {
					winGame();
				}
				t.schedule(new CpuTask(), 1550);

			}
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

	public void winGame() {
		//Display winner and end game
		if (playerScore > cpu.getScore()) {
			JOptionPane.showMessageDialog(null, "You win!", "Winner", JOptionPane.INFORMATION_MESSAGE);
		} else if (cpu.getScore() > playerScore) {
			JOptionPane.showMessageDialog(null, "The CPU wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "It's a tie!", "Winner", JOptionPane.INFORMATION_MESSAGE);
		}
		System.exit(0);
	}
}
