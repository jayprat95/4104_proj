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
        Line l1 = new Line(new Point(0, 0), new Point(0, 4), true);
        Line l2 = new Line(new Point(2, -2), new Point(2, 2), false);

        aList.add(l1);
        aList.add(l2);

        bruteForce force = new bruteForce();
        int size = force.bruteForceCall(aList).size();

        assertEquals(size, 1);
    }

}
