
public class CoinChange {
    public static  void main(String[] args)
    {
        if(args.length != 2)
        {
            System.out.println("FEHLER: Falsche Parameteranzahl!");
            System.out.println("Aufruf mit : java CoinChange Euro|Mira n");
            System.out.println("Bsp: java CoinChange Euro 100");
            return;
        }

        switch (args[0])
        {
            case "Euro":
                try {
                    int wechselgeld = Integer.parseInt(args[1]);
                    if(wechselgeld < 0)
                    {
                        System.out.println("FEHLER: Wechselgeld darf nicht negativ sein!");
                        System.out.println("Aufruf mit : java CoinChange Euro|Mira n");
                        System.out.println("Bsp: java CoinChange Euro 100");
                        return;
                    }

                    int[] w = {200,100,50,20,10,5,2,1};
                    int[] n = change(wechselgeld,w);

                    System.out.println("Auszugebendes Wechselgeld: "+ wechselgeld +" Eurocent");
                    int sum =0;
                    for(int i = 0; i< n.length; i++)
                    {
                        if(n[i]>0)
                        {
                            int r =wechselgeld-w[i]*n[i];
                            wechselgeld = wechselgeld-w[i]*n[i];
                            String s = "(" + w[i] + "," + n[i] + "," + r +")";
                            System.out.println(s);
                            sum += w[i]*n[i];
                        }
                    }
                    System.out.println("Ausgegebenes Wechselgeld: "+ sum +" Eurocent");


                }
                catch (Exception e)
                {
                    System.out.println("FEHLER: Falscher Parametertyp fuer das Wechselgeld!");
                    System.out.println("Aufruf mit : java CoinChange Euro|Mira n");
                    System.out.println("Bsp: java CoinChange Euro 100");
                }
                break;
            case "Mira":
                try {
                    int wechselgeld = Integer.parseInt(args[1]);
                    if(wechselgeld < 0)
                    {
                        System.out.println("FEHLER: Wechselgeld darf nicht negativ sein!");
                        System.out.println("Aufruf mit : java CoinChange Euro|Mira n");
                        System.out.println("Bsp: java CoinChange Euro 100");
                        return;
                    }
                    int[] w ={200,100,50,20,10,9,7,5,2,1};
                    int[] n = change(wechselgeld,w);

                    System.out.println("Auszugebendes Wechselgeld: "+ wechselgeld +" Mira");
                    int sum =0;
                    for(int i = 0; i< n.length; i++)
                    {
                        if(n[i]>0)
                        {
                            int r =wechselgeld-w[i]*n[i];
                            wechselgeld = wechselgeld-w[i]*n[i];
                            String s = "(" + w[i] + "," + n[i] + "," + r +")";
                            System.out.println(s);
                            sum += w[i]*n[i];
                        }
                    }
                    System.out.println("Ausgegebenes Wechselgeld: "+ sum +" Mira");
                }
                catch (Exception e)
                {
                    System.out.println("FEHLER: Falscher Parametertyp fuer das Wechselgeld!");
                    System.out.println("Aufruf mit : java CoinChange Euro|Mira n");
                    System.out.println("Bsp: java CoinChange Euro 100");
                }
                break;
            default:
                System.out.println("FEHLER: Unbekannte Waehrung "+ args[0] +"!");
                System.out.println("Aufruf mit : java CoinChange Euro|Mira n");
                System.out.println("Bsp: java CoinChange Euro 100");

        }
    }

    public static int[] change(int betrag,int[] w)
    {
        int[] rck = new int[w.length];
        for(int i = 0 ; i < w.length ; i++)
        {
            if(betrag >= w[i])
            {
                int n =0;
                while(0 <= betrag - n*w[i] )
                {
                    n++;
                }
                n--;
                if(betrag - n*w[i]<w[i])
                {
                    rck[i] = n;
                    betrag = betrag - n*w[i];
                }

            }
        }
        return rck;
    }
}
