package leetcode.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 * @author mhts
 * @date 2018Äê8ÔÂ1ÈÕ
 */
public class IntersectionOfTwoArrays_02 {
	
	public static void main(String[] args) {
//		int[] a = {-2147483648,-2147483648,1,2,3};
//		int[] b = {1,-2147483648,-2147483648};
		int[] a = {9,1};
		int[] b = {7,8,3,9,0,0,9,1,5};
		int[] r = intersect(a, b);
		for (int i : r) {
			System.out.print(i + ", ");
		}
		System.out.println();
//		int[] x = {1,3,5,5,3,7,8,7,1,9,8,2};
//		int[] y = {2,4,6,8,0,7,1,2,0,9,3,3};
		int[] x = {9,1};
		int[] y = {7,8,3,9,0,0,9,1,5};
		r = intersect1(x, y);
		for (int i : r) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			int[] A = {1,3,5,5,3,7,8,7,1,9,8,2};
			int[] B = {2,4,6,8,0,7,1,2,0,9,3,3};
			intersect(A, B);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			int[] X = {1,3,5,5,3,7,8,7,1,9,8,2};
			int[] Y = {2,4,6,8,0,7,1,2,0,9,3,3};
			intersect1(X, Y);
		}
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}

    public static int[] intersect1(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	int i = 0;
    	int j = 0;
    	int k = 0;
    	int[] array = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
    	while (i < nums1.length && j < nums2.length) {
    		if (nums1[i] == nums2[j]) {
    			array[k++] = nums1[i];
    			i++;
    			j++;
    		} else if (nums1[i] > nums2[j]) {
    			j++;
    		} else {
    			i++;
    		}
    	}
    	return Arrays.copyOf(array, k);
    }
    
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
        	return new int[0];
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums1) {
        	if (i > max) {
        		max = i;
        	}
        	if (i < min) {
        		min = i;
        	}
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
        	map.put(i - min, map.get(i - min) == null ? 1 : map.get(i - min)+1);
        }
        int count = 0;
        for (int i : nums2) {
        	if (i >= min && i <= max && map.get(i - min) != null && map.get(i - min) > 0) {
        		map.put(i - min, map.get(i - min) - 1);
        		nums1[count++] = i;
        	}
        }
    	return Arrays.copyOf(nums1, count);
    }

}
