public class _30_QuickSort {
    public static void main(String[] args) {
        int arr[] = { -9, 10, -6, 4, 0, -3 };
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr, int l, int h) {
        if (l < h) {
            int pivot = partition(arr, l, h);
            sort(arr, l, pivot - 1);
            sort(arr, pivot + 1, h);
        }
    }

    public static int partition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l;
        int j = h;

        while (i < j) {
            while (arr[i] <= pivot && i <= h - 1)
                i++;

            while (arr[j] > pivot && j >= l + 1)
                j--;

            if (i < j)
                swap(arr, i, j);

        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
