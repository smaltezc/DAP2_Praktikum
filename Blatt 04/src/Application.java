
import java.util.Locale;

public class Application {

    public static void main(String[] args)
    {


        if(args.length < 2 || args.length % 2 != 0 || args.length == 4)
        {
            System.out.println("Falsche Parameteranzahl!");
            System.out.println("Aufruf mit : java Application numberOfPoints seed");
            System.out.println("oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...");
            System.out.println("Bsp: java Application 100 1337");
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
                    System.out.println("Aufruf mit : java Application numberOfPoints seed");
                    System.out.println("oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...");
                    System.out.println("Bsp: java Application 100 1337");
                    return;
                }

                try {
                    int seed = Integer.parseInt(args[1]);
                    PointsGenerator pg = new PointsGenerator(0,100,seed);
                    double[] arr = pg.generate(2*x);

                    doIt(arr);
                }
                catch (Exception e)
                {
                    System.out.println("Falscher Parameter! Als Seed sind nur Integer erlaubt.");
                    System.out.println("Aufruf mit : java Application numberOfPoints seed");
                    System.out.println("oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...");
                    System.out.println("Bsp: java Application 100 1337");
                }

            }
            catch (Exception e)
            {
                System.out.println("Falscher Parameter! Nur Integer groesser 2 sind erlaubt.");
                System.out.println("Aufruf mit : java Application numberOfPoints seed");
                System.out.println("oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...");
                System.out.println("Bsp: java Application 100 1337");
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

                doIt(narr);
            }
            catch (Exception e)
            {
                System.out.println("Es war nicht moeglich, alle Punkte einzulesen.");
                System.out.println("Aufruf mit : java Application numberOfPoints seed");
                System.out.println("oder mit gerader Anzahl Koordinaten: java Application p1x p1y p2x p2y ...");
                System.out.println("Bsp: java Application 100 1337");
            }

        }

    }

    public static void doIt(double[] arr )
    {
        Point fst = new Point(arr[0], arr[1]); // 1. Point
        Point snd = new Point(arr[2], arr[3]); // 2. Point

        Line grd = new Line(fst, snd);
        System.out.println("Vergleiche Punkte mit der Geraden " + grd);

        for(int i=4; i< arr.length-1; i+=2)
        {
            Point rst = new Point(arr[i],arr[i+1]);
            int result = grd.side(rst);
            if(result == 1)
            {
                System.out.println("Punkt "+rst+" liegt rechts der Linie.");

            }
            else if(result == -1 )
            {
                System.out.println("Punkt "+rst+" liegt links der Linie.");
            }
            else
            {
                System.out.println("Punkt "+rst+" liegt auf der Linie.");
                if(isBetween(fst, snd, rst))
                {
                    System.out.println("Punkt "+rst+" liegt zwischen "+ fst + " und "+snd);

                }
            }

        }
    }

/*
    public static boolean isBetween(Point i, Point j, Point k)
    {
        if (i.get(0) == k.get(0)) return j.get(0) == k.get(0);

        if (i.get(1) == k.get(1)) return j.get(1) == k.get(1);

        return (i.get(0) - k.get(0))*(i.get(1) - k.get(1)) == (k.get(1) - j.get(0))*(k.get(1) - j.get(1));

    }*/

    static double perpDotProduct(Point a, Point b, Point p)
    {
        return (a.get(0) - p.get(0)) * (b.get(1) - p.get(1)) - (a.get(1) - p.get(1)) * (b.get(0) - p.get(0));
    }


    public static double getEpsilon(Point a, Point b)
    {
        double dx1 = b.get(0) - a.get(0);
        double dy1 = b.get(1) - a.get(1);
        double epsilon = 0.003 * (dx1 * dx1 + dy1 * dy1);
        return epsilon;
    }


    public static boolean isBetween(Point a, Point b, Point p)
    {
        if (!( (a.get(0) <= p.get(0) && p.get(0) <= b.get(0)) || (b.get(0) <= p.get(0) && p.get(0) <= a.get(0)) ))
        {
            // test point not in x-range
            return false;
        }
        if (!( (a.get(1) <= p.get(1) && p.get(1) <= b.get(1)) || (b.get(1) <= p.get(1) && p.get(1) <= a.get(1)) ))
        {
            // test point not in y-range
            return false;
        }
        return (Math.abs(perpDotProduct(a, b, p)) < Math.abs(getEpsilon(a, b)) );
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
            if (i == j)
            {
                result = points[i];
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

    /*
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
    */

     public int side(Point r)
     {
         double val = (y.get(1) - x.get(1)) * (r.get(0) - y.get(0)) -
                 (y.get(0) - x.get(0)) * (r.get(1) - y.get(1));

         if (val == 0) return 0;  // collinear
         return (val > 0)? 1: -1; // clock or counterclock wise
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
