import java.util.HashMap;

public class CPU {
	private HashMap<MemoryCard,Coordinate> knownCards;
	public CPU(){
		knownCards = new HashMap<MemoryCard,Coordinate>();
	}
	
	
	
	
	public void addCard(MemoryCard m, int x, int y){
		double chance = 1/((knownCards.size()^2)/6 + 1);
		double num = Math.random();
		if(num <= chance){
			knownCards.put(m, new Coordinate(x,y));
		}
	}
	
	public Coordinate[] getCpuMove(){
		
	}
}
