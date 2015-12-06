import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Ryan Munz
 *
 */
public class lineSweep {
	private BST status;
	private ArrayList<Point> eventList;
	private ArrayList<Intersection> intersectionList;
	private ArrayList<Line> lines;
	
	public lineSweep(ArrayList<Line> list) {
		lines = list;
		createEventList(list);
	}
	
	private void createEventList(ArrayList<Line> input) {
		//TODO
	}
	
}
