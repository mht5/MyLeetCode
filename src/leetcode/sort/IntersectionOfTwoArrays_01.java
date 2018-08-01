package leetcode.sort;

import java.util.Arrays;

/**
 * Given two arrays, write a function to compute their intersection.
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 * @author mhts
 * @date 2018Äê8ÔÂ1ÈÕ
 */
public class IntersectionOfTwoArrays_01 {

	public static void main(String[] args) {
		int[] a = {1,3,5,5,3,7,8,7,1,9,8,2};
		int[] b = {2,4,6,8,0,7,1,2,0,9,3,3};
		int[] r = intersection(a, b);
		for (int i : r) {
			System.out.print(i + ", ");
		}
		System.out.println();
		int[] x = {1,3,5,5,3,7,8,7,1,9,8,2};
		int[] y = {2,4,6,8,0,7,1,2,0,9,3,3};
		r = intersection1(x, y);
		for (int i : r) {
			System.out.print(i + ", ");
		}
		System.out.println();

		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			int[] A = {1,3,5,5,3,7,8,7,1,9,8,2};
			int[] B = {2,4,6,8,0,7,1,2,0,9,3,3};
			intersection(A, B);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			int[] X = {1,3,5,5,3,7,8,7,1,9,8,2};
			int[] Y = {2,4,6,8,0,7,1,2,0,9,3,3};
			intersection1(X, Y);
		}
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}
	
    public static int[] intersection1(int[] nums1, int[] nums2) {
    	if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length ==0) {
    		return new int[0];
    	}
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	for (int i : nums1) {
    		if (i > max) {
    			max = i;
    		}
    		if (i < min) {
    			min = i;
    		}
    	}
    	boolean[] array = new boolean[max - min + 1];
    	for (int i : nums1) {
    		array[i - min] = true;
    	}
    	int count = 0;
    	for (int i : nums2) {
    		if (i >= min && i <= max && array[i - min]) {
    			array[i - min] = false;
    			nums1[count++] = i;
    		}
    	}
    	return Arrays.copyOf(nums1, count);
    }
	
    public static int[] intersection(int[] nums1, int[] nums2) {
        int index = 0;
        quickSort(nums1, 0, nums1.length - 1);
        for (int i = 0; i < nums1.length; i++) {
        	if ( i == 0 || (i > 0 && nums1[i] != nums1[i - 1])) {
            	for (int j = 0; j < nums2.length; j++) {
            		if (nums2[j] == nums1[i]) {
            			nums1[index++] = nums2[j];
            			break;
            		}
            	}
        	}
        }
        return Arrays.copyOf(nums1, index);
    }

	private static void quickSort(int[] a, int l, int h) {
		if (l >= h) {
			return;
		}
		int r = (int) (Math.random() * (h- l) + l);
		int t= a[r];
		a[r] = a[l];
		a[l] = t;
		int i = l;
		int j = h + 1;
		while (true) {
			do {
				i++;
			} while (i <= h && a[i] < t);
			do {
				j--;
			} while (a[j] > t);
			if (i > j) {
				break;
			}
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
		t = a[l];
		a[l] = a[j];
		a[j] = t;
		quickSort(a, l, j - 1);
		quickSort(a, j + 1, h);
	}

}
