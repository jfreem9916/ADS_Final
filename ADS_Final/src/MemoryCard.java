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
	private int coordX, coordY;
	public MemoryCard(String t, int x, int y){
		type = t;
		this.setLayout(null);
		display = new JLabel();
		front = new ImageIcon(this.getClass().getResource(type + ".png"));
		back = new ImageIcon(this.getClass().getResource("Back.png"));
		display.setIcon(back);
		display.setBounds(0,0, this.getWidth(), this.getHeight());
		coordX = x;
		coordY = y;
	}
	public int getCoordX() {
		return coordX;
	}
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	public int getCoordY() {
		return coordY;
	}
	public void setCoordY(int coordY) {
		this.coordY = coordY;
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
		if(m2.getCoordX() == this.getCoordX() && m2.getCoordY() == this.getCoordY() && m2.getType().equalsIgnoreCase(this.getType())){
			return true;
		}
		return false;
	}
	public void updatePos(int x, int y){
		this.setCoordX(x);
		this.setCoordY(y);

	}
	public void setFlipped(boolean b){
		if(b){
			display.setIcon(back);
		}
		else{
			display.setIcon(front);
		}
	}
}
