// HashSet is unordered collection
// Insert, Search, Delete -> O(1)

import java.util.HashSet;

public class _35_HashSet {
    public static void main(String[] args) {
        HashSet<Integer> s = new HashSet<>();
        s.add(10);
        s.add(5);
        System.out.println(s);

        if (s.contains(10)) {
            System.out.println("Present!");
        } else {
            System.out.println("Not Found!");
        }

        s.remove(10);
        System.out.println(s.isEmpty());
        System.out.println(s.size());
        s.clear();
        System.out.println(s.isEmpty());
        System.out.println(s.size());
    }
}
