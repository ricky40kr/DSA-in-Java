// converting binary to doubly linked List

/*
           5
        /    \
       1     7
      / \    /
     2  4   8
       / \
     3    6
 */

public class _54_BinaryToDLL {

    static class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node five = new Node(5);
        Node one = new Node(1);
        Node two = new Node(2);
        Node four = new Node(4);
        Node three = new Node(3);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);

        // join
        five.left = one;
        five.right = seven;
        one.left = two;
        one.right = four;
        four.left = three;
        four.right = six;
        seven.left = eight;

        Node root = five;

        Node head = bToDLL(root);
        Node temp = head;
        System.out.println("***Left-To-Right***");
        while (temp.right != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
        System.out.print(temp.data + " ");

        System.out.println("\n\n***Right-To-Left***");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.left;
        }
    }

    static Node head = null, prev = null;

    static Node bToDLL(Node root) {
        if (root == null)
            return null;

        bToDLL(root.left);

        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        bToDLL(root.right);

        return head;
    }
}
