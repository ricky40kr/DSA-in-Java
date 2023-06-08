public class _26_BubbleSort {
    public static void main(String[] args) {
        int arr[] = { -9, 10, -6, 4, 0, -3 };
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void sort(int arr[]) {
        Boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }

    }
}
