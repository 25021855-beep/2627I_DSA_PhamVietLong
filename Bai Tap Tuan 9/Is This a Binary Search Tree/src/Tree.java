import java.util.*;

public class Tree {
    Vector<Integer> values;
    private int count;

    Tree() {
        this.values = new Vector<Integer>();
        this.count = 0;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node() {
            this.data = -1;
            this.left = null;
            this.right = null;
        }
    }

    private long prev;
    boolean checkBST(Node root) {
        prev = Long.MIN_VALUE;
        return walk(root);
    }

    private boolean walk(Node node) {
        while (node != null) {
            if (!walk(node.left))
                return false;
            if (node.data <= prev)
                return false;
            prev = node.data;
            node = node.right;
        }
        return true;
    }

    void inOrder (Node root, int levels) {

        if(root != null) {
            if (levels > 0) {
                root.left = new Node();
                inOrder(root.left, levels - 1);
            }

            // Set node data:
            root.data = values.elementAt(count);
            count++;

            if (levels > 0) {
                // Create a new right child node:
                root.right = new Node();
                inOrder(root.right, levels - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int height = scanner.nextInt();

        Tree tree = new Tree();
        while(scanner.hasNext()) {
            tree.values.add(scanner.nextInt());
        }
        scanner.close();
        Node root = new Node();
        tree.inOrder(root, height);
        System.out.println( (tree.checkBST(root) == true) ? "Yes" : "No" );

    }
}