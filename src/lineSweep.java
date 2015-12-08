import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author Ryan Munz
 *
 */
public class lineSweep {
	private TreeSet<Line> status; // The Balanced Binary Search Tree
	private ArrayList<Point> eventList;
	private ArrayList<Intersection> intersectionList;
	
	public lineSweep(ArrayList<Point> list) {
		eventList = createEventList(list);
		status = new TreeSet<Line>();
		intersectionList = new ArrayList<Intersection>();
	}
	
	public ArrayList<Intersection> generateIntersections() {
		int eindex = 0; // The event list index
		while (eindex < eventList.size()) {
			Point current = eventList.get(eindex);
			
			// Figure out what to do based on the point type
			if (current.getL().isVertical()) { // Vertical Line
				if (current == current.getL().getStart()) {
					status.add(current.getL());
				}
				else {
					status.remove(current.getL());
				}
			}
			else { // Horizontal Line
				if (current == current.getL().getStart()) {
					status.add(current.getL());
					checkForIntersect(current.getL());
				}
				else {
					status.remove(current.getL());
				}
			}
			eindex++;
		}
		return intersectionList;
	}
	
	/**
	 * Creates the event list by performing a merge sort on the given list of 
	 * points.
	 * @param input is the list of points of all the line segments
	 * @return the list of points sorted by their x-coordinate
	 */
	private ArrayList<Point> createEventList(ArrayList<Point> input) {
		mergeSort sorted = new mergeSort(input);
		return sorted.getSorted();
	}
	
	private void checkForIntersect(Line l) {
		Line next = status.higher(l);
		while (next != null) {
			if (next.isVertical() && l.doesIntersect(next)) {
				Point p = l.getIntersection(next);
				Intersection intersect = new Intersection(p,l,next);
				intersectionList.add(intersect);
			}
			next = status.higher(next);
		}
		
		Line prev = status.lower(l);
		while (prev != null && prev.getStart().getX() == l.getStart().getX()) {
			if (prev.isVertical() && l.doesIntersect(prev)) {
				Point p = l.getIntersection(prev);
				Intersection intersect = new Intersection(p,l,prev);
				intersectionList.add(intersect);
			}
			prev = status.lower(prev);
		}
	}
	
}
