import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Ryan Munz
 *
 */
public class lineSweep {
	private BST<Line> status; // The Balanced Binary Search Tree
	private ArrayList<Point> eventList;
	private ArrayList<Intersection> intersectionList;
	private ArrayList<Line> neighbors; // The linked list
	
	public lineSweep(ArrayList<Point> list) {
		eventList = createEventList(list);
		status = new BST<Line>();
		intersectionList = new ArrayList<Intersection>();
		neighbors = new ArrayList<Line>();
	}
	
	public ArrayList<Intersection> generateIntersections() {
		int eindex = 0; // The event list index
		while (eindex < eventList.size()) {
			Point current = eventList.get(eindex);
			
			// Figure out what to do based on the point type
			if (current.getL().isVertical()) { // Vertical Line
				if (current == current.getL().getStart()) {
					status.insert(current.getL());
					addNeighbor(current.getL());
				}
				else {
					status.remove(current.getL());
					neighbors.remove(current.getL());
				}
			}
			else { // Horizontal Line
				if (current == current.getL().getStart()) {
					status.insert(current.getL());
					addNeighbor(current.getL());
					checkForIntersect(current.getL());
				}
				else {
					checkForIntersect(current.getL());
					status.remove(current.getL());
					neighbors.remove(current.getL());
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
	
	/**
	 * 
	 * @param l
	 */
	private void addNeighbor(Line l) {
		if (neighbors.isEmpty()) {
			neighbors.add(l);
		}
		else {
			boolean added = false;
			for (int i = 0; i < neighbors.size(); i++) {
				if (l.getStart().getX() < neighbors.get(i).getStart().getX()) {
					neighbors.add(i, l);
				}
			}
			if (!added) {
				neighbors.add(l);
			}
		}
	}
	
	private void checkForIntersect(Line l) {
		for (int i = neighbors.indexOf(l); i < neighbors.size(); i++) {
			if (l.doesIntersect(neighbors.get(i))) {
				Point iPoint = l.getIntersection(neighbors.get(i));
				Intersection intersect = 
						new Intersection(iPoint, l, neighbors.get(i));
				intersectionList.add(intersect);
			}
		}
	}
	
}
