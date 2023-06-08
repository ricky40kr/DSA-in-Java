// LL flattened using pointers
// O(1) space is used

/*
    1 -> 2-> 3 -> 4 -> 5
    |             |
    6 -> 7 -> 8   9 -> 10
         |    |   |
         11   12  13 -> 14
              |   |
              15  16 -> 17 
         
 */

// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16 -> 17 -> null

class Node {
    int data;
    Node next;
    Node down;

    Node(int data) {
        this.data = data;
    }
}

public class _50_2_FlattenLL {
    public static void printOriginalList(Node head) {
        if (head == null) {
            return;
        }

        System.out.print(" " + head.data + " ");

        if (head.down != null) {
            System.out.print("[");
            printOriginalList(head.down);
            System.out.print("]");
        }

        printOriginalList(head.next);
    }

    // Utility function to print a linked list
    public static void printFlattenedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Recursive function to flatten a multilevel linked list
    public static Node flattenList(Node head) {
        if (head == null)
            return null;

        Node tail = head;
        Node curr = head;
        Node temp = null;

        while (tail.next != null) {
            tail = tail.next;
        }

        while (curr != tail) {
            if (curr.down != null) {
                tail.next = curr.down;
                temp = curr.down;

                while (temp.next != null) {
                    temp = temp.next;
                }

                tail = temp;
            }
            curr = curr.next;
        }

        return head;
    }

    // public static Node flattenList(Node head) {
    // if (head == null)
    // return null;

    // Node temp = null;
    // Node tail = head;

    // while (tail.next != null)
    // tail = tail.next;

    // Node curr = head;

    // while (curr != tail) {
    // if (curr.down != null) {
    // tail.next = curr.down;
    // temp = curr.down;

    // while (temp.next != null) {
    // temp = temp.next;
    // }

    // tail = temp;
    // }
    // curr = curr.next;
    // }

    // return head;
    // }

    public static void main(String[] args) {
        // create individual nodes and link them together later
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        Node twelve = new Node(12);
        Node thirteen = new Node(13);
        Node fourteen = new Node(14);
        Node fifteen = new Node(15);
        Node sixteen = new Node(16);
        Node seventeen = new Node(17);

        // set head node
        Node head = one;

        // set next pointers
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        six.next = seven;
        seven.next = eight;
        nine.next = ten;
        thirteen.next = fourteen;
        sixteen.next = seventeen;

        // set down pointers
        one.down = six;
        seven.down = eleven;
        eight.down = twelve;
        twelve.down = fifteen;
        four.down = nine;
        nine.down = thirteen;
        thirteen.down = sixteen;

        System.out.println("The original list is :");
        printOriginalList(head);

        head = flattenList(head);
        System.out.println("\n\nThe flattened list is :");
        printFlattenedList(head);
    }
}
