// Infinite sorted array search

public class _32_InfiniteSearch {
    public static void main(String[] args) {
        int arr[] = { -9, -3, 0, 10, 5, 14, 40, 50, 100, 200, 400, 500, 600, 1020 };
        int num = 14;
        int n = infiniteSearch(arr, num);
        if (n == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println(num + " is at index -> " + n);
        }
    }

    private static int infiniteSearch(int[] arr, int num) {
        int low = 0;
        int high = 1;

        while (arr[high] < num) {
            low = high;
            high <<= 1;
        }

        return binarySearch(arr, num, low, high);
    }

    private static int binarySearch(int[] arr, int num, int i, int j) {
        if (i > j) {
            return -1;
        }
        int mid = (i + j) / 2;
        if (arr[mid] == num)
            return mid;

        if (arr[mid] > num)
            return binarySearch(arr, num, i, mid - 1);

        return binarySearch(arr, num, mid + 1, j);
    }
}
