import java.util.ArrayList;
import java.util.HashMap;

public class CPU {
	private HashMap<MemoryCard, Coordinate> knownCards;

	public CPU() {
		knownCards = new HashMap<MemoryCard, Coordinate>();
	}

	public void addCard(MemoryCard m, int x, int y) {
		double chance = 1 / ((knownCards.size() ^ 2) / 6 + 1);
		double num = Math.random();
		if (num <= chance) {
			knownCards.put(m, new Coordinate(x, y));
		}
	}

	public MemoryCard[] getCpuMove(ArrayList<MemoryCard> allCards, HashMap<Coordinate, MemoryCard> cardMap) {
		MemoryCard[] output = new MemoryCard[2];
		ArrayList<String> knownTypes = new ArrayList<String>();
		ArrayList<Integer> knownIndices = new ArrayList<Integer>();
		for (int i = 0; i < allCards.size(); i++) {
			MemoryCard m = allCards.get(i);
			if (knownCards.get(m) != null) {
				knownTypes.add(m.getType());
				knownIndices.add(i);
			}
		}
		for (int i = 0; i < knownTypes.size(); i++) {
			for (int j = 0; j < knownTypes.size(); j++) {
				String str1 = knownTypes.get(i);
				String str2 = knownTypes.get(j);
				if (str1.equals(str2) && i != j) {
					MemoryCard c1 = allCards.get(knownIndices.get(i));
					MemoryCard c2 = allCards.get(knownIndices.get(j));
					output[0] = c1;
					output[1] = c2;
					return output;

				}
			}
		}
		
		
		int x1, x2, y1, y2;
		

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
			m1 = cardMap.get(new Coordinate(x1, y1));
			m2 = cardMap.get(new Coordinate(x2, y2));

			for (int i = 0; i < allCards.size(); i++) {
				MemoryCard m = allCards.get(i);
				if (knownCards.get(m) != null) {
					Coordinate c = knownCards.get(m);
					if(c.equalsInts(x1, y1)){
						m1 = null;
					}
					if(c.equalsInts(x2, y2)){
						m2 = null;

					}
				}
			}
			System.out.println("not stuck here hopefully");
		}
		output[0] = m1;
		output[1] = m2;
		
		return output;
	}
}
