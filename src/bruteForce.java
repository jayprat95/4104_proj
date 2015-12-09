import java.util.ArrayList;


// -------------------------------------------------------------------------
/**
 * This class generates the generated list of intersections based on a brute
 * force method (checking every line with every other line
 *
 *  @author jayanthprathipati
 *  @version Dec 4, 2015
 */

public class bruteForce
{



    // ----------------------------------------------------------
    /**
     * This method generates a list of intersections based on a given
     * list of lines
     * @param lineList list of lines
     * @return the list of intersections
     */
    public ArrayList<Intersection> bruteForceCall(ArrayList<Line> lineList) {
        ArrayList<Intersection> intersectionPoints = new ArrayList<Intersection>();

        //go through each vertical line in the line list
        for(Line l : lineList) {
            if(l.isVertical()) {
                for(Line m : lineList) {
                    //go through every horizontal line in the list
                    if(m.isVertical() == false) {
                        if(l.doesIntersect(m)) {
                            boolean add = false;
                            //check if it's already in the list
                            for(Intersection i  : intersectionPoints) {
                                Line l1 = i.getL1();
                                Line l2 = i.getL2();

                                if(l.equals(l2)) {
                                    if(m.equals(l1)) {
                                        add = true;
                                        break;

                                    }
                                }
                                else if(m.equals(l2)) {
                                    if(l.equals(l1) ) {
                                        add = true;

                                    }
                                }

                            }

                            //if it's not in the list...add it
                            if(add == false) {
                                intersectionPoints.add(new Intersection(l.getIntersection(m), l, m));

                            }

                        }
                    }
                }
            }

        }

        //return the generated list of intersections
        return intersectionPoints;

    }



}