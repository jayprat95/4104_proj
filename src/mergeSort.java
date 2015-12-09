import java.util.ArrayList;

/**
 * This class takes a list of points that represent vertical and horizontal and
 * performs a merge sort on the points to sort them by their Y value in 
 * descending order. Then the points with the same Y values are then sorted by
 * precedence where Vertical start points have the highest, horizontal start 
 * points are next, finally the vertical or horizontal end points. The newly
 * sorted list is then returned.
 */

/**
 * @author RyanWork
 *
 */
public class mergeSort {
	private ArrayList<Point> points;
	private ArrayList<Point> sorted;
	
	public mergeSort(ArrayList<Point> p) {
		points = p;
		sorted = sort(points);
		sorted = endPointCheck(sorted);
	}
	
	/**
	 * For all points that have the same y value, this function then sets 
	 * precedence so that Vertical Start points have the highest precedence, 
	 * horizontal start is next, finally the vertical or horizontal end points.
	 * 
	 * @param p the list that is merge sorted
	 */
	private ArrayList<Point> endPointCheck(ArrayList<Point> list) {
		int pindex = 0;
		ArrayList<Point> p = list;
		while (pindex < p.size()) {
			ArrayList<Point> group = new ArrayList<Point>();
			int start = pindex;
			int end = pindex;
			Point current = p.get(start);
			Point next;
			if (end + 1 >= p.size()) {
				next = null;
			}
			else {
				next = p.get(end+1);
			}
			group.add(current);
			
			while (next != null && next.getY() == current.getY()) {
				group.add(next);
				end++;
				if (end + 1 >= p.size()) {
					next = null;
				}
				else {
					next = p.get(end+1);
				}
			}
			
			
			if (group.size() > 1) {
				ArrayList<Point> gsort= sortGroup(group);
				for (int i = 0; i < gsort.size(); i++) {
					p.set(start + i, gsort.get(i));
				}
				pindex = end;
			}
			pindex++;
		}
		return p;
	}
	
	/**
	 * Sorts the sub-group by precedence.
	 * @param g the sub group that have the same Y value
	 * @return the newly sorted list
	 */
	private ArrayList<Point> sortGroup(ArrayList<Point> g) {
		ArrayList<Point> sorted = new ArrayList<Point>();
		sorted.add(g.get(0));
		for (int i = 1; i < g.size(); i++) {
			Point current = g.get(i);
			boolean insert = false;
			for (int j = 0; j < sorted.size(); j++) {
				// If point to add is a vertical start point.
				if (current.getL().isVertical() 
						&& current.getL().getStart() == current) {
					// If the point in the sorted array is not a vertical start 
					// point with a smaller x, we will insert at position j.
					if (!(sorted.get(j).getL().isVertical() 
							&& sorted.get(j).getL().getStart() == sorted.get(j)
							&& current.getX() > sorted.get(j).getX())) {
						sorted.add(j, current);
						insert = true;
						break;
					}
				}
				// If point to add is a horizontal start point
				else if (!current.getL().isVertical() 
						&& current.getL().getStart() == current) {
					// If the point in the sorted array is not a vertical start 
					// point OR a horizontal start point with a smaller x, we 
					// will insert at position j.
					if (!((sorted.get(j).getL().isVertical() && sorted.get(j).getL().getStart() == sorted.get(j)) 
							|| (!sorted.get(j).getL().isVertical() && sorted.get(j).getL().getStart() == sorted.get(j) && current.getX() > sorted.get(j).getX()))) {
						sorted.add(j, current);
						insert = true;
						break;
					}
				}
				// If point to add is a vertical or horizontal end point
				else {
					// If the point in the sorted array is not a vertical start 
					// point OR a horizontal start point and does not have a 
					// smaller x, we will insert at position j.
					if (!(((sorted.get(j).getL().isVertical() && sorted.get(j).getL().getStart() == sorted.get(j)) 
							|| (!sorted.get(j).getL().isVertical() && sorted.get(j).getL().getStart() == sorted.get(j))) 
							&& current.getX() > sorted.get(j).getX())) {
						sorted.add(j, current);
						insert = true;
						break;
					}
				}
			}
			if (!insert) {
				sorted.add(current);
			}
		}
		return sorted;
	}

	/**
	 * Gets the completely sorted list
	 * @return the sorted list
	 */
	public ArrayList<Point> getSorted() {
		return sorted;
	}
	
	/**
	 * Performs a merge sort on all the points and sorts then by Y-value in
	 * descending order.
	 * @param p the unsorted list of points
	 * @return the sorted list of points
	 */
	private ArrayList<Point> sort(ArrayList<Point> p) {
		// If array size is 1, return
		if (p.size() <= 1) {
			return p;
		}
		
		// Else, split the array in two and sort each half
		ArrayList<Point> first = new ArrayList<Point>();
		for (int i = 0; i < (int)(p.size()/2); i++) {
			first.add(p.get(i));
		}
		ArrayList<Point> second = new ArrayList<Point>();
		for (int i = (int)(p.size()/2); i < p.size(); i++) {
			second.add(p.get(i));
		}
		sort(first);
		sort(second);
		
		merge(first, second, p);
		
		return p;
	}
	
	/**
	 * A helper method to combine two lists into one sorted list.
	 * @param f the first half of the list
	 * @param s the second half of the list
	 * @param r the combined list
	 * @return the new list
	 */
	private ArrayList<Point> merge(ArrayList<Point> f, ArrayList<Point> s, ArrayList<Point> r) {
		int findex = 0;
		int sindex = 0;
		int rindex = 0;
		
		while (findex < f.size() && sindex < s.size()) {
			if (f.get(findex).getY() >= s.get(sindex).getY()) {
                r.set(rindex, f.get(findex));
                findex++;
            }
            else {
            	r.set(rindex, s.get(sindex));
                sindex++;
            }
            rindex++;
        }
		if (findex != f.size()) {
			for (int i = findex; i < f.size(); i++) {
				if (rindex < r.size()) {
					r.set(rindex, f.get(i));
					rindex++;
				}
			}
		}
		if (sindex != s.size()) {
			for (int i = sindex; i < s.size(); i++) {
				if (rindex < r.size()) {
					r.set(rindex, s.get(i));
					rindex++;
				}
			}
		}
		
		return r;
	}
}
