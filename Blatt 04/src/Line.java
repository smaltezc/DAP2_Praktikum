/**
import java.awt.*;

public class Line {

    private Point x;
    private Point y;
    private Graphics g;

    public Line(Point x, Point y)
    {
        this.x = x;
        this.y = y;
        double x1 = x.get(0);
        double y1 = x.get(1);
        double x2 = y.get(0);
        double y2 = y.get(0);
        //g.drawLine(x1, y1, x2, y2);
        //g2.draw(new Line2D.Double(x1, y1, x2, y2));
    }

    private static int RIGHT = 1, LEFT = -1, ZERO = 0;

    public int side(Point z)
    {


        double ax = x.get(0);
        double ay = x.get(1);
        double bx = y.get(0);
        double by = y.get(1);

        ax -= z.get(0);
        ay -= z.get(1);
        bx -= z.get(0);
        by -= z.get(1);



        double cross_product = ax  * by - ay * bx;

        // return RIGHT if cross product is positive
        if (cross_product > 0 )
            return LEFT;

        // return LEFT if cross product is negative
        if (cross_product < 0)
            return RIGHT;

        // return ZERO if cross product is zero.
        return ZERO;
    }

    public void invertDirection()
    {
        Point nx = x;
        x = y;
        y = nx;
    }

    public String toString()
    {
        return x +" -- " + y ;
    }

    public static void main(String [] args)
    {
        Point k = new Point(0, 0);
        Point l = new Point(1, 0);
        Line a = new Line(k,l);
        Point m = new Point(-1,1);
        System.out.println(a.side(m));
        a.invertDirection();
        System.out.println(a.side(m));
        System.out.println(a.toString());
    }
}
*/