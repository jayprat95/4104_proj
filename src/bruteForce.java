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



    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public ArrayList<Intersection> bruteForceCall(ArrayList<Line> lineList) {
        ArrayList<Intersection> intersectionPoints = new ArrayList<Intersection>();
        for(Line l : lineList) {
            for(Line m : lineList) {
                if(l.doesIntersect(m)) {
                    intersectionPoints.add(new Intersection(l.getIntersection(m), l, m));
                }
            }
        }
        return intersectionPoints;

    }



}