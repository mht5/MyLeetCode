package leetcode.other;

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
		int[] nums=new int[101];
		for(int i=0;i<49; i++){
			nums[i]=i;
		}
		for(int i=50; i<101; i++){
			nums[i]=53;
		}
		System.out.println(majorityElement(nums));
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
