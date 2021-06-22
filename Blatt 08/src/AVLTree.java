
class AVLTree {

    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    public static Node root;

    // A utility function to get the height of the tree
    public int getHeight()
    {
        return height(root);
    }

    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }



    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);

    }

    public AVLTree(int[] array)
    {
        root = null;

        for(int i : array)

        {
            insertElement(i);
        }

    }

    public void insertElement(int element)
    {
        System.out.println("Fuege " + element + " in AVL-Baum ein.");
        root = insert(root, element);

    }


    Node insert(Node node, int key) {

        /* 1. Perform the normal BST insertion */
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),  height(node.right));

		/* 3. Get the balance factor of this ancestor
			node to check whether this node became
			unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            System.out.println("Linker Teilbaum von \"" + node.key + "\" hat Hoehe " + height(node.left) +". Rechter Teilbaum hat Hoehe "+ height(node.right) + ".");
            System.out.println("Fuehre Rechts-Rotation durch");

            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.key) {


            System.out.println("Rechter Teilbaum von \"" + node.key + "\" hat Hoehe " + height(node.right) + ". Linker Teilbaum hat Hoehe " + height(node.left) + ".");
            System.out.println("Fuehre Links-Rotation durch");

            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            System.out.println("Linker Teilbaum von \"" + node.key + "\" hat Hoehe " + height(node.left) +". Rechter Teilbaum hat Hoehe "+ height(node.right) + ".");
            System.out.println("Fuehre Links-Rechts-Rotation durch");

            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            System.out.println("Rechter Teilbaum von \"" +  node.key + "\" hat Hoehe " + height(node.right) + ". Linker Teilbaum hat Hoehe " + height(node.left) + ".");
            System.out.println("Fuehre Rechts-Links-Rotation durch");

            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    public void printInOrder()
    {
        System.out.println("Hoehe: "+getHeight());
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    public void printPreOrder()
    {
        System.out.println("Hoehe: "+getHeight());
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void printPostOrder()
    {
        System.out.println("Hoehe: "+getHeight());
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

}
