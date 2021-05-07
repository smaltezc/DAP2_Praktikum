
public class euclid {

    public static void main(String[] args)
    {
        if(args.length !=2 )
        {
            System.out.println("Falsche Parameteranzahl!");
            System.out.println("Aufruf mit: java Euclid a b");
            System.out.println("Dabei muessen a und b natuerliche Zahlen groesser 0 sein.");
            System.out.println("Beispiel: java Euclid 24 896");
            return;
        }

        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            if (a > 0 && b > 0)
            {
                System.out.println(fnct(a,b));
            }
            else
            {
                System.out.println("Falscher Parameter - Nur Zahlen sind erlaubt!");
                System.out.println("Aufruf mit: java Euclid a b");
                System.out.println("Dabei muessen a und b natuerliche Zahlen groesser 0 sein.");
                System.out.println("Beispiel: java Euclid 24 896");
            }
        }
        catch (Exception e)
        {
            System.out.println("Falscher Parameter - Nur Zahlen sind erlaubt!");
            System.out.println("Aufruf mit: java Euclid a b");
            System.out.println("Dabei muessen a und b natuerliche Zahlen groesser 0 sein.");
            System.out.println("Beispiel: java Euclid 24 896");
        }

    }

    public static int fnct(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        else
        {
            return fnct(b, (a % b) );
        }
    }
}
