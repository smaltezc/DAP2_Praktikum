public class QuickSort {

    private static int anzahlPart;

    public static int getAnzahlPart()
    {
        return anzahlPart;
    }

    public static void main(String[] args)
    {

        if(args.length < 1)
        {
            System.out.println("FEHLER: Es wurden keine Argumente uebergeben.");
            return;
        }

        try {
            int[] arrInt = new int[args.length];
            for (int i=0; i < args.length; i++)
            {
                arrInt[i] = Integer.parseInt(args[i]);
            }
            quickSort(arrInt);
            for (int j= arrInt.length-1 ; 0 <= j ;j--)
            {
                if(j != 0)
                {
                    System.out.print(arrInt[j] + ", ");
                }
                else
                {
                    System.out.print(arrInt[j] );
                }

            }
            System.out.println();
            System.out.println(getAnzahlPart());

        }
        catch (Exception e)
        {
            System.out.println("FEHLER: Es koennen nur ganze Zahlen sortiert werden.");
        }

    }

    public static void quickSort(int[] array)
    {
        //int[] tmpArray = new int[array.length];
        quickSort(array, 0, array.length-1);
        assert isSorted(array);
    }

    private static void quickSort(int[] array, int p, int r)
    {

        if(p < r)
        {

            int q = partition(array,p,r);

            quickSort(array,p,q-1);
            quickSort(array,q+1,r);

        }

    }

    private static java.util.Random rng = new java.util.Random(1337);

    private static int partition(int arr[], int p, int r)
    {
        anzahlPart++;
        int z = rng.nextInt((r - p) + 1) + p;
        swap(arr,z,r);

        int pivot = arr[r];
        int i = p;
        int j = r-1;

        while(i<j)
        {
            while(arr[i] < pivot)
            {
                i = i + 1;
            }
            while (i<j && arr[j] >= pivot )
            {
                j = j - 1;

            }
            if(i<j)
            {
                swap(arr,i,j);
            }


        }
        if(arr[i] > arr[r])
        {
            swap(arr,i,r);

        }
        return i;
    }

    private static void swap(int[] arr,int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;

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
}
