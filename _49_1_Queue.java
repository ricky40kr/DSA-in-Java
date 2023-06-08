// Queue implimentation using LinkedList

import java.util.ArrayList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Queuex {
    Node front, rear;
    int len = 0;

    void enqeue(int data) {
        Node newNode = new Node(data);
        len++;

        if (front == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = rear.next;
    }

    void deqeue() {
        if (front == null) {
            return;
        }
        front = front.next;
        len--;

    }

    int size() {
        return len;
    }

    ArrayList<Integer> items() {
        Node temp = front;
        ArrayList<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        return list;
    }
}

public class _49_1_Queue {

    public static void main(String[] args) {
        Queuex q = new Queuex();
        q.enqeue(15);
        q.enqeue(-5);
        q.enqeue(0);
        q.enqeue(100);
        q.enqeue(9);
        System.out.println(q.size());
        System.out.println(q.items());
        q.deqeue();
        q.deqeue();
        q.enqeue(111);
        System.out.println(q.items());

    }
}
