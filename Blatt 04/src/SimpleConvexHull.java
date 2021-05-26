/**
import java.util.*;

public class SimpleConvexHull {

    public static void main(String[] args)
    {

        if(args.length < 2 || args.length % 2 != 0 || args.length == 4)
        {
            System.out.println("Falsche Parameteranzahl!");
            System.out.println("Aufruf mit : java SimpleConvexHull numberOfPoints seed");
            System.out.println("oder mit gerader Anzahl Koordinaten: java SimpleConvexHull p1x p1y p2x p2y ...");
            System.out.println("Bsp: java SimpleConvexHull 100 1337");
            return;
        }

        // 2 INPUT
        if(args.length == 2)
        {
            try {
                int x = Integer.parseInt(args[0]);
                if(x <= 2)
                {
                    System.out.println("Anzahl der Punkte muss groesser als 2 sein.");
                    System.out.println("Aufruf mit : java SimpleConvexHull numberOfPoints seed");
                    System.out.println("oder mit gerader Anzahl Koordinaten: java SimpleConvexHull p1x p1y p2x p2y ...");
                    System.out.println("Bsp: java SimpleConvexHull 100 1337");
                    return;
                }

                try {
                    int seed = Integer.parseInt(args[1]);
                    PointsGenerator pg = new PointsGenerator(0,100,seed);
                    double[] arr = pg.generate(2*x);

                    Point[] points = new Point[x];
                    int t = 0;
                    for(int j = 0 ; j< arr.length-1;j += 2)
                    {
                        points[t] = new Point(arr[j],arr[j+1]);
                        t++;
                    }

                    LinkedList<Point> hull = computeHull(points);
                    //LinkedList<Point> hull = convexHull(points);
                    StringBuilder s = new StringBuilder();
                    for(int i =0 ; i< hull.size(); i++)
                    {
                        if(i != hull.size()-1)
                        {
                            s.append(hull.get(i)).append(" -- ");

                        }
                        else {
                            s.append(hull.get(i));
                        }
                    }
                    System.out.println(s);
                }
                catch (Exception e)
                {
                    System.out.println("Falscher Parameter! Als Seed sind nur Integer erlaubt.");
                    System.out.println("Aufruf mit : java SimpleConvexHull numberOfPoints seed");
                    System.out.println("oder mit gerader Anzahl Koordinaten: java SimpleConvexHull p1x p1y p2x p2y ...");
                    System.out.println("Bsp: java SimpleConvexHull 100 1337");
                }

            }
            catch (Exception e)
            {
                System.out.println("Falscher Parameter! Nur Integer groesser 2 sind erlaubt.");
                System.out.println("Aufruf mit : java SimpleConvexHull numberOfPoints seed");
                System.out.println("oder mit gerader Anzahl Koordinaten: java SimpleConvexHull p1x p1y p2x p2y ...");
                System.out.println("Bsp: java SimpleConvexHull 100 1337");
            }


        } // minds 6 Input
        else
        {
            //Point[] sda= new Point[5];
            try {
                double[] narr = new double[args.length];
                for (int i = 0; i < narr.length; i++ )
                {
                    narr[i] = Double.parseDouble( args[i]);
                }

                Point[] points = new Point[narr.length/2];
                int t = 0;
                for(int j = 0 ; j< narr.length-1;j += 2)
                {
                    points[t] = new Point(narr[j],narr[j+1]);
                    t++;
                }

                LinkedList<Point> hull = computeHull(points);
                StringBuilder s = new StringBuilder();
                for(int k =0 ; k< hull.size(); k++)
                {
                    if(k != hull.size()-1)
                    {
                        s.append(hull.get(k)).append(" -- ");

                    }
                    else {
                        s.append(hull.get(k));
                    }
                }
                System.out.println(s);
            }
            catch (Exception e)
            {
                System.out.println("Es war nicht moeglich, alle Punkte einzulesen.");
                System.out.println("Aufruf mit : java SimpleConvexHull numberOfPoints seed");
                System.out.println("oder mit gerader Anzahl Koordinaten: java SimpleConvexHull p1x p1y p2x p2y ...");
                System.out.println("Bsp: java SimpleConvexHull 100 1337");
            }

        }



    }



    public static LinkedList<Point> computeHull(Point[] P)
    {

        LinkedList<Point> knoten = new LinkedList<>();
        for(Point p: P)
        {
            knoten.add(p);
        }
        LinkedList<Point> h = new LinkedList<>();
        ArrayList<Line> geraden = new ArrayList<>();

        for(int i=0 ; i< knoten.size()-1 ; i++)
        {
            for(int j = i+1; j< knoten.size(); j++)
            {
                Point p = knoten.get(i);
                Point q = knoten.get(j);

                if(!p.equals(q))
                {
                    Line grd = new Line(p, q);
                    boolean valid = true;
                    for(int k = 0; k< knoten.size();k++)
                    {
                        if( i != k && j != k )
                        {
                            Point r = knoten.get(k);
                            if(!isBetween(p,q,r))
                            {
                                if(grd.side(r) == -1)
                                {
                                    valid = false;
                                }
                            }

                        }

                    }
                    if (valid)
                    {
                        geraden.add(grd);
                        h.add(q);
                        System.out.println("Neue Aussenkante gefunden: " + grd);
                    }
                }
            }

        }

        return  h;


    }

    public static boolean isBetween(Point i, Point j, Point k)
    {
        if (i.get(0) == k.get(0)) return j.get(0) == k.get(0);

        if (i.get(1) == k.get(1)) return j.get(1) == k.get(1);

        return (i.get(0) - k.get(0))*(i.get(1) - k.get(1)) == (k.get(1) - j.get(0))*(k.get(1) - j.get(1));

    }

}


//POINT
class Point implements Comparable<Point>{

    private final double[] points;

    public Point(double ... points)
    {
        this.points = points;
    }

    public int compareTo(Point o) {
        return Double.compare(this.get(0), o.get(0));
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i< points.length; i++)
        {
            String result = String.format(Locale.US, "%.2f", points[i]);
            //double result = Math.round(tmp *100)/100.0;
            if(i == points.length-1)
            {
                s.append(result);
            }
            else
            {
                s.append(result).append(", ");
            }
            //s+=result;
        }
        return "(" + s + ")";
    }

    public double get(int i)
    {
        double result =0;
        for(int j=0;j< points.length;j++)
        {
            if (i == j) {
                result = points[i];
                break;
            }
        }
        return  result;
    }


}



class PointsGenerator {

    private final double min;
    private final double max;
    private final int seed;

    public PointsGenerator(double min, double max, int seed)
    {
        this.min = min;
        this.max = max;
        this.seed = seed;

    }

    public double[] generate(int x)
    {
        double[] arr = new double[x];            //seed

        java.util.Random rng = new java.util.Random(seed);
        int index = 0;

        while (index < x)
        {
            double coord = (rng.nextDouble() * (max - min) + min);
            arr[index] = coord;
            index++;
        }

        return  arr;
    }

}



class Line  {


    private Point x;
    private Point y;

    public Line(Point x, Point y)
    {
        this.x = x;
        this.y = y;

    }

    private static final int RIGHT = 1, LEFT = -1, ZERO = 0;

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


        if (cross_product > 0 )
            return LEFT;


        if (cross_product < 0)
            return RIGHT;


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


}
*/