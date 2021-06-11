import java.util.ArrayList;

public class DynamicProgramm {

    public static int knapsack(Box[] boxes,int l, int m) {

        // Create a 2D Array of Size value.size()+1 X maxWeightConstraint+1
        int[][] cache = new int[boxes.length + 1][m + 1];

        // Fill up the cache in Bottom Up Manner
        for (int totalItems = 0; totalItems <= boxes.length; totalItems++) {
            for (int restTragbar = 0; restTragbar <= m; restTragbar++) {

                int currentItem = totalItems - 1;

                //BASE CASE - Case when number of Items are 0 OR maxWeight is 0
                if (totalItems == 0 || restTragbar == 0) {
                    cache[totalItems][restTragbar] = 0;
                    System.out.print(cache[totalItems][restTragbar] + "\t");
                }

                // If weight of current Item is greater than maxWeight
                // We cannot add that item
                
                // Else check the condition of with Item or Without Item
                // And Store the maximum of both
                else {

                    // 1.) Without Item -> Going up 1 row
                    // 2.) With Item -> Go up 1 row & left 'weights[currentItem]' columns

                    //currentItem = 0
                    int withItem = boxes[currentItem].getGeld() ;

                    if(currentItem > 0)
                    {
                        if( boxes[currentItem].getWeight() + boxes[currentItem-1].getWeight() <= l )
                        {
                            withItem += cache[totalItems - 1][restTragbar - 1];
                        }
                        else
                        {
                            withItem += cache[currentItem - 1][restTragbar - 1];
                        }
                    }

                    int withoutItem = cache[totalItems - 1][restTragbar];

                    cache[totalItems][restTragbar] = Math.max(withItem, withoutItem);
                    System.out.print(cache[totalItems][restTragbar]+"\t");
                }
            }
            System.out.println();
        }

        return cache[boxes.length][m];
    }

    public static void main(String[] args)
    {
        int k = 4;
        Box[] boxes = {new Box(150,10000),
                        new Box(300,25000),
                        new Box(400,31000),
                        new Box(250,20000) };


        for(Box b : boxes)
        {
            System.out.println(b.toString());
        }
        int l = 55000;
        int m = 2;
        System.out.println("++++++++++++++++++++");
        int result = knapsack(boxes,l,m);
        System.out.println("++++++++++++++++++++");
        System.out.println("Max Betrag: "+result);

    }

}
