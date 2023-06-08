public class _29_MergeSort {
    public static void main(String[] args) {
        int arr[] = { -9, 10, -6, 4, 0, -3 };
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int arr2[] = new int[r + 1];
        int i = l;
        int j = mid + 1;
        int k = l;

        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                arr2[k++] = arr[i++];
            } else {
                arr2[k++] = arr[j++];
            }

        }

        while (i <= mid) {
            arr2[k++] = arr[i++];
        }

        while (j <= r) {
            arr2[k++] = arr[j++];
        }

        for (int z = l; z <= r; z++) {
            arr[z] = arr2[z];
        }

    }
}
