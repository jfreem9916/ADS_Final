import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HUD extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3126695164169863743L;
	private JLabel playerHUD, cpuHUD;
	private JPanel panel;
	public HUD(){
		super("HUD");
		panel = new JPanel();
		this.add(panel);
		this.setResizable(false);
		int width = 200;
		int height = 100;
		this.setSize(width, height);
		panel.setLayout(null);
		this.setLocation(1400, 0);
		this.setVisible(true);
		playerHUD = new JLabel();
		cpuHUD = new JLabel();
		playerHUD.setBounds(10, 10, 150, 20);
		cpuHUD.setBounds(10, 40, 150, 20);
		panel.add(playerHUD);
		panel.add(cpuHUD);
	}
	public HUD(int p, int c){
		super("HUD");
		panel = new JPanel();
		this.add(panel);
		this.setResizable(false);
		int width = 200;
		int height = 100;
		this.setSize(width, height);
		panel.setLayout(null);
		this.setLocation(1400, 0);
		this.setVisible(true);
		playerHUD = new JLabel();
		cpuHUD = new JLabel();
		updatePlayerScore(p);
		updateCPUScore(c);
		playerHUD.setBounds(10, 10, 150, 20);
		cpuHUD.setBounds(10, 40, 150, 20);
		panel.add(playerHUD);
		panel.add(cpuHUD);

	}
	public void updatePlayerScore(int i){
		playerHUD.setText("Your score: " + i);

	}
	public void updateCPUScore(int i){
		cpuHUD.setText("CPU score: " + i);

	}
}
