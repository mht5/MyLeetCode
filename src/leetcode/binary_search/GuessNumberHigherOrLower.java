package leetcode.binary_search;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/
 * @author mhts
 * @date 2018Äê8ÔÂ4ÈÕ
 */
public class GuessNumberHigherOrLower {

	public static void main(String[] args) {
		int n = 1000;
		System.out.println(guessNumber(n));
	}
	
    public static int guessNumber(int n) {
    	int l = 1;
    	int h = n;
    	int m;
    	while (l <= h) {
    		m = l + (h - l) / 2;
            if (guess(m) == 0) {
            	return m;
            } else if (guess(m) == 1) {
            	l = m + 1;
            } else {
            	h = m - 1;
            }
    	}
    	return 0;
    }
	
	private static int guess(int num) {
		if (256 == num) {
			return 0;
		} else if (256 > num) {
			return 1;
		} else {
			return -1;
		}
	}

}
