// merging each down already sorted branch into a sorted branch

/*
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45
 */

/*
5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 30 -> 35 -> 40 -> 45 -> 50 -> null
 */

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
    }
}

public class _50_3_FlattenLL {
    public static void main(String[] args) {
        // main branch
        Node five = new Node(5);
        Node ten = new Node(10);
        Node nineteen = new Node(19);
        Node twenty8 = new Node(28);

        // bottom branch
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node thirty = new Node(30);
        Node twenty2 = new Node(22);
        Node twenty = new Node(20);
        Node fifty = new Node(50);
        Node thirty5 = new Node(35);
        Node forty = new Node(40);
        Node forty5 = new Node(45);

        // horizontal branching
        five.next = ten;
        ten.next = nineteen;
        nineteen.next = twenty8;

        // bottom branching
        five.bottom = seven;
        seven.bottom = eight;
        eight.bottom = thirty;

        ten.bottom = twenty;
        nineteen.bottom = twenty2;
        twenty2.bottom = fifty;

        twenty8.bottom = thirty5;
        thirty5.bottom = forty;
        forty.bottom = forty5;

        Node head = five;

        head = flatten(head);

        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.bottom;
        }
        System.out.print("null");
    }

    static Node flatten(Node root) {
        if (root.next == null || root == null)
            return root;

        Node temp = flatten(root.next);
        return merge(temp, root);
    }

    static Node merge(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                curr.bottom = l1;
                l1 = l1.bottom;
            } else {
                curr.bottom = l2;
                l2 = l2.bottom;
            }
            curr = curr.bottom;
        }

        curr.bottom = l1 != null ? l1 : l2;

        return dummy.bottom;
    }
}
