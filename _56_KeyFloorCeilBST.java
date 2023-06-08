// to find floor ans ceil value of key ingiven bfsToMapParents
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class _56_KeyFloorCeilBST {

    public static void main(String[] args) {
        /*
         * 10
         * / \
         * 5 11
         * / \
         * 4 7
         * \
         * 8
         */

        Node n10 = new Node(10);
        Node n5 = new Node(5);
        Node n11 = new Node(11);
        Node n4 = new Node(4);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n10.left = n5;
        n10.right = n11;
        n5.right = n7;
        n5.left = n4;
        n4.right = n8;

        int key1 = 6;
        int key2 = 50;

        System.out.println("Ceil for " + key1 + " : " + findCeil(n10, key1));
        System.out.println("Floor for " + key1 + " : " + findFloor(n10, key1));
        System.out.println("Ceil for " + key2 + " : " + findCeil(n10, key2));
        System.out.println("Floor for " + key2 + " : " + findFloor(n10, key2));

    }

    static int findCeil(Node root, int key) {
        int ans = -1;

        while (root != null) {
            if (root.data == key)
                return root.data;
            if (root.data > key) {
                ans = root.data;
                root = root.left;
            } else
                root = root.right;
        }

        return ans;
    }

    static int findFloor(Node root, int key) {
        int ans = -1;

        while (root != null) {
            if (root.data == key)
                return root.data;
            if (root.data > key) {
                root = root.left;
            } else {
                ans = root.data;
                root = root.right;
            }
        }

        return ans;
    }
}