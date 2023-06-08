// Kadane''s Alogorithm
public class _23_MaxSubarray {
    public static void main(String[] args) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Largest Sum of Contiguous Subarray : " + maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (maxSum < curSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }

        return maxSum;
    }

}
