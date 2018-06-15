package leetcode;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * @author mhts
 *
 */
public class MoveZeroes_01 {
	public static void main(String[] args){
		int[] nums=new int[]{0,0,0,1,0,3,12,11,3,2,3,4,1,0,0,0,4,3,2,4,};
		moveZeroes(nums);
	}
	
	public static void moveZeroes(int[] nums) {
		long start=System.currentTimeMillis();
		doMove(nums);
		doMove(nums);
        for(int i=0; i<nums.length; i++){
        	System.out.print(nums[i]+", ");
        }
        System.out.println("\n"+(System.currentTimeMillis()-start)+"ms");
    }
	
    public static void doMove(int[] nums) {
        for(int i=0; i<nums.length; i++){
        	if(nums[i]==0){
        		for(int j=i; j<nums.length-1; j++){
        			nums[j]=nums[j+1];
        			nums[j+1]=0;
        		}
        	}
        }
	}
}
