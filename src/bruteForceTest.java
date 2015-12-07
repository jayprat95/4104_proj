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

}
