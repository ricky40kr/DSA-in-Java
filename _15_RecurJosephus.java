// Josephus Problem
// Killing people standing in a circle where gun is passed to the next person after shoot and he will shoot the kth person

public class _15_RecurJosephus {
    public static void main(String[] args) {
        System.out.println(jos(5, 2));
    }

    static int jos(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (jos(n - 1, k) + k) % n;
    }
}
