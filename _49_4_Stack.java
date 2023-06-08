// Implementing Stack using Queue

import java.util.ArrayDeque;
import java.util.Queue;

class Stackx {
    Queue<Integer> q1, q2;

    Stackx() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    int pop() {
        return q1.poll();
    }

    void push(int data) {
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        q1.add(data);
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    boolean isEmpty() {
        return q1.isEmpty();
    }
}

public class _49_4_Stack {
    public static void main(String[] args) {
        Stackx s = new Stackx();

        s.push(5);
        s.push(6);
        s.push(7);
        s.push(9);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
