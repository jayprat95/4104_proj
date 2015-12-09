
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




    // ----------------------------------------------------------
    /**
     * Checks to see if two lists intersect and gives you the point
     * of intersection
     * @param l2 secondary line to check for intersection
     * @return Point of intersection or null if the lines don't intersect
     */
    public Point getIntersection(Line l2) {


        //don't care about vertical or horizontal lines
        if(this.isVertical && l2.isVertical) {
            return null;
        }
        else if((this.isVertical == false) && (l2.isVertical == false)) {
            return null;
        }
        else {
            //first line is vertical
            if(this.isVertical) {
                //second line is within the bounding box of the vertical line
                if(this.start.getY() >= l2.getStart().getY() && this.end.getY() <= l2.getStart().getY()) {
                    if((this.start.getX() >= l2.getStart().getX()) && (this.start.getX() <= l2.getEnd().getX())) {
                        //get the point of intersection
                        return new Point( this.start.getX(),l2.getStart().getY());
                    }
                    else {
                        //second line is not within the X bounding box
                        return null;
                    }
                }
                else {
                    //second line is not within the Y bounding box
                    return null;
                }
            }
            else { //first line is horizontal
                //check to see if the second line is in this line's Y bounding box
                if(this.start.getY() <= l2.getStart().getY() && this.start.getY() >= l2.getEnd().getY()) {
                    //check to see if the second line is in this line's X bounding box
                    if(this.start.getX() <= l2.getStart().getX() && this.end.getX() >= l2.getStart().getX()) {
                        return new Point( l2.getStart().getX(),this.getStart().getY());
                    }
                    else { // the second line is not in this line's X bounding box
                        return null;
                    }
                }
                else { // the second line is not in this line's Y bounding box
                    return null;
                }
            }
        }



    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param l2
     * @return
     */
    public boolean doesIntersect(Line l2) {

        //we don't care about collisions between two vertical or two horizontal lines
        if(this.isVertical && l2.isVertical) {
            return false;
        }
        else if((this.isVertical == false) && (l2.isVertical == false)) {
            return false;
        }
        else {
            //first line is vertical
            if(this.isVertical) {
                //second line is within the bounding box of the vertical line
                if(this.start.getY() >= l2.getStart().getY() && this.end.getY() <= l2.getStart().getY()) {
                    if((this.start.getX() >= l2.getStart().getX()) && (this.start.getX() <= l2.getEnd().getX())) {
                        //get the point of intersection
                        return true;
                    }
                    else {
                        //second line is not within the X bounding box
                        return false;
                    }
                }
                else {
                    //second line is not within the Y bounding box
                    return false;
                }
            }
            else { //first line is horizontal
                //check to see if the second line is in this line's Y bounding box
                if(this.start.getY() <= l2.getStart().getY() && this.start.getY() >= l2.getEnd().getY()) {
                    //check to see if the second line is in this line's X bounding box
                    if(this.start.getX() <= l2.getStart().getX() && this.end.getX() >= l2.getStart().getX()) {

                        return true;
                    }
                    else {
                        //the second line is not in this line's X bounding box
                        return false;
                    }
                }
                else {
                  //the second line is not in this line's Y bounding box
                    return false;
                }
            }
        }


    }


    /**
     * create a string output of a line
     */
    public String toString() {
        return "(" + this.start.getX() + "," + this.start.getY() + ") to ("
            + this.end.getX() + "," + this.end.getY() + ")";
    }

    // ----------------------------------------------------------
    /**
     * Checks if two lines are equivalent to each other
     * @param l2 line to compare to
     * @return true if the start and end points are the same on both lines
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
			if (this.getStart().getY() == l.getStart().getY()) {
				return 0;
			}
			else if(this.getStart().getY() > l.getStart().getY()) {
				return -1;
			}
			return 1;
		}
		else if (this.getStart().getX() > l.getStart().getX()) {
			return 1;
		}
		return -1;
	}
}
