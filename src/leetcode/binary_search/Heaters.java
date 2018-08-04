package leetcode.binary_search;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/heaters/description/
 * @author mhts
 * @date 2018Äê8ÔÂ4ÈÕ
 */
public class Heaters {

	public static void main(String[] args) {
		int[] a = new int[] {1, 3, 6, 7, 8};
		int[] b= new int[] {3, 9};
		System.out.println(findRadius(a, b));
	}
	
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int r = Integer.MIN_VALUE;
        
        for (int house : houses) {
        	int index = Arrays.binarySearch(heaters, house);
        	if (index < 0) {
        		index = 0 - (index + 1);
        	}
        	int m = index >= 1 ? house - heaters[index - 1] : Integer.MAX_VALUE;
        	int n = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
        	r = Math.max(r, Math.min(m, n));
        }
        
    	return r;
    }

}
