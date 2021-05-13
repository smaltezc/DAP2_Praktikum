
public class Sortierung {

    private static int anzahlInsert = 0;
    private static int anzahlMerge = 0;

    public static int getAnzahlInsert()
    {
        return anzahlInsert;
    }

    public static int getAnzahlMerge()
    {
        return anzahlMerge;
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

    public  static void main(String[] args)
    {

        if(args.length < 2 || args.length > 3)
        {
            System.out.println("FEHLER: Es muessen zwischen 1 und 3 Parameter angegeben werden.");
            System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");
            System.out.println("Beispiel: java Sortierung 10000 merge rand");
            return;
        }

        try
        {
            int n = Integer.parseInt(args[0]);
            if(n < 0)
            {
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl sein.");
                System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");
                System.out.println("Beispiel: java Sortierung 10000 merge rand");
                return;
            }

            switch (args[1])
            {
                //INSERT
                case "insert" :
                    insert(n,args[2]);
                    break;
                //MERGE
                case "merge" :
                    merge(n,args[2]);
                    break;

                default:
                    System.out.println("FEHLER: Unbekanntes Sortierverfahren: "+args[1]);
                    System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");
                    System.out.println("Beispiel: java Sortierung 10000 merge rand");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public static void mergeSort(int[] array) {
        int[] tmpArray = new int[array.length];
        mergeSort(array, tmpArray, 0, array.length-1);
        assert isSorted(array);
    }

    public static void mergeSort(int[] array, int[] tmpArray, int left, int right)
    {
        int mid;
        if(left < right)
        {
            mid = (left+right)/2;
            mergeSort(array,tmpArray,left,mid);
            mergeSort(array,tmpArray,mid+1,right);
            merge(array,tmpArray,left,mid,right);
        }
    }

    private static void merge(int[] array,int[] tmpArray, int left, int mid, int right) {

        for (int j = left; j<= right ; j++)
        {
            tmpArray[j] = array[j];
        }

        int i = left;
        int j = mid+1;
        int k = left;

        while (i <= mid && j <= right)
        {
            if(tmpArray[i] <= tmpArray[j])
            {
                array[k] = tmpArray[i];
                i++;
                anzahlMerge++;
            }
            else
            {
                array[k] = tmpArray[j];
                j++;
            }
            k++;
            if(i + 1 > array.length-1)
            {
                anzahlMerge++;
            }
        }

        while( i <= mid){
            array[k] = tmpArray[i];
            k++;
            i++;
            anzahlMerge++;
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
                }
                System.out.println( "Das Sortieren des Arrays hat " + (n*(n-1)/2) + " Vergleiche benoetigt." );
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
                System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");
                System.out.println("Beispiel: java Sortierung 10000 merge rand");
        }
    }

    public static void merge(int n,String s)
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

                mergeSort(arr);
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
                }
                System.out.println( "Das Sortieren des Arrays hat " + getAnzahlMerge() + " Vergleiche benoetigt." );
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

                mergeSort(arr2);
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
                System.out.println( "Das Sortieren des Arrays hat " + getAnzahlMerge() + " Vergleiche benoetigt." );
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

                mergeSort(arr1);
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
                    System.out.println( "Das Sortieren des Arrays hat " + (getAnzahlMerge() ) + " Vergleiche benoetigt." );
                    break;
                }
                else
                {
                    if(isSorted(arr1))
                    {
                        System.out.println("Feld ist sortiert!");
                    }
                    System.out.println( "Das Sortieren des Arrays hat " + (getAnzahlMerge() )+ " Vergleiche benoetigt." );
                    break;
                }

            default:
                System.out.println("FEHLER: Unbekanntes Vorsortierverfahren: "+s);
                System.out.println("Aufruf mit: java Sortierung n [insert|merge [auf|ab|rand]]");
                System.out.println("Beispiel: java Sortierung 10000 merge rand");
        }
    }

}
