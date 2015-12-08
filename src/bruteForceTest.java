import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


public class bruteForceTest
{

    @Before
    public void setUp()
        throws Exception
    {
    }


    @Test
    public void test()
    {
        ArrayList<Line> aList = new ArrayList<Line>();
        Line l1 = new Line(new Point(25, 25), new Point(25, 0), true);
        Line l2 = new Line(new Point(0, 20), new Point(25, 20), false);
        Line l3 = new Line(new Point(50, 50), new Point(50, 25), true);



        aList.add(l1);
        aList.add(l2);
        aList.add(l3);


        bruteForce force = new bruteForce();
        int size = force.bruteForceCall(aList).size();

        ArrayList<Intersection> lst = force.bruteForceCall(aList);

        for(Intersection i: lst) {
            System.out.println("L1: " + l1.toString() + " L2: " + l2.toString());
        }

        assertEquals(size, 1);
    }


    @Test
    public void testEquals() {
        Line l1 = new Line(new Point(0, 0), new Point(0, 4), true);
        Line l2 = new Line(new Point(0, 0), new Point(0, 4), true);
        Line l3 = new Line(new Point(2, -2), new Point(2, 2), false);

        assertTrue(l1.equals(l2));
        assertFalse(l1.equals(l3));
    }

    @Test
    public void testFoo() {
        ArrayList<Line> aList = new ArrayList<Line>();
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

        aList.add(l1);
        aList.add(l2);
        aList.add(l3);
        aList.add(l4);


        bruteForce force = new bruteForce();
        int size = force.bruteForceCall(aList).size();

        ArrayList<Intersection> lst = force.bruteForceCall(aList);

        for(Intersection i: lst) {
            System.out.println("L1: " + l1.toString() + " L2: " + l2.toString());
        }

        assertEquals(size, 4);



    }


    @Test
    public void testNew() {
        ArrayList<Line> aList = new ArrayList<Line>();
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

        Point p9 = new Point(80, 95);
        Point p10 = new Point(80, 70);
        Line l5= new Line(p9, p10, true);
        p9.setL(l5);
        p10.setL(l5);

        Point p11 = new Point(49, 95);
        Point p12 = new Point(49, 70);
        Line l6= new Line(p11, p12, true);
        p11.setL(l6);
        p12.setL(l6);

        Point p13 = new Point(63, 67);
        Point p14 = new Point(88, 67);
        Line l7= new Line(p13, p14, false);
        p13.setL(l7);
        p14.setL(l7);

        Point p15 = new Point(63, 87);
        Point p16 = new Point(88, 87);
        Line l8= new Line(p15, p16, false);
        p15.setL(l8);
        p16.setL(l8);

        aList.add(l1);
        aList.add(l2);
        aList.add(l3);
        aList.add(l4);
        aList.add(l5);
        aList.add(l6);
        aList.add(l7);
        aList.add(l8);





        bruteForce force = new bruteForce();
        int size = force.bruteForceCall(aList).size();

        ArrayList<Intersection> lst = force.bruteForceCall(aList);

        for(Intersection i: lst) {
            System.out.println("L1: " + l1.toString() + " L2: " + l2.toString());
        }

        assertEquals(size, 9);

    }

}
