import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Side extends JPanel {
	private ArrayList<MemoryCard> displayOfCards;
	public Side(){
		this.setLayout(null);
		this.setBackground(Color.black);
		displayOfCards = new ArrayList<MemoryCard>();
	}
	public void addCard(MemoryCard m){
		displayOfCards.add(m);
		this.add(m);
		m.setBounds((displayOfCards.size() * 90)+10, 10, 90 ,90);
		m.setFlipped(true);
	}
}
