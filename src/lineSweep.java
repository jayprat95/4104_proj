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
	private ArrayList<Point> points;
	private ArrayList<Line> neighbors;
	
	public lineSweep(ArrayList<Point> list) {
		points = list;
		eventList = createEventList(list);
		status = new BST<Line>();
		intersectionList = new ArrayList<Intersection>();
		neighbors = new ArrayList<Line>();
	}
	
	public ArrayList<Intersection> generateIntersections() {
		int eindex = 0; // The event list index
		
		return intersectionList;
	}
	
	/**
	 * Creates the event list by performin a merge sort on the given list of 
	 * points.
	 * @param input is the list of points of all the line segments
	 * @return the list of points sorted by their x-coordinate
	 */
	private ArrayList<Point> createEventList(ArrayList<Point> input) {
		mergeSort sorted = new mergeSort(input);
		return sorted.getSorted();
	}
	
}
