
public class InsertionSort {


    private static int anzahlInsert = 0;

    public static int getAnzahlInsert()
    {
        return anzahlInsert;
    }

    public static void insertionSort(int[] array)
    {
        int key ;
        for(int j = 1 ; j < array.length ; j++)
        {
            key = array[j];
            int i = j-1;
            while(i >= 0 && array[i] > key)
            {

                array[i+1] = array[i];
                i--;
                if(i + 1 > 0)
                {
                   anzahlInsert++;
                }

            }
            array[i+1] = key;
            anzahlInsert++;

        }
    }

    public static boolean isSorted(int[] array)
    {

        for(int i = 0; i < array.length-1 ; i++)
        {
            if(array[i] > array[i+1])
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {

        if(args.length < 1 || args.length > 2)
        {
            System.out.println("FEHLER: Es muessen zwischen 1 und 2 Parameter angegeben werden.");
            System.out.println("Aufruf mit: java InsertionSort n [auf|ab|rand]");
            System.out.println("Beispiel: java InsertionSort 10000 rand");
            return;
        }

        try
        {
            int n = Integer.parseInt(args[0]);
            if(n < 0)
            {
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl sein.");
                System.out.println("Aufruf mit: java InsertionSort n [auf|ab|rand]");
                System.out.println("Beispiel: java InsertionSort 10000 rand");
                return;
            }
            if(args.length == 2)
            {
                insert(n,args[1]);
            }
            else
            {
                rand(n);
            }


        }
        catch (NumberFormatException e)
        {
            System.out.println("FEHLER: Es muessen zwischen 1 und 2 Parameter angegeben werden.");
            System.out.println("Aufruf mit: java InsertionSort n [auf|ab|rand]");
            System.out.println("Beispiel: java InsertionSort 10000 rand");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public static void insert(int n,String s)
    {
        switch (s)
        {
            //assert n > 0 : "FEHLER: Der erste Parameter muss eine natuerliche Zahl sein.\n" + "Aufruf mit: java InsertionSort n [auf|ab|rand]";
            case "ab" :

                int[] arr = new int[n];
                for(int i = 0 ; i< arr.length; i++)
                {
                    arr[i] = arr.length-i;
                }
                if(n <= 100)
                {
                    for(int element : arr)
                    {
                        System.out.print(element + " ");
                    }
                }

                insertionSort(arr);
                if(n <= 100)
                {
                    System.out.println();
                    for(int element2 : arr)
                    {
                        System.out.print(element2 + " ");
                    }
                    System.out.println();
                }

                if(isSorted(arr))
                {
                    System.out.println("Feld ist sortiert!");
                }
                else
                {
                    System.out.println("FEHLER: Feld ist NICHT sortiert!");
                    return;
                }                                                    //(n*(n-1)/2)
                System.out.println( "Das Sortieren des Arrays hat " + getAnzahlInsert() + " Vergleiche benoetigt." );
                break;

            case "auf" :
                int[] arr2 = new int[n];
                for(int i = 0 ; i< arr2.length; i++)
                {
                    arr2[i] = i + 1 ;
                }

                if(n <= 100)
                {
                    for(int element : arr2)
                    {
                        System.out.print(element + " ");
                    }
                }

                insertionSort(arr2);
                if(n <= 100)
                {
                    System.out.println();
                    for(int element2 : arr2)
                    {
                        System.out.print(element2 + " ");
                    }
                    System.out.println();
                }
                if(isSorted(arr2))
                {
                    System.out.println("Feld ist sortiert!");
                }
                System.out.println( "Das Sortieren des Arrays hat " + getAnzahlInsert() + " Vergleiche benoetigt." );
                break;

            case "rand" :
                int[] arr1 = new int[n];
                java.util.Random rd = new java.util.Random();
                rd.setSeed(951);
                for(int i = 0 ; i < arr1.length; i++)
                {
                    //int randomNumber = numberGenerator.nextInt();
                    //int rand = rd.nextInt();
                    arr1[i] = rd.nextInt();
                }

                if(n <= 100)
                {
                    for(int element : arr1)
                    {
                        System.out.print(element + " ");
                    }
                }

                insertionSort(arr1);
                if(n <= 100)
                {
                    System.out.println();
                    for(int element2 : arr1)
                    {
                        System.out.print(element2 + " ");
                    }
                    System.out.println();
                    if(isSorted(arr1))
                    {
                        System.out.println("Feld ist sortiert!");
                    }
                    System.out.println( "Das Sortieren des Arrays hat " + (getAnzahlInsert() ) + " Vergleiche benoetigt." );
                    break;
                }
                else
                {
                    if(isSorted(arr1))
                    {
                        System.out.println("Feld ist sortiert!");
                    }
                    System.out.println( "Das Sortieren des Arrays hat " + (getAnzahlInsert()) + " Vergleiche benoetigt." );
                    break;
                }

            default:
                System.out.println("FEHLER: Unbekanntes Vorsortierverfahren: "+s);
                System.out.println("Aufruf mit: java InsertionSort n [auf|ab|rand]");
                System.out.println("Beispiel: java InsertionSort 10000 rand");
        }
    }

    public static void rand(int n)
    {
        int[] arr1 = new int[n];
        java.util.Random rd = new java.util.Random();
        rd.setSeed(951);
        for(int i = 0 ; i < arr1.length; i++)
        {
            //int randomNumber = numberGenerator.nextInt();
            //int rand = rd.nextInt();
            arr1[i] = rd.nextInt();
        }

        if(n <= 100)
        {
            for(int element : arr1)
            {
                System.out.print(element + " ");
            }
        }

        insertionSort(arr1);
        if(n <= 100)
        {
            System.out.println();
            for(int element2 : arr1)
            {
                System.out.print(element2 + " ");
            }
            System.out.println();
            if(isSorted(arr1))
            {
                System.out.println("Feld ist sortiert!");
            }
            System.out.println( "Das Sortieren des Arrays hat " + (getAnzahlInsert() ) + " Vergleiche benoetigt." );

        }
        else
        {
            if(isSorted(arr1))
            {
                System.out.println("Feld ist sortiert!");
            }
            System.out.println( "Das Sortieren des Arrays hat " + (getAnzahlInsert()) + " Vergleiche benoetigt." );

        }
    }

}
