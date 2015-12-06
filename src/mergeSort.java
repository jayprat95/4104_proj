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
	}
	
	public ArrayList<Point> sort(ArrayList<Point> p) {
		// If array size is 1, return
		if (p.size() <= 1) {
			return p;
		}
		
		// Else, split the array in two and sort each half
		ArrayList<Point> first = 
				(ArrayList<Point>) p.subList(0, (int)(p.size()/2));
		ArrayList<Point> second = 
				(ArrayList<Point>) p.subList((int)(p.size()/2) + 1, p.size() - 1);
		
		sort(first);
		sort(second);
		
		merge(first, second, p);
		
		return p;
	}
	
	private ArrayList<Point> merge(ArrayList<Point> f, ArrayList<Point> s, ArrayList<Point> r) {
		
		
		return r;
	}
}
