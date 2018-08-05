package leetcode.binary_search;

/**
 * https://leetcode.com/problems/first-bad-version/description/
 * @author mhts
 * @date 2018Äê8ÔÂ5ÈÕ
 */
public class FirstBadVersion {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(firstBadVersion(n));
	}
	
    public static int firstBadVersion(int n) {
        int l = 1;
        int h = n;
        int m;
        
        while (l <= h) {
        	m = l + (h- l) / 2;
        	if (isBadVersion(m)) {
        		if (!isBadVersion(m - 1)) {
        			return m;
        		}
        		h = m - 1;
        	} else {
        		l = m + 1;
        	}
        }
        
    	return -1;
    }
    
    private static boolean isBadVersion (int v) {
    	return v >= 3;
    }

}
