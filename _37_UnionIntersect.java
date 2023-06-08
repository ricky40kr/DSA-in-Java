// union and intersection of two arrays

import java.util.HashSet;

public class _37_UnionIntersect {
    public static void main(String[] args) {
        int arr1[] = { 1, 9, 6, 7, 8, -4 };
        int arr2[] = { 10, 54, 6, -20, 1 };

        System.out.println("Union : " + union(arr1, arr2));
        System.out.println("Intersection : " + intersect(arr1, arr2));
    }

    private static HashSet<Integer> intersect(int[] arr1, int[] arr2) {
        HashSet<Integer> s = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        for (int i : arr1) {
            s.add(i);
        }
        for (int i : arr2) {
            if (s.contains(i)) {
                res.add(i);
            }
        }

        return res;
    }

    private static HashSet<Integer> union(int[] arr1, int[] arr2) {
        HashSet<Integer> s = new HashSet<>();

        for (int i : arr1) {
            s.add(i);
        }
        for (int i : arr2) {
            s.add(i);
        }

        return s;
    }
}
