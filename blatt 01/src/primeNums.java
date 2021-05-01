import java.util.Arrays;
import java.util.Scanner;

public class primeNums {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] partsOfInput = input.split(" ");
        int laenge = partsOfInput.length;
        if(laenge == 3)
        {
            if(hasNums(input))
            {
                if(partsOfInput[0].equals("java") &&
                        partsOfInput[1].equals("Eratosthenes") )
                {
                    int n = Integer.parseInt(partsOfInput[2]);
                    if(n>2)
                    {

                        boolean[] isPrime = new boolean[n];
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
                        //Hier ist -2 für i = 0 1
                        int anzahlPrimes = n-count-2;
                        System.out.println(anzahlPrimes);

                    }
                    else if (n>0)
                    {
                        System.out.println(0);
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
                else
                {
                    System.out.println("Falscher Parameter!");
                    System.out.println("Aufruf mit : java Eratosthenes n [-o]");
                    System.out.println("Es wird die Anzahl der Primzahlen aus dem Bereich [2,n] berechnet.");
                    System.out.println("Mit -o werden diese Zahlen auch ausgegeben.");
                    System.out.println("Bsp: java Eratosthenes 100 -o");
                }
            }
            else
            {
                System.out.println("Falscher Parameter!");
                System.out.println("Aufruf mit : java Eratosthenes n [-o]");
                System.out.println("Es wird die Anzahl der Primzahlen aus dem Bereich [2,n] berechnet.");
                System.out.println("Mit -o werden diese Zahlen auch ausgegeben.");
                System.out.println("Bsp: java Eratosthenes 100 -o");
            }

        }
        else if(laenge == 4)
        {
            if(hasNums(input))
            {
                if(partsOfInput[0].equals("java") &&
                        partsOfInput[1].equals("Eratosthenes") &&
                        partsOfInput[3].equals("-o") )
                {
                    int n = Integer.parseInt(partsOfInput[2]);
                    if(n>2)
                    {

                        boolean[] isPrime = new boolean[n];
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
                        //Hier ist -2 für i = 0 1
                        int anzahlPrimes = n-count-2;
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
                        for (int element: arrayPrimes) {
                            System.out.print(element+ " ");
                        }
                    }
                    else if (n>0)
                    {
                        System.out.println(0);
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
                else
                {
                    System.out.println("Falscher Parameter!");
                    System.out.println("Aufruf mit : java Eratosthenes n [-o]");
                    System.out.println("Es wird die Anzahl der Primzahlen aus dem Bereich [2,n] berechnet.");
                    System.out.println("Mit -o werden diese Zahlen auch ausgegeben.");
                    System.out.println("Bsp: java Eratosthenes 100 -o");
                }
            }
            else
            {
                System.out.println("Falscher Parameter!");
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

    public static boolean hasNums(String text) {

        return text.matches(".*\\d.*");
    }
}
