// Moore's Voting Algorithm
// number occureing more than arrayLength/2 times
// only one element is availble like this

public class _22_MajorityElement {
    public static void main(String[] args) {
        int num[] = { 1, 2, 3, 1, 1 };
        System.out.println("Majority Element : " + majorityElement(num));
    }

    public static int majorityElement(int[] nums) {
        int ansIdx = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[ansIdx]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                ansIdx = i;
                count = 1;
            }
        }

        // to reconfirm the majorityElement at ansIdx as the majorityElement will be
        // same as at ansInd IF* it exists
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[ansIdx] == nums[i]) {
                count++;
            }
        }

        if (count > nums.length / 2)
            return nums[ansIdx];

        return -1;
    }
}
