// Find Subarray with the given sum k 

import java.util.HashMap;

public class _38_SubarraySum {
    public static void main(String[] args) {
        int arr[] = { 10, 15, -5, 15, -10, 5 };
        int sum = 5;
        subArraySum(arr, sum);
    }

    private static void subArraySum(int[] arr, int sum) {
        int currSum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> map = new HashMap<>(); // map <sum, index>
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum - sum == 0) {
                start = 0;
                end = i;
                break;
            }

            if (map.containsKey(currSum - sum)) {
                start = map.get(currSum - sum) + 1;
                end = i;
                break;
            }
            map.put(currSum, i);

        }

        if (end == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.print("Sub Array (sum = " + sum + ") : ");
            for (int i = start; i <= end; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
