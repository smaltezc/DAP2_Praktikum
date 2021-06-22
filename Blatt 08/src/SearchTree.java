
class SearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    public static Node root;

    SearchTree(int[] array) {
        root = null;

        for(int i:array)
        {
            insert(i);
        }
    }

    void insert(int key) {
        root = insertKey(root, key);
    }

    // Insert key in the tree
    Node insertKey(Node root, int key) {
        // Return a new node if the tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Traverse to the right place and insert the node
        if (key < root.key)
            root.left = insertKey(root.left, key);
        else if (key > root.key)
            root.right = insertKey(root.right, key);

        return root;
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
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void postOrder(Node root)
    {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + " ");
        }
    }

}




