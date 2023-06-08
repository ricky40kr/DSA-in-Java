public class _34_BookAllocate {
    public static void main(String[] args) {
        int arr[] = { 5, 10, 20 };
        int k = 2;
        System.out.println("Minimum pages allocated to " + k + " students = " + minPages(arr, k));
    }

    private static int minPages(int[] arr, int k) {
        int min = arr[0];
        int max = 0;
        for (int i : arr) {
            if (i > min)
                min = i;
            max += i;
        }
        int res = 0;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (isFeasible(arr, k, mid)) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return res;
    }

    private static boolean isFeasible(int[] arr, int k, int res) {
        int student = 1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((sum + arr[i]) > res) {
                student++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return student <= k;
    }
}
