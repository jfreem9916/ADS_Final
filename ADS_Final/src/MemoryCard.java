import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MemoryCard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6739799805092076482L;
	private String type;
	private ImageIcon front, back;
	private JLabel display;
	private boolean flipped;
	
	public MemoryCard(String t){
		type = t;
		this.setLayout(null);
		display = new JLabel();
		this.add(display);
		front = new ImageIcon(this.getClass().getResource(type + ".png"));
		back = new ImageIcon(this.getClass().getResource("back.png"));
		display.setIcon(back);
		display.setBounds(0,0, 90, 90);
		flipped = false;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public boolean equals(Object o){
		if(!(o instanceof MemoryCard)){
			return false;
		}
		MemoryCard m2 = (MemoryCard) o;
		if(m2.getBounds().equals(this.getBounds()) && m2.getType().equalsIgnoreCase(this.getType())){
			return true;
		}
		return false;
	}

	public void setFlipped(boolean b){
		flipped = b;
		if(b){
			display.setIcon(front);
		}
		else{
			display.setIcon(back);
		}
	}
	public boolean isFlipped(){
		return flipped;
	}

	public boolean matches(MemoryCard memoryCard) {
		if(memoryCard.getType().equalsIgnoreCase(type)){
			return true;
		}
		return false;
	}
}
