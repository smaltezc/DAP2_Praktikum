import java.util.ArrayList;
import java.util.Scanner;

public class AVLTreeApplication {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            if(!sc.hasNext())
            {
                System.out.println( "FEHLER: Leere Eingabe. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
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
                        System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
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
                                    System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
                                    return;
                                }
                            }

                            int[] array = new int[numbers.size()];
                            for (int i = 0; i< array.length;i++)
                            {
                                array[i] = numbers.get(i);
                            }

                            AVLTree avlt = new AVLTree(array);
                            avlt.printInOrder();
                            System.out.println("----------");
                        }
                        else
                        {
                            System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                            System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
                            return;
                        }

                    }

                    break;
                case "pre" :
                    if(!sc.hasNext())
                    {
                        System.out.println( "FEHLER: Traversierung, aber keine Integer gefunden. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                        System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
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
                                    System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
                                    return;
                                }
                            }

                            int[] array = new int[numbers.size()];
                            for (int i = 0; i< array.length;i++)
                            {
                                array[i] = numbers.get(i);
                            }

                            AVLTree avlt = new AVLTree(array);
                            avlt.printPreOrder();
                            System.out.println("----------");
                        }
                        else
                        {
                            System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                            System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
                            return;
                        }

                    }

                    break;
                case "post" :
                    if(!sc.hasNext())
                    {
                        System.out.println( "FEHLER: Traversierung, aber keine Integer gefunden. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                        System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
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
                                    System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
                                    return;
                                }
                            }

                            int[] array = new int[numbers.size()];
                            for (int i = 0; i< array.length;i++)
                            {
                                array[i] = numbers.get(i);
                            }

                            AVLTree avlt = new AVLTree(array);
                            avlt.printPostOrder();
                            System.out.println("----------");
                        }
                        else
                        {
                            System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                            System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
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
                                System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
                                return;
                            }
                        }

                        int[] array = new int[numbers.size()];
                        for (int i = 0; i< array.length;i++)
                        {
                            array[i] = numbers.get(i);
                        }

                        AVLTree avlt = new AVLTree(array);
                        avlt.printInOrder();
                        System.out.println("----------");



                        if(!sc.hasNext())
                        {
                            System.out.println( "FEHLER: Traversierung, aber keine Integer gefunden. Die Datei muss mindestens eine Zeile mit durch Kommas getrennte Integer enthalten.");
                            System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
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
                                        System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
                                        return;
                                    }
                                }

                                int[] array1 = new int[numbers1.size()];
                                for (int i = 0; i< array1.length;i++)
                                {
                                    array1[i] = numbers1.get(i);
                                }

                                AVLTree avlt1 = new AVLTree(array1);
                                avlt1.printInOrder();
                                System.out.println("----------");
                            }
                            else
                            {
                                System.out.println( "FEHLER: Zeilen duerfen nur aus Integern bestehen.");
                                System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
                                return;
                            }

                        }


                    }
                    else
                    {
                        System.out.println( "FEHLER: Unbekannte Traversierung: " + firstZeile);
                        System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
                    }

            }

            sc.close();
        }
        catch (Exception e) //FileNotFoundException
        {
            System.out.println( "Aufruf: java AVLTreeApplication < <filename>");
        }



    }

    static boolean hasNums(String text) {

        return text.matches(".*\\d.*");
    }


}
