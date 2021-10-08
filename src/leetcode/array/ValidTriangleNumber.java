package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-triangle-number/
 * @time: 4/15/21 8:40 PM
 */
public class ValidTriangleNumber {

    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        int count = 0;
        if (nums.length < 3) {
            return count;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}
