/**

public class PointsGenerator {

    private double min;
    private double max;
    private int seed;

    public PointsGenerator(double min, double max, int seed)
    {
        this.min = min;
        this.max = max;
        this.seed = seed;

    }

    public double[] generate(int x)
    {
        //int mn = (int)Math.floor(min);
        //int mx = (int)Math.floor(max);
        double[][] myArray = new double[(int) min][(int) max];
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

*/