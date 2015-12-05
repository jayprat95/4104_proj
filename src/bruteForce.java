import java.util.ArrayList;


// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author jayanthprathipati
 *  @version Dec 4, 2015
 */

public class bruteForce
{
    private ArrayList<Line> lineList;

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param numOfLines
     */
    public void generateList(int numOfLines) {
        int numOfVert = 1 + (int)(Math.random() * ((numOfLines - 1) + 1));

        int numOfHorz = numOfLines - numOfVert;

        generateVertList(numOfVert);
        generateHorzList(numOfHorz);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param numOfVert
     */
    public void generateVertList(int numOfVert) {
        for(int i = 0; i < numOfVert; i++) {
            int x = (int)(Math.random()* (1000000));

            int startY = (int)(Math.random()* (1000000 - 25));
            Point start = new Point(x, startY);
            Point end = new Point(x, startY + 25);
            lineList.add(new Line(start, end, true));
        }
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param numOfHorz
     */
    public void generateHorzList(int numOfHorz) {
        for(int i = 0; i < numOfHorz; i++) {
            int y = (int)(Math.random()* (1000000));

            int startX = (int)(Math.random()* (1000000 - 25));
            Point start = new Point(startX, y);
            Point end = new Point(startX + 25, y);
            lineList.add(new Line(start, end, false));
        }
    }

    // ----------------------------------------------------------
    /**
     * @return the lineList
     */
    public ArrayList<Line> getLineList()
    {
        return lineList;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public ArrayList<Intersection> bruteForceCall() {
        ArrayList<Intersection> intersectionPoints = new ArrayList<Intersection>();
        generateList(100);
        for(Line l : this.lineList) {
            for(Line m : this.lineList) {
                if(l.doesIntersect(m)) {
                    intersectionPoints.add(new Intersection(0 , 0, l, m));
                }
            }
        }
        return intersectionPoints;

    }



}