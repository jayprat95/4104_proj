import java.util.HashSet;
import java.util.ArrayList;


public class mainClass
{


    public ArrayList<Line> lineList;
    public ArrayList<Point> pointList;
    private static final int GRIDSIZE = 100000;
    private static final int NUMLINES = 20000;

    public mainClass() {
    	lineList = new ArrayList<Line>();
    	pointList = new ArrayList<Point>();
    }

    public static void main(String[] args)
    {
        mainClass gen = new mainClass();
        gen.generateList(NUMLINES);

        bruteForce force = new bruteForce();

        long startTime = System.currentTimeMillis();
        ArrayList<Intersection> bruteintersects = force.bruteForceCall(gen.lineList);
        long endTime = System.currentTimeMillis();

        for(Intersection i: bruteintersects) {
            System.out.println("L1: " + i.getL1().toString() + " L2: " + i.getL2().toString());
        }
        System.out.println("There are " + bruteintersects.size() + " intersections");
        System.out.println("The Bruteforce took " + (endTime - startTime) + " milliseconds");

        lineSweep sweep = new lineSweep(gen.pointList);



        startTime = System.currentTimeMillis();
        ArrayList<Intersection> sweepintersects = sweep.generateIntersections();
        endTime = System.currentTimeMillis();

        for(Intersection i: sweepintersects) {
            System.out.println("L1: " + i.getL1().toString() + " L2: " + i.getL2().toString());
        }

        System.out.println("There are " + sweepintersects.size() + " intersections");
        System.out.println("The Line Sweep took " + (endTime - startTime) + " milliseconds");


    }


    // ----------------------------------------------------------
    /**
     * Populates a list of vertical and horizontal lines
     * @param numOfLines number of lines to generate
     */
    public void generateList(int numOfLines) {

        //figure out how many vertical lines to generate
        int numOfVert = 1 + (int)(Math.random() * ((numOfLines - 1) + 1));

        //figure out how many horizontal lines to generate
        int numOfHorz = numOfLines - numOfVert;
        this.lineList = new ArrayList<Line>(numOfLines);

        //generate the lines
        generateVertList(numOfVert);
        generateHorzList(numOfHorz);
    }

    // ----------------------------------------------------------
    /**
     * Populates a list of vertical lines
     * @param numOfVert number of vertical lines to generate
     */
    public void generateVertList(int numOfVert) {

        for(int i = 0; i < numOfVert; i++) {
            //pick x coordinate of starting point
            int x = (int)(Math.random()* (GRIDSIZE));

            //pick y coordinate of starting point
            int startY = (int)(Math.random()* (GRIDSIZE - 25));
            Point start = new Point(x, startY);
            Point end = new Point(x, startY - 25);
            Line L = new Line(start, end, true);
            this.lineList.add(L);
            start.setL(L);
            end.setL(L);
            this.pointList.add(start);
            this.pointList.add(end);
        }
    }

    // ----------------------------------------------------------
    /**
     * Generates a list of horizontal lines
     * @param numOfHorz number of horizontal lines to generate
     */
    public void generateHorzList(int numOfHorz) {
        HashSet<Integer> points = new HashSet<Integer>();
        for(int i = 0; i < numOfHorz; i++) {

            //pick the y coordinate of the starting point
            int y = (int)(Math.random()* (GRIDSIZE));


            //pick the x coordinate of the starting point
            int startX = (int)(Math.random()* (GRIDSIZE - 25));
            while(points.contains(startX)) {
                startX = (int)(Math.random()* (GRIDSIZE - 25));
            }
            points.add(startX);
            Point start = new Point(startX, y);
            Point end = new Point(startX + 25, y);
            Line L = new Line(start, end, false);
            this.lineList.add(L);
            start.setL(L);
            end.setL(L);
            this.pointList.add(start);
            this.pointList.add(end);
        }
    }

}
