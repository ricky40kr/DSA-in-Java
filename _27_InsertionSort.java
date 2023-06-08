// 2 part in array -> sorted and unsorted

public class _27_InsertionSort {
    public static void main(String[] args) {
        int arr[] = { -9, 10, -6, 4, 0, -3 };
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    int n = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = n;
                }
            }
        }
    }
}
