package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * https://leetcode.com/problems/two-sum/description/
 * @author mhts
 * @date 2018Äê6ÔÂ20ÈÕ
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		int[] result = twoSum(nums, 10);
		System.out.println(result[0] + ", " + result[1]);
	}
	
	public static  int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int tmp = target - nums[i];
			if (map.containsKey(tmp)) {
				result[0] = i;
				result[1] = map.get(tmp);
				break;
			}
			map.put(nums[i], i);
		}
		return result;
    }

}
