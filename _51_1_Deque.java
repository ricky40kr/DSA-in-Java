import java.util.ArrayDeque;
import java.util.Deque;

public class _51_1_Deque {
    public static void main(String[] args) {
        Deque<Integer> q = new ArrayDeque<>();

        q.addFirst(1);
        q.addLast(100);
        int first = q.removeFirst();
        int second = q.removeLast();
        System.out.println(first + " " + second);
        q.add(50);
        q.add(100);
        q.add(20);
        q.add(60);

        System.out.println(q);

    }
}
