import java.util.ArrayList;

/**
 * 
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
		endPointCheck(sorted);
	}
	
	private void endPointCheck(ArrayList<Point> p) {
		for (int i = 0; i < p.size(); i++) {
			Point current = p.get(i);
			if (!current.getL().isVertical()) { // If Horizontal
				if (current == current.getL().getStart()) {
					int end = p.indexOf(current.getL().getEnd());
					if (i > end) {
						Point temp = p.get(i);
						p.set(i, p.get(end));
						p.set(end, temp);
					}
				}
			}
		}
		
	}

	public ArrayList<Point> getSorted() {
		return sorted;
	}
	
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
