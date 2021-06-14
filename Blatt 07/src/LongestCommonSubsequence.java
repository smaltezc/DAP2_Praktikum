import java.util.Random;

public class LongestCommonSubsequence {

    public static void main(String[] args)
    {

        if(args.length == 3)
        {
            int seed, n1, n2;
            try {
                seed = Integer.parseInt(args[0]);
                n1 = Integer.parseInt(args[1]);
                n2 = Integer.parseInt(args[2]);

                if(seed <= 0)
                {
                    System.out.println("FEHLER: Der Seed Parameter muss eine positive Zahl sein.");
                    System.out.println("Aufruf des Programms mit:");
                    System.out.println("- java LongestCommonSubsequence seed n1 n2");
                    System.out.println("- java LongestCommonSubsequence str1 str2");
                    return;
                }

                if(n1 < 10 || n2 < 10)
                {
                    System.out.println("FEHLER: Eine angegebene Laenge ist <10.");
                    System.out.println("Aufruf des Programms mit:");
                    System.out.println("- java LongestCommonSubsequence seed n1 n2");
                    System.out.println("- java LongestCommonSubsequence str1 str2");
                    return;
                }

                Random r = new Random(seed);
                String str1 = randStr(n1, r);
                String str2 = randStr(n2, r);

                System.out.println("A: " + str1);
                System.out.println("B: " + str2);

                int[][] feld = LCSLaenge(str1,str2);
                String result = LCS(feld, str1);

                System.out.println("LCS " + result + " mit Laenge " + result.length() + " gefunden." );

            }
            catch (Exception e)
            {
                System.out.println("FEHLER: Ein Parameter konnte nicht gelesen werden.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java LongestCommonSubsequence seed n1 n2");
                System.out.println("- java LongestCommonSubsequence str1 str2");

            }
        }
        else if(args.length == 2)
        {
            String str1 = args[0];
            String str2 = args[1];

            if(str1.length() < 5 || str2.length() < 5)
            {
                System.out.println("FEHLER: Uebergebene Strings muessen mindestens Laenge 5 haben.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java LongestCommonSubsequence seed n1 n2");
                System.out.println("- java LongestCommonSubsequence str1 str2");
                return;

            }

            if(!hasNotNums(str1) || !hasNotNums(str2))
            {
                System.out.println("FEHLER: Uebergebene Strings duerfen nur Buchstaben enthalten.");
                System.out.println("Aufruf des Programms mit:");
                System.out.println("- java LongestCommonSubsequence seed n1 n2");
                System.out.println("- java LongestCommonSubsequence str1 str2");
                return;
            }

            System.out.println("A: " + str1);
            System.out.println("B: " + str2);

            int[][] feld = LCSLaenge(str1,str2);
            String result = LCS(feld, str1);

            System.out.println("LCS " + result + " mit Laenge " + result.length() + " gefunden." );


        }
        else
        {
            System.out.println("FEHLER: Falsche Parameteranzahl uebergeben.");
            System.out.println("Aufruf des Programms mit:");
            System.out.println("- java LongestCommonSubsequence seed n1 n2");
            System.out.println("- java LongestCommonSubsequence str1 str2");

        }

    }

    public static boolean hasNotNums(String text) {

        return text.matches("[a-zA-Z]+");
    }

    private static String randStr(int length, Random r)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder res = new StringBuilder(length);
        while (--length>=0) {
            res.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        return res.toString();
    }

    public static int[][] LCSLaenge(String A, String B)
    {

        int m = A.length();
        int n = B.length();

        int[][] C = new int[m+1][n+1];

        for(int i = 0; i< m+1;i++)
        {
            for(int j = 0; j< n+1 ;j++)
            {
                if(i == 0 || j == 0)
                {
                    C[i][j] = 0;
                }
                else if(A.charAt(i-1) == B.charAt(j-1))
                {
                    C[i][j] = C[i-1][j-1]+1;
                }
                else if( A.charAt(i-1) != B.charAt(j-1))
                {
                    C[i][j] = Math.max(C[i-1][j], C[i][j-1]);
                }
            }
        }
        return C;
    }

    public static String LCS(int[][] C, String A)
    {
        int i = C.length-1;
        int j = C[0].length-1;


        StringBuilder result = new StringBuilder();

        while(i>0 && j>0)
        {
            char current = A.charAt(i-1);

            if(C[i][j] == C[i-1][j] || C[i][j] == C[i][j-1])
            {
                if(C[i-1][j] >=  C[i][j-1])
                {
                    i=i-1;
                }
                else
                {
                    j=j-1;
                }

            }
            else
            {

                result.append(current);
                i--;
                j = j-1;
            }
        }
        result.reverse();
        return result.toString();


    }
}
