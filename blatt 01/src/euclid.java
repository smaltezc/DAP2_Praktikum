import java.util.Scanner;

public class euclid {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] partsOfInput = input.split(" ");
        int laenge = partsOfInput.length;
        if(laenge == 4)
        {
            String first = partsOfInput[0];
            String second = partsOfInput[1];
            String third = partsOfInput[2];
            String fourth = partsOfInput[3];
            if(first.equals("java") && second.equals( "Euclid") && isNumeric(third) && isNumeric(fourth) )
            {
                int a = Integer.parseInt(partsOfInput[2]);
                int b = Integer.parseInt(partsOfInput[3]);
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
            else
            {
                System.out.println("Falscher Parameter - Nur Zahlen sind erlaubt!");
                System.out.println("Aufruf mit: java Euclid a b");
                System.out.println("Dabei muessen a und b natuerliche Zahlen groesser 0 sein.");
                System.out.println("Beispiel: java Euclid 24 896");
            }
        }
        else
        {
            System.out.println("Falsche Parameteranzahl!");
            System.out.println("Aufruf mit: java Euclid a b");
            System.out.println("Dabei muessen a und b natuerliche Zahlen groesser 0 sein.");
            System.out.println("Beispiel: java Euclid 24 896");
        }

    }

    /*
    int a = Integer.parseInt(partsOfInput[0]);
    int b = Integer.parseInt(partsOfInput[1]);
     */

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

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
