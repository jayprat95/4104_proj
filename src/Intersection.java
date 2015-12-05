
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author jayanthprathipati
 *  @version Dec 4, 2015
 */
public class Intersection
{
 private int x;
 private int y;
 private Line l1;
 private Line l2;

 // ----------------------------------------------------------
/**
 * Create a new Intersection object.
 * @param x1
 * @param y1
 * @param sLine
 * @param eLine
 */
public Intersection(int x1, int y1, Line sLine, Line eLine) {
     setX(x1);
     setY(y1);
     setL1(sLine);
     setL2(eLine);
 }

// ----------------------------------------------------------
/**
 * @return the x
 */
public int getX()
{
    return x;
}

// ----------------------------------------------------------
/**
 * @param x the x to set
 */
public void setX(int x)
{
    this.x = x;
}

// ----------------------------------------------------------
/**
 * @return the y
 */
public int getY()
{
    return y;
}

// ----------------------------------------------------------
/**
 * @param y the y to set
 */
public void setY(int y)
{
    this.y = y;
}

// ----------------------------------------------------------
/**
 * @return the l1
 */
public Line getL1()
{
    return l1;
}

// ----------------------------------------------------------
/**
 * @param l1 the l1 to set
 */
public void setL1(Line l1)
{
    this.l1 = l1;
}

// ----------------------------------------------------------
/**
 * @return the l2
 */
public Line getL2()
{
    return l2;
}

// ----------------------------------------------------------
/**
 * @param l2 the l2 to set
 */
public void setL2(Line l2)
{
    this.l2 = l2;
}
}
