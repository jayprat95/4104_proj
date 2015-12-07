import java.util.ArrayList;


public class mainClass
{


    public ArrayList<Line> lineList;
    public ArrayList<Point> pointList;
    
    public mainClass() {
    	lineList = new ArrayList<Line>();
    	pointList = new ArrayList<Point>();
    }

    public static void main(String[] args)
    {
        mainClass gen = new mainClass();
        gen.generateList(10);

        bruteForce force = new bruteForce();

        long startTime = System.currentTimeMillis();
        ArrayList<Intersection> bruteintersects = force.bruteForceCall(gen.lineList);
        long endTime = System.currentTimeMillis();

        System.out.println("There are " + bruteintersects.size() + " intersections");
        System.out.println("The Bruteforce took " + (endTime - startTime) + " milliseconds");

        lineSweep sweep = new lineSweep(gen.pointList);
        
        startTime = System.currentTimeMillis();
        ArrayList<Intersection> sweepintersects = sweep.generateIntersections();
        endTime = System.currentTimeMillis();

        System.out.println("There are " + sweepintersects.size() + " intersections");
        System.out.println("The Line Sweep took " + (endTime - startTime) + " milliseconds");


    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param numOfLines
     */
    public void generateList(int numOfLines) {
        int numOfVert = 1 + (int)(Math.random() * ((numOfLines - 1) + 1));

        int numOfHorz = numOfLines - numOfVert;
        this.lineList = new ArrayList<Line>(numOfLines);

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
     * Place a description of your method here.
     * @param numOfHorz
     */
    public void generateHorzList(int numOfHorz) {
        for(int i = 0; i < numOfHorz; i++) {
            int y = (int)(Math.random()* (1000000));

            int startX = (int)(Math.random()* (1000000 - 25));
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
