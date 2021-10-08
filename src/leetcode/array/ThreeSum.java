package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * @time: 4/14/21 7:57 PM
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> list : result) {
            for (Integer val : list) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> innerList;
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int num = nums[i] + nums[left] + nums[right];
                if (num == 0) {
                    innerList = new ArrayList<>();
                    innerList.add(nums[i]);
                    innerList.add(nums[left]);
                    innerList.add(nums[right]);
                    result.add(innerList);
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                }
                if (num > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }

}
