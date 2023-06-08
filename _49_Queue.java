// Queue Interface (implemented using linkedList and ArrayDeque)

import java.util.ArrayDeque;
import java.util.Queue;

public class _49_Queue {
    public static void main(String[] args) {
        // Queue<Integer> q=new LinkedList<>(); // NotPrefered -> caching is a overhead
        // in this
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(5);
        q.offer(20);
        q.offer(30);
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        System.out.println(q.poll());
        System.out.println(q.poll());

        // throw exception
        /*
         * element()
         * add()
         * remove()
         */

        // Don't throw exception
        /*
         * peek()
         * offer()
         * poll()
         */
        try {
            System.out.println(q.remove());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}