import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int val;
        int ht;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.ht = 0;
        }
    }

    static int height(Node n) {
        return n == null ? -1 : n.ht;
    }

    static void update(Node n) {
        n.ht = 1 + Math.max(height(n.left), height(n.right));
    }

    static int balance(Node n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    static Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        update(y);
        update(x);
        return x;
    }

    static Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        update(x);
        update(y);
        return y;
    }

    static Node insert(Node root, int val) {
        if (root == null)
            return new Node(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);
        else
            return root;


        update(root);


        int bf = balance(root);

        if (bf > 1) {
            if (balance(root.left) < 0)
                root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        if (bf < -1) {
            if (balance(root.right) > 0)
                root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    static void append(StringBuilder sb, Node n) {
        if (sb.length() > 0)
            sb.append(' ');
        sb.append(n.val).append("(BF=").append(balance(n)).append(")");
    }

    static void inOrder(Node root, StringBuilder sb) {
        if (root == null)
            return;
        inOrder(root.left, sb);
        append(sb, root);
        inOrder(root.right, sb);
    }

    static void preOrder(Node root, StringBuilder sb) {
        if (root == null)
            return;
        append(sb, root);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        Node root = null;
        for (int i = 0; i < n; i++) {
            root = insert(root, scan.nextInt());
        }

        int newVal = scan.nextInt();
        scan.close();
        root = insert(root, newVal);

        StringBuilder in = new StringBuilder();
        inOrder(root, in);
        System.out.println(in);

        StringBuilder pre = new StringBuilder();
        preOrder(root, pre);
        System.out.println(pre);
    }
}