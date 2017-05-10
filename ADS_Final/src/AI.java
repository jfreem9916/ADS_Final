import java.util.ArrayList;
import java.util.HashMap;

public interface AI {
	public MemoryCard[] getCpuMove(ArrayList<MemoryCard> allCards, HashMap<Coordinate, MemoryCard> cardMap,
			ArrayList<Coordinate> coords);
}
