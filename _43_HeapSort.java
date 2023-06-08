import java.util.ArrayList;
import java.util.Collections;

public class _43_HeapSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 1, 20, 3, -4, 2, 0);
        heapSort(arr, arr.size());
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void heapSort(ArrayList<Integer> arr, int n) {
        for (int i = n / 2; i > 0; i--) {
            // swap
            int temp = arr.get(i);
            arr.set(i, arr.get(0));
            arr.set(0, temp);

            heapify(i, arr);
        }
    }

    // heapify
    private static void heapify(int i, ArrayList<Integer> arr) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIdx = i; // minIdx is i coz it is min heap and root is min value

        if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
            minIdx = left;
        }

        if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
            minIdx = right;
        }

        if (minIdx != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(minIdx));
            arr.set(minIdx, temp);

            // recurrsively checking for lower nodes(children)
            heapify(minIdx, arr);
        }

    }
}
