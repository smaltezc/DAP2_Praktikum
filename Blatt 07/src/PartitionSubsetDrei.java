import java.util.ArrayList;
import java.util.Arrays;

public class PartitionSubsetDrei {

    public static void main(String[] args)
    {
        //int[] nums =  {1, 4, 3, 5, 7}; // [] []
        //int[] nums =  {1, 5, 11, 5};
        //int[] nums =  {2, 4, 6, 8, 10};
        int[] nums =  {5, 4, 3, 2, 1};
        //Arrays.sort(nums);


        System.out.println(Arrays.toString(nums));
        int W = 0;
        for(int n: nums)
        {
            W += n;
        }

        int E[][][] = PartitionDynamicProg(nums);

        System.out.println("++++++++++++++++++++++++");
        for(int i = 0; i<E.length ; i++)
        {
            for(int j = 0; j<E[i].length; j++)
            {
                for(int k = 0; k<E[i][j].length;k++)
                {
                    System.out.print(E[i][j][k] + " ");
                }
                System.out.println();
            }
        }
        System.out.println("++++++++++++++++++++++++");

        System.out.println(canPartition(nums, E,W));
    }


    public static int[][][] PartitionDynamicProg(int[] nums)
    {
        int W = 0;
        for (int i = 0; i< nums.length; i++ )
        {
            W += nums[i];
        }

        if(W % 3 != 0)
        {
            System.out.println("FEHLER: Eine gerechte Aufteilung ist nicht möglich");
            System.exit(0);
        }

        int E[][][] = new int[1][nums.length+1][(W/3)+1];


        for(int i = 0; i< E.length; i++)
        {
            for(int j = 0; j< E[i].length; j++)
            {
                for(int k = 0; k<E[i][j].length;k++)
                {

                    if(j == 0 && k == 0)
                    {
                        E[i][j][k] = 1;
                    }
                    else if(j == 0)
                    {
                        E[i][j][k] = 0;
                    }
                    else if(k == 0 )
                    {
                        E[i][j][k] = 1;
                    }
                    else if(E[i][j-1][k] == 1 || ( nums[j-1] <= k && E[i][j-1][k - nums[j-1]] == 1 ) )
                    {
                        E[i][j][k] = 1;
                    }
                    else
                    {
                        E[i][j][k] = 0;
                    }
                }

            }
        }
        return E;
    }

    public static int canPartition(int[] M, int[][][] E, int W) {

        int sum=W;

        if(sum%3!=0)

            return 0;

        sum=sum/3;


        int i = 0;
        int j = M.length;
        int k = sum;


        ArrayList<Integer> set1 = new ArrayList<Integer>();

        ArrayList<Integer> set2 = new ArrayList<Integer>();

        ArrayList<Integer> set3 = new ArrayList<Integer>();

        while(j>0 && k>0)

        {

            int cr=M[j-1];
            boolean check = true;
            // System.out.println("i=  "+i+" j  "+j+"  dp[i][j]= "+dp[i][j]+"  dp[i-1][j]= "+dp[i-1][j]+" nums[i-1]= "+cr);

            if(E[i][j][k] != E[i][j-1][k])

            {

                if(cr == sum )
                {
                    set1.add(cr);
                    j = j-1;
                }
                else
                {
                    set3.add(cr);

                    j=j-1;

                    k=k-cr;
                }


            }

            else if(E[i][j][k] == E[i][j-1][k])

            {

                if(cr == sum )
                {
                    set1.add(cr);
                    j = j-1;
                }
                else
                {
                    set2.add(cr);

                    j=j-1;

                }

            }


        }
        System.out.println(j);

        while(j>0)

        {

            int cr=M[j-1];

            set2.add(cr);
            j=j-1;



        }

        System.out.println(set1);

        System.out.println(set2);

        System.out.println(set3);

        if(E[i][M.length][sum] == 0)
        {
            System.out.println("FEHLER: Eine gerechte Aufteilung ist nicht möglich");
        }

        return E[i][M.length][sum];

    }
}
