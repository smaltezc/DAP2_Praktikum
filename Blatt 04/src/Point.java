/**
import java.util.Locale;


public class Point {

    private double points[];

    public Point(double ... points)
    {
        this.points = points;
    }

    public String toString()
    {
        String s = "";
        for(int i = 0; i< points.length; i++)
        {
            String result = String.format(Locale.US, "%.2f", points[i]);
            //double result = Math.round(tmp *100)/100.0;
            if(i == points.length-1)
            {
                s += result;
            }
            else
            {
                s += result +", ";
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
*/