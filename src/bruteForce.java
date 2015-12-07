import java.util.HashSet;
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
            if(l.isVertical()) {
                for(Line m : lineList) {
                    if(m.isVertical() == false) {
                        if(l.doesIntersect(m)) {
                            boolean add = false;
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

                            if(add == false) {
                                intersectionPoints.add(new Intersection(l.getIntersection(m), l, m));

                            }

                        }
                    }
                }
            }

        }


        for(int i = 0; i < intersectionPoints.size(); i++) {

        }

        return intersectionPoints;

    }



}