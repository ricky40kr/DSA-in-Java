class Node {
    int value;
    Node next;

    Node(int n) {
        value = n;
        next = null;
    }
}

public class _23_LinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node head = n1;
        Node n2 = new Node(0);
        Node n3 = new Node(-50);
        Node n4 = new Node(100);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
