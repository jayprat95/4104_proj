
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

 private Point Intersect;
 private Line l1;
 private Line l2;

 // ----------------------------------------------------------
/**
 * Create a new Intersection object.
 * @param p
 * @param sLine
 * @param eLine
 */
public Intersection(Point p, Line sLine, Line eLine) {

     setIntersect(p);
     setL1(sLine);
     setL2(eLine);
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

// ----------------------------------------------------------
/**
 * @return the intersect
 */
public Point getIntersect()
{
    return Intersect;
}

public Boolean equals(Intersection i) {
    if(this.l1.equals(i.l1)) {
        if(this.l2.equals(i.l2)) {
            return true;
        }
        else {
            return false;
        }
    }
    else if(this.l1.equals(i.l2)) {
        if(this.l2.equals(i.l1)) {
            return true;
        }
        else {
            return false;
        }
    }
    else {
        return false;
    }
}

// ----------------------------------------------------------
/**
 * @param intersect the intersect to set
 */
public void setIntersect(Point intersect)
{
    Intersect = intersect;
}
}
