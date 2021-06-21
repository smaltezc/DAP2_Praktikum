import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SearchTreeApplication {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            if(!sc.hasNext())
            {
                System.out.println( "Leere Eingabe. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                return;
            }

            String firstZeile = sc.next();

           // System.out.println(firstZeile);

            switch (firstZeile)
            {
                case "in" :
                    if(!sc.hasNext())
                    {
                        System.out.println( "Traversierung, aber keine Integer gefunden. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                        return;
                    }


                    while (sc.hasNext())
                    {
                        String zeile = sc.next();

                        if(zeile.contains(","))
                        {
                            if(!hasNums(zeile))
                            {
                                System.out.println( "Zeilen duerfen nur aus Integern bestehen.");
                                System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                                return;
                            }
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
                                    System.out.println( "Zeilen duerfen nur aus Integern bestehen.");
                                    System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
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
                            System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                            return;
                        }

                    }

                    break;
                case "pre" :
                    if(!sc.hasNext())
                    {
                        System.out.println( "Traversierung, aber keine Integer gefunden. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                        return;
                    }


                    while (sc.hasNext())
                    {
                        String zeile = sc.next();

                        if(zeile.contains(","))
                        {
                            if(!hasNums(zeile))
                            {
                                System.out.println( "Zeilen duerfen nur aus Integern bestehen.");
                                System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                                return;
                            }
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
                                    System.out.println( "Zeilen duerfen nur aus Integern bestehen.");
                                    System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
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
                            System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                            return;
                        }

                    }

                    break;
                case "post" :
                    if(!sc.hasNext())
                    {
                        System.out.println( "Traversierung, aber keine Integer gefunden. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                        return;
                    }


                    while (sc.hasNext())
                    {
                        String zeile = sc.next();

                        if(zeile.contains(","))
                        {
                            if(!hasNums(zeile))
                            {
                                System.out.println( "Zeilen duerfen nur aus Integern bestehen.");
                                System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                                return;
                            }
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
                                    System.out.println( "Zeilen duerfen nur aus Integern bestehen.");
                                    System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
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
                            System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                            return;
                        }

                    }

                    break;
                default:
                    if(firstZeile.contains(",")) // in-order
                    {
                        Scanner sc2 = new Scanner(System.in);

                        while (sc2.hasNext())
                        {
                            String zeile = sc2.next();
                            if(!hasNums(zeile))
                            {
                                System.out.println( "Zeilen duerfen nur aus Integern bestehen.");
                                System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
                                return;
                            }

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
                                    System.out.println( "Zeilen duerfen nur aus Integern bestehen.");
                                    System.out.println( "Aufruf: java SearchTreeApplication < <filename>");
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
                        sc2.close();


                    }
                    else
                    {
                        System.out.println( "Unbekannte Traversierung: <traversierung>");
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
