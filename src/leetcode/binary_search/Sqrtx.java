package leetcode.binary_search;

/**
 * https://leetcode.com/problems/sqrtx/description/
 * @author mhts
 * @date 2018Äê8ÔÂ5ÈÕ
 */
public class Sqrtx {

	public static void main(String[] args) {
		int n = 2147395599;
		System.out.println(mySqrt(n));
	}
	
    public static int mySqrt(int x) {
        if (x <= 1) {
        	return x;
        }
        if (x == 4) {
        	return 2;
        }
        
        long l = 1;
        long h = x / 2;
        long m;
        long c;
        
        while (l <= h) {
        	m = l + (h - l) / 2;
        	c = m * m;
        	System.out.println(l + ", " + h + ", " + m + ", " + c);
        	if (c == x) {
        		return (int) m;
        	} else if (c > x) {
        		h = m - 1;
        	} else {
        		l = m + 1;
        	}
        }
        
    	return (int) (l - 1);
    }

}
