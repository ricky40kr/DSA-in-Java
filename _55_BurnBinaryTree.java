import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class _55_BurnBinaryTree {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.right = n7;
        n3.right = n6;
        n3.left = n5;

        /*
         * 1
         * / \
         * 2 3
         * / / \
         * 4 5 6
         * \
         * 7
         */

        System.out.println(timeToBurnTree(n1, 2));
    }

    static int timeToBurnTree(Node root, int start) {
        HashMap<Node, Node> map = new HashMap<>(); // to store parent of each node
        Node target = bfsToMapParents(root, map, start); // fills the map and return the node having value == start
        int maxi = findMaxDistance(map, target);

        return maxi;
    }

    static Node bfsToMapParents(Node root, HashMap<Node, Node> map, int start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node res = new Node(-1);

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.data == start)
                res = n;
            if (n.left != null) {
                map.put(n.left, n);
                q.offer(n.left);
            }
            if (n.right != null) {
                map.put(n.right, n);
                q.offer(n.right);
            }
        }

        return res;
    }

    static int findMaxDistance(HashMap<Node, Node> map, Node target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(target);
        HashMap<Node, Integer> visited = new HashMap<>();
        visited.put(target, 1);
        int maxi = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            int flag = 0; // to keep check for burning at least one child node or parent node

            for (int i = 0; i < sz; i++) {
                Node n = q.poll();

                // for left child
                if (n.left != null && visited.get(n.left) == null) {
                    flag = 1;
                    visited.put(n.left, 1);
                    q.offer(n.left);
                }

                // for right child
                if (n.right != null && visited.get(n.right) == null) {
                    flag = 1;
                    visited.put(n.right, 1);
                    q.offer(n.right);
                }

                // for parent
                if (map.get(n) != null && visited.get(map.get(n)) == null) {
                    flag = 1;
                    visited.put(map.get(n), 1);
                    q.offer(map.get(n));
                }
            }
            if (flag == 1)
                maxi++;
        }

        return maxi;
    }

}
