package leetcode.binary_search;

/**
 * https://leetcode.com/problems/binary-search/description/
 * @author mhts
 * @date 2018Äê8ÔÂ5ÈÕ
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = new int[] {1,3,5,7,9};
		int t = 6;
		System.out.println(search(nums, t));
	}
	
    public static int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int m;
        while (l <= h) {
        	m = l + (h - l) / 2;
        	if (nums[m] == target) {
        		return m;
        	} else if (nums[m] > target) {
        		h = m - 1;
        	} else {
        		l = m + 1;
        	}
        }
    	return -1;
    }

}
