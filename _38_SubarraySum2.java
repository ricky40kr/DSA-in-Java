// find largest subarray with equal number of 1 and 0

import java.util.HashMap;

public class _38_SubarraySum2 {
    public static void main(String[] args) {
        int nums[] = { 0, 1, 0 };
        System.out.println(subArray(nums));
    }

    private static int subArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            // count = count + (nums[i] == 1 ? 1 : -1);
            count += (nums[i] << 1) - 1;
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}
