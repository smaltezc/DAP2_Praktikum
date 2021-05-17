public class Search {

    private static long nmax;

    public static void main(String[] args)
    {

        if(args.length != 1)
        {
            System.out.println("FEHLER: Es muss genau eine positive ganze Zahl uebergeben werden.");
            return;
        }

        try
        {
            long x = Long.parseLong(args[0]);
            if(x<=0)
            {
                System.out.println("FEHLER: Es muss genau eine positive ganze Zahl uebergeben werden.");
                return;
            }

            nmax =(long) ( Math.floor( ( Math.sqrt(24*x + 169) - 7)/6 ) );
            long m = 1;
            //exponentiell
            while(T(m) <= x)
            {
                m = m * 2;
            }
            if(nmax < m && m <= 2*nmax)
            {
                long l = m/2;
                long r =  m;
                sucheTernaer(l,r);
            }

        }
        catch (Exception e)
        {
            //Exception
            System.out.println("FEHLER: Es muss genau eine positive ganze Zahl uebergeben werden.");
        }
    }

    public  static void sucheTernaer(long l,long r)
    {

        if(l <= nmax && nmax < r)
        {
            System.out.println("links: T(" + l + ") = "+ T(l)+", "+"rechts: T(" + r + ") = "+ T(r));
            if(l == r-1)
            {
                nmax = l;
                System.out.println("Ergebnis: T(" + nmax + ") = "+ T(nmax));
            }
            else
            {
                long s1 = l + (r-l)/3;
                long s2 = l + (2*(r-l)/3);

                sucheTernaer(l,s1);
                sucheTernaer(s1,s2);
                sucheTernaer(s2,r);
            }
        }

    }

    public static long T(long n)
    {
        long result = (3*n*n + 7*n - 10)/2;
        return result;
    }


}
