import java.util.ArrayList;


public class mainClass
{


    public ArrayList<Line> lineList;

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        mainClass gen = new mainClass();
        gen.generateList(1000);

        bruteForce force = new bruteForce();
        ArrayList<Intersection> intersects = force.bruteForceCall(gen.lineList);

        System.out.println("There are " + intersects.size() + " intersections");





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
            Point end = new Point(x, startY + 25);
            Line L = new Line(start, end, true);
            this.lineList.add(L);
            start.setL(L);
            end.setL(L);
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
        }
    }

}
