// Implimentation of LinkedList

class _44_LinkedList<T> {
    Node head = null;
    private int length = 0;

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void size() {
        System.out.println(length);
    }

    // add - first, last
    public void addFirst(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            length++;
            return;
        }

        newNode.next = head;
        head = newNode;
        length++;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            length++;
            return;
        }

        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }

        pointer.next = newNode;
        length++;
    }

    // Traverse
    void traverse() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // delete first
    void deleteFirst() {
        if (head == null) {
            System.out.println("Empty List!");
            return;
        }

        head = head.next;
        length--;
    }

    // delete last
    void deleteLast() {
        if (head == null) {
            System.out.println("Empty List!");
            return;
        }

        if (head.next == null) {
            head = null;
            length--;
        }

        Node curr = head;

        while (curr.next.next != null) {
            curr = curr.next;
        }

        curr.next = null;
        length--;
    }

    public static void main(String[] args) {
        _44_LinkedList<Integer> ll = new _44_LinkedList<>();

        ll.addFirst(0);
        ll.addLast(10);
        ll.addLast(5);
        ll.addFirst(-5);
        ll.addLast(6);
        ll.addLast(65);

        ll.traverse();
        ll.size();

        ll.deleteFirst();
        ll.traverse();
        ll.size();

        ll.deleteLast();
        ll.traverse();
        ll.size();

    }
}
