import java.util.ArrayList;
import java.util.Arrays;

public class PartitionSubset {

    public static void main(String[] args)
    {
        //int[] nums =  {1, 4, 3, 5, 7}; // [] []
        int[] nums =  {1, 5, 11, 5};
        System.out.println(Arrays.toString(nums));
        int W = 0;
        for(int n: nums)
        {
            W += n;
        }

        int E[][] = PartitionDynamicProg(nums);

        System.out.println("++++++++++++++++++++++++");
        for(int i = 0; i<E.length ; i++)
        {
            for(int j = 0; j<E[i].length; j++)
            {
                System.out.print(E[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("++++++++++++++++++++++++");

        System.out.println(canPartition(nums, E,W));
    }

    public static int sumOfArray(int[] nums)
    {
        int sum = 0;
        for (int n:nums)
        {
            sum += n;
        }
        return sum;
    }

    public static int sumOfArrayList(ArrayList<Integer> nums)
    {
        int sum = 0;
        for (int n:nums)
        {
            sum += n;
        }
        return sum;
    }

    public static int[][] PartitionDynamicProg(int[] nums)
    {
        int W = 0;
        for (int i = 0; i< nums.length; i++ )
        {
            W += nums[i];
        }

        if(W % 2 != 0)
        {
            System.out.println("FEHLER: Eine gerechte Aufteilung ist nicht möglich");
            System.exit(0);
        }

        int E[][] = new int[nums.length+1][(W/2)+1];

        for(int i = 0; i< nums.length+1; i++)
        {
            for(int j = 0; j< (W/2)+1; j++)
            {
                if(j == 0)
                {
                    E[i][j] = 1;
                }
                else if(i == 0)
                {
                    E[i][j] = 0;
                }
                else if(E[i-1][j] == 1 || ( nums[i-1] <= j && E[i-1][j - nums[i-1]] == 1 ) )
                {
                    E[i][j] = 1;
                }
                else
                {
                    E[i][j] = 0;
                }
            }
        }
        return E;
    }

    public static int canPartition(int[] M, int[][] E, int W) {

        int sum=W;

        int i,j;

        if(sum%2!=0)

            return 0;

        sum=sum/2;


        i=M.length;

        j=sum;

        ArrayList<Integer> set1=new ArrayList<Integer>();

        ArrayList<Integer> set2=new ArrayList<Integer>();

        while(i>0 && j>0)

        {

            int cr=M[i-1];

            // System.out.println("i=  "+i+" j  "+j+"  dp[i][j]= "+dp[i][j]+"  dp[i-1][j]= "+dp[i-1][j]+" nums[i-1]= "+cr);

            if(E[i][j] != E[i-1][j])

            {

                set1.add(cr);

                i=i-1;

                j=j-cr;

            }

            else if(E[i][j] == E[i-1][j])

            {

                set2.add(cr);

                i=i-1;

            }





        }
        System.out.println(i);

        while(i>0)

        {

            int cr=M[i-1];

            set2.add(cr);
            i=i-1;



        }

        System.out.println(set1);

        System.out.println(set2);

        if(E[M.length][sum] == 0)
        {
            System.out.println("FEHLER: Eine gerechte Aufteilung ist nicht möglich");
        }

        return E[M.length][sum];

    }
}
