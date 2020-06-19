package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ?6?5 n/2 ?6?6 times.
 * https://leetcode.com/problems/majority-element/description/
 * @author mhts
 *
 */
public class MajorityElement {
	public static void main(String[] args){
		int[] nums = new int[101];
		for(int i = 0;i < 49; i++){
			nums[i] = i;
		}
		for(int i = 50; i < 101; i++){
			nums[i] = 53;
		}
		System.out.println(majorityElement(nums));
		System.out.println(majorityElement1(nums));

		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			majorityElement(nums);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			majorityElement1(nums);
		}
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}

	public static int majorityElement1(int[] nums) {
		int count = 0;
		int major = nums[0];
		for (int num : nums) {
			if (num == major) {
				count++;
			} else if (--count == 0) {
				count = 1;
				major = num;
			}
		}
		return major;
	}
	
    public static int majorityElement(int[] nums) {
    	int length=nums.length;
    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int n : nums){
        	if(map.containsKey(n)){
        		map.put(n, map.get(n)+1);
        	}
        	else{
        		map.put(n, 1);
        	}
        }
        for(int n : map.keySet()){
        	if(map.get(n)>length/2){
        		return n;
        	}
        }
    	return -1;
    }
}
