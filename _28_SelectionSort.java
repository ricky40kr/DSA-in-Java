public class _28_SelectionSort {
    public static void main(String[] args) {
        int arr[] = { -9, 10, -6, 4, 0, -3 };
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIdx = arr[minIdx] > arr[j] ? j : minIdx;
            }
            // swap
            if (minIdx != i) {
                int n = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = n;
            }
        }
    }
}
