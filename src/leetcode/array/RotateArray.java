package leetcode.array;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 8;
        rotate(nums, k);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }
}
