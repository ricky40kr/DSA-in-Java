/*
-> The number of global inversions is the number of the different pairs (i, j) where:
   * 0 <= i < j < n
   * nums[i] > nums[j]

-> The number of local inversions is the number of indices i where:
   * 0 <= i < n - 1
   * nums[i] > nums[i + 1]
    
    Return true if the number of global inversions is equal to the number of local inversions.
 */

public class _18_2_GlobalInversion {
    public static void main(String[] args) {
        int nums[] = { 5, 4, 0, 3, 1 };
        int temp[] = new int[nums.length];
        System.out.println("Number of Global Inversions : " + countInversion(nums, temp, 0, nums.length - 1));

    }

    static int countInversion(int arr[], int temp[], int l, int h) {
        int inv_count = 0;
        if (l < h) {
            int mid = (l + h) / 2;
            inv_count += countInversion(arr, temp, l, mid);
            inv_count += countInversion(arr, temp, mid + 1, h);
            inv_count += merge(arr, temp, l, mid + 1, h);

        }
        return inv_count;
    }

    static int merge(int arr[], int temp[], int l, int mid, int h) {
        int inv_count = 0;
        int i = l;
        int j = mid;
        int k = l;

        while ((i <= mid - 1) && (j <= h)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inv_count += (mid - i);
            }
        }

        while (i <= mid - 1)
            temp[k++] = arr[i++];

        while (j <= h)
            temp[k++] = arr[j++];

        for (i = l; i <= h; i++)
            arr[i] = temp[i];

        return inv_count;
    }
}
