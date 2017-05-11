import java.util.ArrayList;
import java.util.HashMap;

public class CPU implements AI{
	protected int score;

	public CPU() {
		score = 0;
	}


	public MemoryCard[] getCpuMove(ArrayList<MemoryCard> allCards, HashMap<Coordinate, MemoryCard> cardMap,
			ArrayList<Coordinate> coords) {
		MemoryCard[] output = new MemoryCard[2];
		int x1 = -1; 
		int x2 = -1;
		int y1 = -1;
		int y2 = -1;

		MemoryCard m1 = null;
		MemoryCard m2 = null;
		while (m1 == null || m2 == null) {
			x1 = (int) (Math.random() * 10);
			x2 = (int) (Math.random() * 10);
			y1 = (int) (Math.random() * 3);
			y2 = (int) (Math.random() * 3);
			while ((x1 == x2 && y1 == y2)) {
				x2 = (int) (Math.random() * 10);
				y2 = (int) (Math.random() * 3);

			}
			for (Coordinate c : coords) {
				if (c.equalsInts(x1, y1)) {
					m1 = cardMap.get(c);

				}
				else if (c.equalsInts(x2, y2)) {
					m2 = cardMap.get(c);

				}
			}
		}
		output[0] = m1;
		output[1] = m2;
		return output;
	}
	public int getScore(){
		return score;
	}
	public void incScore(){
		score++;
	}
}
