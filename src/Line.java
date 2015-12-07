
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author jayanthprathipati
 *  @version Dec 4, 2015
 */



public class Line implements Comparable<Object>
{
    private Point start;
    private Point end;
    private boolean isVertical;

    // ----------------------------------------------------------
    /**
     * Create a new line object.
     * @param s1
     * @param s2
     * @param isVert
     */

    public Line(Point s1, Point s2, boolean isVert) {
        this.start = s1;
        this.end = s2;
        this.isVertical = isVert;
    }
    // ----------------------------------------------------------
    /**
     * @return the end
     */
    public Point getEnd()
    {
        return end;
    }
    // ----------------------------------------------------------
    /**
     * @param end the end to set
     */
    public void setEnd(Point end)
    {
        this.end = end;
    }
    // ----------------------------------------------------------
    /**
     * @return the start
     */
    public Point getStart()
    {
        return start;
    }
    // ----------------------------------------------------------
    /**
     * @param start the start to set
     */
    public void setStart(Point start)
    {
        this.start = start;
    }
    // ----------------------------------------------------------
    /**
     * @return the line direction
     */
    public boolean isVertical()
    {
        return isVertical;
    }




    public Point getIntersection(Line l2) {

        if((this.isVertical && l2.isVertical) == false) {
            if(this.isVertical == true) {
                if((l2.start.getY() <= this.end.getY()) && (this.start.getY() >= l2.start.getY())) {
                    if((this.start.getX() <= l2.end.getX()) && (l2.start.getX() >= this.start.getX()))  {
                        return new Point(this.start.getX(), l2.start.getY());
                    }
                    else {
                        return null;
                    }

                }
                else {
                    return null;
                }
            }
            else {
                if((this.start.getX() <= l2.end.getX()) && (l2.start.getX() >= this.start.getX())) {
                    if((l2.start.getY() <= this.end.getY()) && (this.start.getY() >= l2.start.getY()))  {
                        return new Point(l2.end.getX(), this.start.getY());
                    }
                    else {
                        return null;
                    }

                }
                else {
                    return null;
                }
            }
        }
        else {
            return null;
        }


    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param l2
     * @return
     */
    public boolean doesIntersect(Line l2) {

        if((this.isVertical && l2.isVertical) == false && !((this.isVertical == false) && (l2.isVertical == false))) {
            if(this.isVertical == true) {
                if((l2.start.getY() <= this.end.getY()) && (this.start.getY() >= l2.start.getY())) {
                    if((this.start.getX() <= l2.end.getX()) && (l2.start.getX() >= this.start.getX()))  {
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
            else {
                if((this.start.getX() <= l2.end.getX()) && (l2.start.getX() >= this.start.getX())) {
                    if((l2.start.getY() <= this.end.getY()) && (this.start.getY() >= l2.start.getY()))  {
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
        }
        else {
            return false;
        }


    }



    public String toString() {
        return "(" + this.start.getX() + "," + this.start.getY() + ") to ("
            + this.end.getX() + "," + this.end.getY() + ")";
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param l2
     * @return
     */
    public boolean equals(Line l2) {
        if(this.start.equals(l2.start) && this.end.equals(l2.end)) {
            return true;
        }
        else {
            return false;
        }
    }

	@Override
	public int compareTo(Object o) {
		Line l = (Line)(o);
		if (this.getStart().getX() == l.getStart().getX()) {
			return 0;
		}
		else if (this.getStart().getX() > l.getStart().getX()) {
			return 1;
		}
		return -1;
	}
}
