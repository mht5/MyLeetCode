package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/description/
 * @author mhts
 * @date 2018Äê8ÔÂ16ÈÕ
 */
public class ArrayPartition_01 {

	public static void main(String[] args) {
		int[] a = {1,4,3,2};
		System.out.println(arrayPairSum(a));
	}
	
    public static int arrayPairSum(int[] nums) {
    	int count = 0;
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length; i += 2) {
    		count += nums[i];
    	}
    	return count;
    }

}
