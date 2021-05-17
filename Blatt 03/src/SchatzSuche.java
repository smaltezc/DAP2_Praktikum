public class SchatzSuche {
    public static void main(String [] args)
    {
        setInsel(8,15);
    }

    public static void schatzSuche(int[][] array) {
        int[] tmpArray = new int[array[0].length];
        //mergeSort(array, tmpArray, 0, array.length-1);
        for (int i=0; i< array.length;i++ )
        {
            for(int j=0; j<array[0].length;j++)
            {
                tmpArray[j] = array[i][j];
            }
            schatzSuche(tmpArray, i,0, array[0].length-1);
        }
    }

    public static void schatzSuche(int[] tmpArray,int index, int left, int right)
    {
        int mid;
        if(left < right)
        {
            mid = (left+right)/2;
            //schatzSuche(tmpArray,left,mid);
            //schatzSuche(tmpArray,mid+1,right);
            if(right == 1)
            {
              /*  if(detektor())
                {
                    System.out.println("Schatz gefunden");
                    return;
                }*/
            }
            //merge(array,tmpArray,left,mid,right);
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
                //anzahlMerge++;
            }
            else
            {
                array[k] = tmpArray[j];
                j++;
            }
            k++;
            if(i + 1 > array.length-1)
            {
                //anzahlMerge++;
            }
        }

        while( i <= mid){
            array[k] = tmpArray[i];
            k++;
            i++;
            //anzahlMerge++;
        }
    }

    public static void setInsel(int m,int n)
    {
        String[][] insel = new String[m][n];

        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n;j++)
            {
                if(i != 0 && i != m-1 && j != n-1 && j != 0 )
                {
                    insel[i][j] = " ";
                    System.out.print(insel[i][j] );
                }
                else {
                    insel[i][j] = "+";
                    System.out.print(insel[i][j] );
                }

            }
            System.out.println();
        }
    }
}
