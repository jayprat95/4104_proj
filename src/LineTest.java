import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class LineTest
{

    @Before
    public void setUp()
        throws Exception
    {
    }


    @Test
    public void testVertical()
    {
        Line l1 = new Line(new Point(2, 0), new Point(2, 4), false);
        Line l2 = new Line(new Point(1, 2), new Point(5, 2), true);

        assertTrue(l1.doesIntersect(l2));


    }

    @Test
    public void testUntrue() {
        Line l1 = new Line(new Point(0, 0), new Point(4, 4), false);
        Line l2 = new Line(new Point(-2, -2), new Point(-2, 2), true);
        assertFalse(l1.doesIntersect(l2));
    }



}
