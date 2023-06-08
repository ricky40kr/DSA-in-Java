
/*
         5
        / \
       1  7
      / \
     2  4
      / \
     3  6
 */
// level order traversal is BFS
import java.util.LinkedList;
import java.util.Queue;

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class _52_LevelOrderTraversal {
    public static void main(String[] args) {
        Node five = new Node(5);
        Node one = new Node(1);
        Node two = new Node(2);
        Node four = new Node(4);
        Node three = new Node(3);
        Node six = new Node(6);
        Node seven = new Node(7);

        // join
        five.left = one;
        five.right = seven;
        one.left = two;
        one.right = four;
        four.left = three;
        four.right = six;

        Node root = five;
        System.out.println("****Single Liner***");
        printOrderOneLiner(root);
        System.out.println("\n\n***Multi Liner***");
        printOrderMultiLiner(root);
    }

    // printing the level order traversal in single line
    static void printOrderOneLiner(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    // printing each level order traversal in diff line
    static void printOrderMultiLiner(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                if (q.isEmpty())
                    return;

                q.add(null);
                System.out.println();
                continue;
            }

            System.out.print(curr.data + " ");

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }
}
