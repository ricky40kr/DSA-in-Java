// distinct elements count

import java.util.HashSet;

public class _36_CountDistinct {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 1, -5, 1, 0 };
        System.out.println(countDistinct(arr));
    }

    private static int countDistinct(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        return set.size();
    }
}
