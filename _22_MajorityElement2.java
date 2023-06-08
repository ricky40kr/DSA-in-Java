
// Moore's Voting Algorithm
// number occureing more than arrayLength/3 times
// <=2 element is availble like this

import java.util.ArrayList;
import java.util.List;

public class _22_MajorityElement2 {
    public static void main(String[] args) {
        int num[] = { 1, 2, 3, 2, 1 };
        System.out.println("Majority Element : " + majorityElement(num));
    }

    public static List<Integer> majorityElement(int[] nums) {

        int num1 = -1, num2 = -1, count1 = 0, count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> list = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            }
            if (nums[i] == num2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3)
            list.add(num1);
        if (count2 > nums.length / 3)
            list.add(num2);

        return list;
    }
}
