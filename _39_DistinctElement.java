// Count Distinct Elements in every Window of size k

import java.util.HashMap;
import java.util.Map;

public class _39_DistinctElement {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 1, 3, 1, 1, 3 };
        int k = 4;

        countDistinctElements(arr, k);
    }

    private static void countDistinctElements(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(map.size() + " ");

        for (int i = k; i < arr.length; i++) {
            // to remove one element from start
            if (map.get(arr[i - k]) == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
            }

            // to add element at i index in arr[]
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            System.out.print(map.size() + " ");
        }

    }
}
