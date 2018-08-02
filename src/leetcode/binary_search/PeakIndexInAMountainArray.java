package leetcode.binary_search;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 * @author mhts
 * @date 2018Äê8ÔÂ2ÈÕ
 */
public class PeakIndexInAMountainArray {

	public static void main(String[] args) {
		int[] a = new int[] {1,3,5,8,5,3,1};
//		int[] a = new int[] {0,1,2,8,5,3,1};
		System.out.println(peakIndexInMountainArray(a));
		System.out.println(peakIndexInMountainArray1(a));

		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			peakIndexInMountainArray(a);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			peakIndexInMountainArray1(a);
		}
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}
	
    public static int peakIndexInMountainArray1(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
        	if (A[i] < A[j]) {
        		i++;
        	} else if (A[i] > A[j]) {
        		j--;
        	} else {
        		i++;
        		j--;
        	}
        }
        return i;
    }
	
    public static int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length; i++) {
        	if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
        		return i;
        	}
        }
        return 0;
    }

}
