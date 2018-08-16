package leetcode.array;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * https://leetcode.com/problems/remove-element/description/
 * @author mhts
 *
 */
public class RemoveElement {
	public static void main(String[] args){
		int[] nums=new int[]{1,2,3,3,5,6,87,8,3};
		int num=3;
		System.out.println(removeElement(nums, num));
	}
	
	public static int removeElement(int[] nums, int val) {
		int m=0, n=0, count=0;
		while(m<nums.length){
			if(nums[m]==val){
				count++;
			}
			else{
				nums[n++]=nums[m];
			}
			m++;
		}
		return nums.length-count;
    }
}
