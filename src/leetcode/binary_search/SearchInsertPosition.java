package leetcode.binary_search;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * https://leetcode.com/problems/search-insert-position/description/
 * @author mhts
 * @date 2018Äê8ÔÂ4ÈÕ
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] a = new int[] {1,3,5,7,9};
		int n = 4;
		System.out.println(searchInsert(a, n));
	}
	
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int m;
        while (l <= h) {
        	m = l + (h - l) / 2;
        	System.out.println(l + ", " + h + ", " + m);
        	if (nums[m] == target) {
        		return m;
        	} else if (nums[m] < target) {
        		if (m == nums.length - 1 || nums[m + 1] > target) {
        			return m + 1;
        		}
        		l = m + 1;
        	} else {
        		if (m == 0) {
        			return 0;
        		}
        		h = m - 1;
        	}
        }
    	return 0;
    }

}
