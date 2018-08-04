package leetcode.binary_search;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * https://leetcode.com/problems/valid-perfect-square/description/
 * @author mhts
 * @date 2018Äê8ÔÂ4ÈÕ
 */
public class ValidPerfectSquare {

	public static void main(String[] args) {
		int n = 2147483647;
		System.out.println(isPerfectSquare(n));
		System.out.println(isPerfectSquare1(n));
		System.out.println(Math.sqrt(n));
	}
	
    public static boolean isPerfectSquare1(int num) {
    	int l = 1;
    	int h = num;
    	long m;
    	while (l <= h) {
    		m = l + (h - l) / 2;
    		if (m * m == num) {
    			return true;
    		} else if (m * m > num) {
    			h = (int) m - 1;
    		} else {
    			l = (int) m + 1;
    		}
    	}
    	return false;
    }
	
    public static boolean isPerfectSquare(int num) {
    	if (num == 1) {
    		return true;
    	}
        for (int i = 1; i <= num / 2; i++) {
        	if (i * i ==num) {
        		return true;
        	}
        }
    	return false;
    }

}
