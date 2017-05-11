import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Side extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4687343863014431902L;
	private ArrayList<MemoryCard> displayOfCards;
	public Side(){
		this.setLayout(null);
		this.setBackground(Color.black);
		displayOfCards = new ArrayList<MemoryCard>();
	}
	public Side(Color c){
		this.setLayout(null);
		this.setBackground(c);
		displayOfCards = new ArrayList<MemoryCard>();
	}
	public void addCard(MemoryCard m){
		displayOfCards.add(m);
		this.add(m);
		m.setBounds((displayOfCards.size() * 90)+10, 10, 90 ,90);
		m.setFlipped(true);
	}
}
