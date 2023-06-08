// Implementing Queue using Stack

import java.util.Stack;

class Queuex {
    Stack<Integer> s1, s2;

    Queuex() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    void push(int data) {
        s1.push(data);
    }

    int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int data = s2.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return data;
    }

    boolean isEmpty() {
        return s1.isEmpty();
    }
}

public class _49_3_Queue {
    public static void main(String[] args) {
        Queuex q = new Queuex();

        q.push(5);
        q.push(10);
        q.push(5);
        q.push(6);

        while (!q.isEmpty()) {
            System.out.print(q.pop() + " ");
        }
    }
}
