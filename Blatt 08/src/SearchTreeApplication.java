import java.util.ArrayList;
import java.util.Scanner;

public class SearchTreeApplication {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            if(!sc.hasNext())
            {
                System.out.println( "FEHLER: Leere Eingabe. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                System.out.println("Aufruf: java SearchTreeApplication < <filename>");
                return;
            }

            String firstZeile = sc.next();

           // System.out.println(firstZeile);

            switch (firstZeile)
            {
                case "in" :
                    if(!sc.hasNext())
                    {
                        System.out.println( "FEHLER: Traversierung, aber keine Integer gefunden. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                        System.out.println("Aufruf: java SearchTreeApplication < <filename>");
                        return;
                    }


                    while (sc.hasNext())
                    {
                        String zeile = sc.next();

                        if(hasNums(zeile))
                        {
                            String[] line = zeile.split(",");
                            ArrayList<Integer> numbers = new ArrayList<>();

                            for(String s: line)
                            {
                                try {
                                    int a = Integer.parseInt(s);
                                    numbers.add(a);
                                }
                                catch (Exception e)
                                {
                                    System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                                    System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                                    return;
                                }
                            }

                            int[] array = new int[numbers.size()];
                            for (int i = 0; i< array.length;i++)
                            {
                                array[i] = numbers.get(i);
                            }

                            SearchTree st = new SearchTree(array);
                            System.out.println("Hoehe: "+ st.maxDepth(SearchTree.root));
                            SearchTree.inOrder(SearchTree.root);
                            System.out.println();
                        }
                        else
                        {
                            System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                            System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                            return;
                        }

                    }

                    break;
                case "pre" :
                    if(!sc.hasNext())
                    {
                        System.out.println( "FEHLER: Traversierung, aber keine Integer gefunden. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                        System.out.println("Aufruf: java SearchTreeApplication < <filename>");
                        return;
                    }


                    while (sc.hasNext())
                    {
                        String zeile = sc.next();

                        if(hasNums(zeile))
                        {

                            String[] line = zeile.split(",");
                            ArrayList<Integer> numbers = new ArrayList<>();

                            for(String s: line)
                            {
                                try {
                                    int a = Integer.parseInt(s);
                                    numbers.add(a);
                                }
                                catch (Exception e)
                                {
                                    System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                                    System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                                    return;
                                }
                            }

                            int[] array = new int[numbers.size()];
                            for (int i = 0; i< array.length;i++)
                            {
                                array[i] = numbers.get(i);
                            }

                            SearchTree st = new SearchTree(array);
                            System.out.println("Hoehe: "+ st.maxDepth(SearchTree.root));
                            SearchTree.preOrder(SearchTree.root);
                            System.out.println();
                        }
                        else
                        {
                            System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                            System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                            return;
                        }

                    }

                    break;
                case "post" :
                    if(!sc.hasNext())
                    {
                        System.out.println( "FEHLER: Traversierung, aber keine Integer gefunden. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                        System.out.println("Aufruf: java SearchTreeApplication < <filename>");
                        return;
                    }


                    while (sc.hasNext())
                    {
                        String zeile = sc.next();

                        if(hasNums(zeile))
                        {

                            String[] line = zeile.split(",");
                            ArrayList<Integer> numbers = new ArrayList<>();

                            for(String s: line)
                            {
                                try {
                                    int a = Integer.parseInt(s);
                                    numbers.add(a);
                                }
                                catch (Exception e)
                                {
                                    System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                                    System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                                    return;
                                }
                            }

                            int[] array = new int[numbers.size()];
                            for (int i = 0; i< array.length;i++)
                            {
                                array[i] = numbers.get(i);
                            }

                            SearchTree st = new SearchTree(array);
                            System.out.println("Hoehe: "+ st.maxDepth(SearchTree.root));
                            SearchTree.postOrder(SearchTree.root);
                            System.out.println();
                        }
                        else
                        {
                            System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                            System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                            return;
                        }

                    }
                    break;

                default:
                    if(hasNums(firstZeile)) // in-order
                    {
                        String[] line = firstZeile.split(",");
                        ArrayList<Integer> numbers = new ArrayList<>();

                        for(String s: line)
                        {
                            try {
                                int a = Integer.parseInt(s);
                                numbers.add(a);
                            }
                            catch (Exception e)
                            {
                                System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                                System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                                return;
                            }
                        }

                        int[] array = new int[numbers.size()];
                        for (int i = 0; i< array.length;i++)
                        {
                            array[i] = numbers.get(i);
                        }

                        SearchTree st = new SearchTree(array);
                        System.out.println("Hoehe: "+ st.maxDepth(SearchTree.root));
                        SearchTree.inOrder(SearchTree.root);
                        System.out.println();



                        if(!sc.hasNext())
                        {
                            System.out.println( "FEHLER: Traversierung, aber keine Integer gefunden. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                            System.out.println("Aufruf: java SearchTreeApplication < <filename>");
                            return;
                        }


                        while (sc.hasNext())
                        {
                            String zeile = sc.next();

                            if(hasNums(zeile))
                            {

                                String[] line1 = zeile.split(",");
                                ArrayList<Integer> numbers1 = new ArrayList<>();

                                for(String s: line1)
                                {
                                    try {
                                        int a = Integer.parseInt(s);
                                        numbers1.add(a);
                                    }
                                    catch (Exception e)
                                    {
                                        System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                                        System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                                        return;
                                    }
                                }

                                int[] array1 = new int[numbers1.size()];
                                for (int i = 0; i< array1.length;i++)
                                {
                                    array1[i] = numbers1.get(i);
                                }

                                SearchTree st1 = new SearchTree(array1);
                                System.out.println("Hoehe: "+ st1.maxDepth(SearchTree.root));
                                SearchTree.inOrder(SearchTree.root);
                                System.out.println();
                            }
                            else
                            {
                                System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                                System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                                return;
                            }

                        }


                    }
                    else
                    {
                        System.out.println( "FEHLER: Unbekannte Traversierung: " + firstZeile);
                        System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                    }

            }

            sc.close();
        }
        catch (Exception e) //FileNotFoundException
        {
            System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
        }



    }

    static boolean hasNums(String text) {

        return text.matches(".*\\d.*");
    }


}
