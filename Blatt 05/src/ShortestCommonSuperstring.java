import java.util.ArrayList;
import java.util.Random;

public class ShortestCommonSuperstring {

    public static void main(String[] args)
    {
        if(args.length < 1)
        {
            System.out.println("FEHLER: Es wurde kein Parameter uebergeben.");
            System.out.println("Aufruf des Programms mit:");
            System.out.println("- java ShortestCommonSuperstring n [seed]");
            System.out.println("- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");
            return;
        }
        // ohne Seed
        if(args.length == 1)
        {
            int n, seed;
            try {
                n = Integer.parseInt(args[0]);
            }
            catch (Exception e)
            {
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl >1 sein.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java ShortestCommonSuperstring n [seed]");
                System.out.println("- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");
                return;
            }
            if(n <= 1)
            {
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl >1 sein.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java ShortestCommonSuperstring n [seed]");
                System.out.println("- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");
                return;
            }
            seed = 6521;
            java.util.Random generator = new java.util.Random(seed);

            ArrayList<String> input = new ArrayList<>();
            for(int i=0; i < n;i++ )
            {
                input.add(generateRandomString(generator));
            }

            if(n < 11)
            {
                withDetail(input);

            }
            else
            {
                doIt(input);

            }
            System.out.println("Superstring "+input.get(0)+" mit Laenge "+ input.get(0).length() + " gefunden."  );


        }// mit Seed
        else if(args.length == 2)
        {
            int n, seed;
            try {
                n = Integer.parseInt(args[0]);
            }
            catch (Exception e)
            {
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl >1 sein.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java ShortestCommonSuperstring n [seed]");
                System.out.println("- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");
                return;
            }
            try {
                seed = Integer.parseInt(args[1]);
            }
            catch (Exception e)
            {
                System.out.println("FEHLER: Der Seed Parameter konnte nicht gelesen werden.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java ShortestCommonSuperstring n [seed]");
                System.out.println("- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");
                return;
            }

            if(n <= 1)
            {
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl >1 sein.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java ShortestCommonSuperstring n [seed]");
                System.out.println("- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");
                return;
            }

            java.util.Random generator = new java.util.Random(seed);

            ArrayList<String> input = new ArrayList<>();
            for(int i=0; i < n;i++ )
            {
                input.add(generateRandomString(generator));
            }

            if(n < 11)
            {
                withDetail(input);

            }
            else
            {
                doIt(input);

            }
            System.out.println("Superstring "+input.get(0)+" mit Laenge "+ input.get(0).length() + " gefunden."  );

        }
        else //Strings
        {
            for (String arg : args) {
                if (arg.length() <= 2) {
                    System.out.println("FEHLER: Uebergebene Strings muessen mindestens Laenge 2 haben.");
                    System.out.println("Aufruf des Programms mit:");
                    System.out.println("- java ShortestCommonSuperstring n [seed]");
                    System.out.println("- java ShortestCommonSuperstring str1 str2 str3 [str4 ...]");
                    return;
                }
            }

            ArrayList<String> input = new ArrayList<>();
            for(String s: args)
            {
                input.add(s);
            }

            if(args.length < 11)
            {
                withDetail(input);

            }
            else
            {
                doIt(input);

            }
            System.out.println("Superstring "+input.get(0)+" mit Laenge "+ input.get(0).length() + " gefunden."  );


        }
    }

    public static void doIt(ArrayList<String> input)
    {
        int max =0;

        for(int i=0; i< input.size();i++)
        {
            if(i == 0)
            {
                max = maxOverlap(input);
            }

            // für max index
            for (int x = 0; x < input.size() ; x++ )
            {
                if(i != x)
                {

                    if(max == stringOverlap(input.get(i),input.get(x)) )
                    {
                        int blengt = input.get(x).length();
                        String s;

                        s = input.get(i) + input.get(x).substring(max,blengt);
                        input.add(s);

                        if(i < x)
                        {
                            input.remove(x);
                            input.remove(i );
                        }
                        else  // x<i
                        {
                            input.remove(i );
                            input.remove(x );
                        }

                        i=-1;
                        max = -1;
                        break;

                    }

                }

            }

        }
    }

    public static void withDetail(ArrayList<String> input)
    {

        int max =0;

        for(int i=0; i< input.size();i++)
        {
            if(i == 0)
            {
                max = maxOverlap(input);
                for (String s : input) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }

            // für max index
            for (int x = 0; x < input.size() ; x++ )
            {
                if(i != x)
                {

                    if(max == stringOverlap(input.get(i),input.get(x)))
                    {
                        int blengt = input.get(x).length();
                        String s;

                        s = input.get(i) + input.get(x).substring(max,blengt);
                        input.add(s);

                        System.out.println("Ersetze "+ input.get(i) + " und "+ input.get(x)+ " durch "+ s);

                        if(i < x)
                        {
                            input.remove(x);
                            input.remove(i );
                        }
                        else  // x<i
                        {
                            input.remove(i );
                            input.remove(x );
                        }

                        i=-1;
                        max = -1;
                        break;
                    }


                }

            }

        }
    }

    public static int maxOverlap(ArrayList<String> input)
    {
        int max = -1;

        for(int i=0;i<input.size();i++)
        {
            for(int j=0;j<input.size() ;j++)
            {
                if(i != j)
                {
                    if(max <= stringOverlap(input.get(i),input.get(j)) )
                    {
                        max = stringOverlap(input.get(i),input.get(j));

                    }
                }

            }
        }
        return max;
    }

    public static String generateRandomString(Random numberGenerator) {
        String alphabet = "AEIOU";
        StringBuilder builder = new StringBuilder();
        int length = 3 + numberGenerator.nextInt(4);
        while (length-- > 0) {
            int randomIdx = numberGenerator.nextInt(alphabet.length());
            builder.append(alphabet.charAt(randomIdx));
        }
        return builder.toString();
    }

    public static int stringOverlap(String str1, String str2)
    {
        int m = str1.length();
        int n = str2.length();
        int max = 0;
        for(int i = 1; i< Math.min(m,n); i++)
        {
            if(str1.substring(m-i,m).equals(str2.substring(0,i)))
            {
                max = i;
            }
        }
        return max;
    }

}
