import java.util.Comparator;
import java.util.PriorityQueue;

public class _41_1_PriorityQueue {

    // Implementing Comaparable interface to student class can help the class to
    // compare its object on basis of class member by overriding compareTo method
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        // By Default in Ascending Order
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // for Descending Order
        /*
         * PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
         * 
         * pq.add(3); // O(log n)
         * pq.add(4);
         * pq.add(1);
         * pq.add(7);
         * 
         * while (!pq.isEmpty()) {
         * System.out.print(pq.peek() + " "); // O(1)
         * pq.remove(); // O(log n)
         * }
         */

        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder()); // Descending Order
        pq.add(new Student("Rahul", 10));
        pq.add(new Student("Prince", 12));
        pq.add(new Student("Megha", 5));
        pq.add(new Student("Amit", 1));
        pq.add(new Student("Zach", 4));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.remove();
        }
    }
}
