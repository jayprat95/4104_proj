import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author RyanWork
 *
 */
public class lineSweepTest {
	private ArrayList<Point> points;
	@Before
    public void setUp()
        throws Exception
    {
		points = new ArrayList<Point>();
    }


    @Test
    public void test()
    {
    	Point p1 = new Point(0, 25);
		Point p2 = new Point(25, 25);
		Line l1= new Line(p1, p2, false);
		p1.setL(l1);
		p2.setL(l1);
		
		Point p3 = new Point(25, 25);
		Point p4 = new Point(25, 0);
		Line l2= new Line(p3, p4, true);
		p3.setL(l2);
		p4.setL(l2);
		
		Point p5 = new Point(50, 45);
		Point p6 = new Point(75, 45);
		Line l3= new Line(p5, p6, false);
		p5.setL(l3);
		p6.setL(l3);
		
		Point p7 = new Point(60, 50);
		Point p8 = new Point(60, 25);
		Line l4= new Line(p7, p8, true);
		p7.setL(l4);
		p8.setL(l4);
		
		Point p9 = new Point(70, 65);
		Point p10 = new Point(70, 40);
		Line l5= new Line(p9, p10, true);
		p9.setL(l5);
		p10.setL(l5);
		
		Point p11 = new Point(25, 0);
		Point p12 = new Point(50, 0);
		Line l6= new Line(p11, p12, false);
		p11.setL(l6);
		p12.setL(l6);
		
		Point p13 = new Point(80, 50);
		Point p14 = new Point(80, 25);
		Line l7= new Line(p13, p14, true);
		p13.setL(l7);
		p14.setL(l7);
		
		Point p15 = new Point(75, 0);
		Point p16 = new Point(100, 0);
		Line l8= new Line(p15, p16, false);
		p15.setL(l8);
		p16.setL(l8);
		
		Point p17 = new Point(20, 100);
		Point p18 = new Point(45, 100);
		Line l9= new Line(p17, p18, false);
		p17.setL(l9);
		p18.setL(l9);
		
		Point p19 = new Point(25, 100);
		Point p20 = new Point(25, 75);
		Line l10= new Line(p19, p20, true);
		p19.setL(l10);
		p20.setL(l10);
		
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);
		points.add(p7);
		points.add(p8);
		points.add(p9);
		points.add(p10);
		points.add(p11);
		points.add(p12);
		points.add(p13);
		points.add(p14);
		points.add(p15);
		points.add(p16);
		points.add(p17);
		points.add(p18);
		points.add(p19);
		points.add(p20);
		
    	lineSweep sweep = new lineSweep(points);
    	ArrayList<Intersection> list = sweep.generateIntersections();
    	assertEquals(5, list.size());
    }
    
    @Test
    public void test2()
    {
    	Point p1 = new Point(69, 79);
		Point p2 = new Point(69, 54);
		Line l1= new Line(p1, p2, true);
		p1.setL(l1);
		p2.setL(l1);
		
		Point p3 = new Point(64, 77);
		Point p4 = new Point(89, 77);
		Line l2= new Line(p3, p4, false);
		p3.setL(l2);
		p4.setL(l2);
		
		Point p5 = new Point(63, 77);
		Point p6 = new Point(88, 77);
		Line l3= new Line(p5, p6, false);
		p5.setL(l3);
		p6.setL(l3);
		
		Point p7 = new Point(69, 95);
		Point p8 = new Point(69, 70);
		Line l4= new Line(p7, p8, true);
		p7.setL(l4);
		p8.setL(l4);
		
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);
		points.add(p7);
		points.add(p8);
		
		lineSweep sweep = new lineSweep(points);
    	ArrayList<Intersection> list = sweep.generateIntersections();
    	assertEquals(4, list.size());
    }
    
    
}
