import java.util.ArrayList;
import java.util.HashMap;

public interface AI {
	//Describes basic functions of the AI
	public MemoryCard[] getCpuMove(ArrayList<MemoryCard> allCards, HashMap<Coordinate, MemoryCard> cardMap,
			ArrayList<Coordinate> coords);
	public int getScore();
	public void incScore();
}
