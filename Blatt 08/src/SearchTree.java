public class SearchTree {

    public static Node root;

    public static void main(String[] args)
    {
        int[] arr = {50,30,20,40,70,60,80};

        SearchTree src = new SearchTree(arr);

        //inOrder(src.root);

    }

    static class Node
    {
        int key;
        Node left, right;

    }

    static Node newNode(int data)
    {
        Node temp = new Node();

        temp.key = data;

        temp.left = null;
        temp.right = null;

        return temp;
    }

    //Hoehe
    int maxDepth(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public SearchTree(int[] array)
    {
        root = null;

        root = insert(root, array[0]);
        for(int i =0; i< array.length-1; i++)
        {
            insert(root, array[i+1]);
        }
    }

    //public static void add(int value){ insert(root, value);}

    public static Node insert(Node root, int key)
    {

        Node nwNode = newNode(key);

        Node x = root;

        Node y = null;

        while(x != null)
        {
            y = x;
            if(key < x.key)
            {
                x = x.left;
            }
            else
            {
                x = x.right;
            }
        }

        if(y == null)
        {
            y = nwNode;
        }
        else if (key < y.key)
        {
            y.left = nwNode;
        }
        else
        {
            y.right = nwNode;
        }

        return y;

    }

    public static void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
        else
        {
            return;
        }
    }

    public static void preOrder(Node root)
    {
        if (root != null) {
            System.out.print(root.key+ " ");
            inOrder(root.left);
            inOrder(root.right);
        }
    }

    public static void postOrder(Node root)
    {
        if (root != null) {
            inOrder(root.left);
            inOrder(root.right);
            System.out.print(root.key + " ");
        }
    }

}




