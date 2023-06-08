// Binary Tree Implimentation with it's all traversal orders

import java.util.Scanner;

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class _52_BinaryTree {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node head = createTree();
        System.out.print("InOrder : ");
        inOrder(head);
        System.out.print("\nPreOrder : ");
        preOrder(head);
        System.out.print("\nPostOrder : ");
        postOrder(head);
        System.out.println("\nTree Height : " + treeHeight(head));
    }

    static int treeHeight(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
    }

    static Node createTree() {
        Node root = null;
        System.out.print("Enter Data : ");
        int data = sc.nextInt();

        if (data == -1)
            return null;

        root = new Node(data);

        System.out.print("For left of " + data + " ");
        root.left = createTree();
        System.out.print("For right of  " + data + " ");
        root.right = createTree();

        return root;
    }

    static void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

}
