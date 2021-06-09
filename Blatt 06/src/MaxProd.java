import java.math.BigDecimal;

public class MaxProd {

    public static BigDecimal[] buildTableUnsigned(BigDecimal[] array)
    {

        BigDecimal[] table = new BigDecimal[array.length];

        int n = array.length;
        if(n == 0) return null;

        BigDecimal minProd = array[0];
        BigDecimal maxProd = array[0];
        BigDecimal answer = array[0];
        // Range(0,0,array[0])

        table[0]=answer;

        BigDecimal choice1, choice2;

        for(int i=1;i<n;i++)
        {
            choice1 = minProd.multiply(array[i]);
            choice2 = maxProd.multiply(array[i]);

            minProd = min(array[i], min(choice1,choice2) );
            maxProd = max(array[i], max(choice1,choice2) );
            answer = max(answer,maxProd);

            if(answer.compareTo(array[i]) > 0)
            {
                table[i] = maxProd;
            }
            else
            {
                table[i] = answer;
            }

        }

        return table;
    }

    public static BigDecimal[] buildTableSigned(BigDecimal[] array)
    {
        BigDecimal[] table = new BigDecimal[array.length];

        int n = array.length;
        if(n == 0) return null;

        BigDecimal minProd = array[0];
        BigDecimal maxProd = array[0];
        BigDecimal answer = array[0];
        // Range(0,0,array[0])

        table[0]=answer;

        BigDecimal choice1, choice2;

        for(int i=1;i<n;i++)
        {
            choice1 = minProd.multiply(array[i]); //-0.182
            choice2 = maxProd.multiply(array[i]); //-0.182

            minProd = min(array[i], min(choice1,choice2) );
            maxProd = max(array[i], max(choice1,choice2) );
            answer = max(answer,maxProd);

            if(answer.compareTo(array[i]) > 0)
            {
                table[i] = maxProd;
            }
            else
            {
                table[i] = answer;
            }

        }
        return table;
    }

    public static BigDecimal min(BigDecimal x, BigDecimal y)
    {
        int result = x.compareTo(y);

        if(result > 0)
        {
            return y;
        }
        else
        {
            return x;
        }
    }

    public static BigDecimal max(BigDecimal x, BigDecimal y)
    {
        int result = x.compareTo(y);

        if(result > 0)
        {
            return x;
        }
        else
        {
            return y;
        }
    }

    public static Range compute(BigDecimal[] array, BigDecimal[] table)
    {
        BigDecimal maxTable = table[0];
        int left = 0;
        int right = 0;
        for(int b = 0; b < table.length; b++)
        {
            if(maxTable.compareTo(table[b]) < 0)
            {
                maxTable = table[b];
                right = b;
            }
        }

        boolean check = false;
        for(BigDecimal big : array)
        {
            if (big.compareTo(maxTable) == 0) {
                left = right;
                check = true;
                break;
            }
        }

        if(!check)
        {
            int i = 1;
            boolean check2 = false;
            while (table[right].compareTo(table[right - i]) > 0 && i < right+1)
            {
                if(table[right-i].compareTo(array[right-i]) == 0)
                {
                    check2 = true;
                    if(table[right-i].compareTo(table[right-i+1]) < 0 )
                    {
                        left = right - i;
                        break;

                    }
                    else if(table[right-i].compareTo(table[right-i+1]) == 0 )
                    {
                        left = right - i+1;

                        break;
                    }

                }

                if(table[right-i].compareTo(table[right-i+1]) > 0 )
                {
                    int j = right -i;

                    while (j >= 0  )
                    {
                        if(table[j].compareTo(new BigDecimal("0")) < 0)
                        {
                            if(table[j+1].compareTo(array[j+1]) == 0)
                            {
                                left = j+2;
                            }
                        }
                        j--;
                    }
                    break;

                }

                if(table[right-i].compareTo(table[right-i+1]) < 0)
                {
                    int j = right -i;

                    while (j > 0  )
                    {
                        if(table[j].compareTo(new BigDecimal("0")) < 0)
                        {
                            if(table[j-1].compareTo(array[j-1]) == 0)
                            {
                                left = j;

                            }
                            break;
                        }
                        j--;
                    }

                }


                i++;

            }

        }

        return new Range(left,right,maxTable);


    }

    public static void main(String[] args)
    {
        BigDecimal[] ar = new BigDecimal[8];

        ar[0] = new BigDecimal("-1.4");
        ar[1] = new BigDecimal("0.13");
        ar[2] = new BigDecimal("-1.3");
        ar[3] = new BigDecimal("0.89");
        ar[4] = new BigDecimal("1.8");
        ar[5] = new BigDecimal("0.74");
        ar[6] = new BigDecimal("-1.2");
        ar[7] = new BigDecimal("0.096");


        System.out.print("Eingabe: [");
        for(BigDecimal s : ar)
        {
            System.out.print(s+", ");
        }
        System.out.print("]");
        System.out.println();

        BigDecimal[] big = buildTableSigned(ar);
        System.out.print("Tabelle: [");
        for(BigDecimal s : big)
        {
            System.out.print(s+", ");
        }
        System.out.print("]");
        System.out.println();

        Range rng = compute(ar,big);
        System.out.println(rng.toString());

        System.out.println("----------------------------------------------------------------");

        BigDecimal[] ar2 = new BigDecimal[8];

        ar2[0] = new BigDecimal("0.85");
        ar2[1] = new BigDecimal("0.52");
        ar2[2] = new BigDecimal("0.33");
        ar2[3] = new BigDecimal("-1.7");
        ar2[4] = new BigDecimal("-2.0");
        ar2[5] = new BigDecimal("0.041");
        ar2[6] = new BigDecimal("0.042");
        ar2[7] = new BigDecimal("1.1");


        System.out.print("Eingabe: [");
        for(BigDecimal t : ar2)
        {
            System.out.print(t+", ");
        }
        System.out.print("]");
        System.out.println();

        BigDecimal[] big2 = buildTableSigned(ar2);
        System.out.print("Tabelle: [");
        for(BigDecimal t : big2)
        {
            System.out.print(t+", ");
        }
        System.out.print("]");
        System.out.println();

        Range rng2 = compute(ar2,big2);
        System.out.println(rng2.toString());

    }

}
