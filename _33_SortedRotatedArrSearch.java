public class _33_SortedRotatedArrSearch {
    public static void main(String[] args) {
        int arr[] = { 50, 100, 200, 400, 500, 600, 1020, -9, -3, 0, 10, 5, 14, 40 };
        int num = -3;
        int n = search(arr, num, 0, arr.length - 1);
        if (n == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println(num + " is at index -> " + n);
        }
    }

    private static int search(int[] arr, int num, int i, int j) {
        if (i > j)
            return -1;

        int mid = (i + j) / 2;
        if (arr[mid] == num)
            return mid;

        // at least one of two halfs (coz of mid) will be sorted
        if (arr[i] <= arr[mid]) { // means left part is sorted
            if (num >= arr[i] && num <= arr[mid]) {
                return search(arr, num, i, mid - 1);
            }
            return search(arr, num, mid + 1, j);
        } else { // means right part is sorted
            if (num >= arr[mid] && num <= arr[j]) {
                return search(arr, num, mid + 1, j);
            }
            return search(arr, num, i, mid - 1);
        }
    }

}
