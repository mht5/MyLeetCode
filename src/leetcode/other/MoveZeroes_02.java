package leetcode.other;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * much more efficient
 * https://leetcode.com/problems/move-zeroes/description/
 * @author mhts
 *
 */
public class MoveZeroes_02 {
	public static void main(String[] args){
		long start=System.currentTimeMillis();
		int[] nums=new int[]{0,0,0,1,0,3,12,11,3,2,3,4,1,0,0,0,4,3,2,4,};
		moveZeroes(nums);
        for(int i=0; i<nums.length; i++){
        	System.out.print(nums[i]+", ");
        }
        System.out.println("\n"+(System.currentTimeMillis()-start)+"ms");
	}
	
	public static void moveZeroes(int[] nums) {
        int index=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[index]=nums[i];
                index++;
            }
        }
        for(; index<nums.length; index++){
            nums[index]=0;
        }
    }
}
