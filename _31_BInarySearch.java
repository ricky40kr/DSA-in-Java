public class _31_BInarySearch {
    public static void main(String[] args) {
        int arr[] = { -9, -3, 0, 10, 5, 14 };
        int num = 14;
        int n = binarySearch(arr, num, 0, arr.length - 1);
        if (n == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println(num + " is at index -> " + n);
        }
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
