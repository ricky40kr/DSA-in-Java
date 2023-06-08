// Implementing queue using array

import java.util.ArrayList;

class Queue {
    int front, rear, size, capacity;
    int arr[];

    Queue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        arr = new int[this.capacity];
    }

    boolean isFull(Queue queue) {
        return (queue.size == queue.capacity);
    }

    boolean isEmpty(Queue queue) {
        return (queue.size == 0);
    }

    void enqueue(int item) {
        if (isFull(this)) {
            System.out.println("Queue OverFlow!");
            return;
        }

        this.rear = (this.rear + 1) % this.capacity;
        this.arr[this.rear] = item;
        this.size = this.size + 1;
    }

    void dequeue() {
        if (isEmpty(this)) {
            System.out.println("Queue is Empty!");
            return;
        }

        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
    }

    int peekFront() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.arr[this.front];
    }

    int peekRear() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.arr[this.rear];
    }

    ArrayList<Integer> items() {
        ArrayList<Integer> list = new ArrayList<>();
        int i = front;
        int j = rear;
        while (i != (j + 1) % capacity) {
            list.add(arr[i]);
            i = (i + 1) % capacity;
        }

        return list;
    }
}

public class _49_2_Queue {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        System.out.println(q.isEmpty(q));
        q.enqueue(10);
        System.out.println(q.isEmpty(q));
        q.enqueue(5);
        q.enqueue(-5);
        q.enqueue(6);
        q.enqueue(5);
        q.enqueue(100);
        System.out.println(q.isFull(q));
        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println(q.size);
        System.out.println(q.items());
        q.enqueue(-6);
        System.out.println(q.items());
        System.out.println(q.peekFront());
        System.out.println(q.peekRear());

    }
}
