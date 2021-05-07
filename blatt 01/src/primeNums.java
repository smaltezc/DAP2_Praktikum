import java.util.Arrays;

public class primeNums {

    public static void main(String[] args)
    {

        if(args.length == 1)
        {
            try {
                int n = Integer.parseInt(args[0]);
                if (n > 2)
                {
                    boolean[] isPrime = new boolean[n+1];
                    Arrays.fill(isPrime, true);
                    int count = 0;
                    for(int i = 0; i< isPrime.length ; i++)
                    {
                        for(int j = 2; j < i ; j++)
                        {
                            if(i % j == 0)
                            {
                                isPrime[i]=false;
                                count++;
                                break;
                            }
                        }

                    }
                    //wegen n+1 müssen wir um -1 reduzieren
                    int anzahlPrimes = n-count-1;
                    System.out.println(anzahlPrimes);
                }
                else
                {
                    System.out.println("Falscher Parameter! Nur Integer groesser 0 sind erlaubt.");
                    System.out.println("Aufruf mit : java Eratosthenes n [-o]");
                    System.out.println("Es wird die Anzahl der Primzahlen aus dem Bereich [2,n] berechnet.");
                    System.out.println("Mit -o werden diese Zahlen auch ausgegeben.");
                    System.out.println("Bsp: java Eratosthenes 100 -o");
                }
            }
            catch (Exception e)
            {
                System.out.println("Falscher Parameter! Nur Integer groesser 0 sind erlaubt.");
                System.out.println("Aufruf mit : java Eratosthenes n [-o]");
                System.out.println("Es wird die Anzahl der Primzahlen aus dem Bereich [2,n] berechnet.");
                System.out.println("Mit -o werden diese Zahlen auch ausgegeben.");
                System.out.println("Bsp: java Eratosthenes 100 -o");
            }
        }
        else if(args.length == 2)
        {
            try {
                int n = Integer.parseInt(args[0]);
                if (n > 2)
                {
                    boolean[] isPrime = new boolean[n+1];
                    Arrays.fill(isPrime, true);
                    int countNotPrimes = 0;
                    for(int i = 0; i< isPrime.length ; i++)
                    {
                        for(int j = 2; j < i ; j++)
                        {
                            if(i % j == 0)
                            {
                                isPrime[i]=false;
                                countNotPrimes++;
                                break;
                            }
                        }

                    }
                    //wegen n+1 müssen wir um -1 reduzieren
                    int anzahlPrimes = n-countNotPrimes-1;
                    int arrayPrimes[] = new int[anzahlPrimes];

                    int m=0;
                    for(int x = 2; x< isPrime.length; x++)
                    {
                        if(isPrime[x])
                        {
                            arrayPrimes[m]=x;
                            m++;
                        }
                    }
                    System.out.println(anzahlPrimes);
                    if(args[1].equals("-o"))
                    {
                        for (int element: arrayPrimes) {
                            System.out.print(element+ " ");
                        }
                        System.out.println();
                    }
                }
                else
                {
                    System.out.println("Falscher Parameter! Nur Integer groesser 0 sind erlaubt.");
                    System.out.println("Aufruf mit : java Eratosthenes n [-o]");
                    System.out.println("Es wird die Anzahl der Primzahlen aus dem Bereich [2,n] berechnet.");
                    System.out.println("Mit -o werden diese Zahlen auch ausgegeben.");
                    System.out.println("Bsp: java Eratosthenes 100 -o");
                }
            }
            catch (Exception e)
            {
                System.out.println("Falscher Parameter! Nur Integer groesser 0 sind erlaubt.");
                System.out.println("Aufruf mit : java Eratosthenes n [-o]");
                System.out.println("Es wird die Anzahl der Primzahlen aus dem Bereich [2,n] berechnet.");
                System.out.println("Mit -o werden diese Zahlen auch ausgegeben.");
                System.out.println("Bsp: java Eratosthenes 100 -o");
            }
        }
        else
        {
            System.out.println("Falsche Parameteranzahl!");
            System.out.println("Aufruf mit : java Eratosthenes n [-o]");
            System.out.println("Es wird die Anzahl der Primzahlen aus dem Bereich [2,n] berechnet.");
            System.out.println("Mit -o werden diese Zahlen auch ausgegeben.");
            System.out.println("Bsp: java Eratosthenes 100 -o");
        }

    }
}
