
public class Point
{
    private int x;
    private int y;

    // ----------------------------------------------------------
    /**
     * Create a new point object.
     * @param start x value starting point
     * @param end y value ending point
     */
    public Point(int start, int end) {
        this.setX(start);
        this.setY(end);
    }

    // ----------------------------------------------------------
    /**
     * @return the x
     */
    public int getX()
    {
        return x;
    }

    // ----------------------------------------------------------
    /**
     * @param x the x to set
     */
    public void setX(int x)
    {
        this.x = x;
    }

    // ----------------------------------------------------------
    /**
     * @return the y
     */
    public int getY()
    {
        return y;
    }

    // ----------------------------------------------------------
    /**
     * @param y the y to set
     */
    public void setY(int y)
    {
        this.y = y;
    }


}
