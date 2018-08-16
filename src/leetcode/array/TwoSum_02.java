package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * @author mhts
 * @date 2018Äê8ÔÂ2ÈÕ
 */
public class TwoSum_02 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		int[] result = twoSum(nums, 17);
		System.out.println(result[0] + ", " + result[1]);
		result = twoSum1(nums, 17);
		System.out.println(result[0] + ", " + result[1]);
	}
	
    public static int[] twoSum1(int[] numbers, int target) {
    	int l = 0;
    	int h = numbers.length - 1;
    	while (l < h) {
    		int sum = numbers[l] + numbers[h];
    		if (sum == target) {
    			return new int[] {l + 1, h + 1};
    		} else if (sum < target) {
    			l++;
    		} else {
    			h--;
    		}
    	}
    	return new int[] {0, 0};
    }
	
    public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			int tmp = target - numbers[i];
			if (map.containsKey(tmp)) {
				if (i < map.get(tmp)) {
					result[0] = i + 1;
					result[1] = map.get(tmp);
				} else {
					result[0] = map.get(tmp);
					result[1] = i + 1;
				}
				break;
			}
			map.put(numbers[i], i + 1);
		}
		return result;
    }

}
