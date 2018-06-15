package leetcode;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * @author mhts
 *
 */
public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args){
		int[] nums=new int[]{1,2,2,3,4,5,5,6,7,7,8,9};
		System.out.println(removeDuplicates(nums));
	}
	
	public static int removeDuplicates(int[] nums) {
        int count=0;
        for(int i=0; i<nums.length; i++){
        	if(i==0 || nums[i]!=nums[count-1]){
        		nums[count++]=nums[i];
        	}
        }
        return count;
    }
}
