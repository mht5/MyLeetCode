package leetcode.binary_search;

/**
 * https://leetcode.com/problems/arranging-coins/description/
 * @author mhts
 * @date 2018Äê8ÔÂ4ÈÕ
 */
public class ArrangingCoins {

	public static void main(String[] args) {
		int n = 1681692777;
		System.out.println(arrangeCoins(n));
		System.out.println(arrangeCoins1(n));
		System.out.println(arrangeCoins2(n));
		System.out.println(arrangeCoins3(n));

		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			arrangeCoins(n);
		}
		long time2 = System.currentTimeMillis();
//		for (int i = 0; i < 100000; i++) {
//			arrangeCoins1(n);
//		}
		long time3 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			arrangeCoins2(n);
		}
		long time4 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			arrangeCoins3(n);
		}
		long time5 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
		System.out.println(time4 - time3);
		System.out.println(time5 - time4);
	}
	
    public static int arrangeCoins3(int n) {
    	return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }
	
    public static int arrangeCoins2(int n) {
    	/**
    	 * [1,....,k], (k * (k + 1) / 2) <= n < ((k + 1) * (k + 2) / 2)
    	 */
    	int max =  (int) Math.sqrt(new Integer(n).longValue() * 2);
    	if (2 * n >= (max + 1) * max) {
    		return max;
    	} else {
    		return max - 1;
    	}
    }
    	
    public static int arrangeCoins1(int n) {
        for (int i = 1; ; i++) {
        	n -= i;
        	if (n < 0) {
        		return i - 1;
        	}
        }
    }
	
    public static int arrangeCoins(int n) {
    	long l = 1;
    	long h = n;
    	long m;
    	long c;
    	while (l <= h) {
    		m = l + (h - l) / 2;
    		c = m * (m + 1) / 2;
    		if (c == n) {
    			return (int) m;
    		} else if (c > n) {
    			h = m - 1;
    		} else {
    			l = m + 1;
    		}
    	}
    	return (int) (l - 1);
    }

}
