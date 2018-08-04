package leetcode.binary_search;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/
 * @author mhts
 * @date 2018Äê8ÔÂ4ÈÕ
 */
public class GuessNumberHigherOrLower extends GuessGame {
	
	public GuessNumberHigherOrLower(int num) {
		super(num);
	}

	public static void main(String[] args) {
		GuessNumberHigherOrLower myClass = new GuessNumberHigherOrLower(123);
		int n = 1000;
		System.out.println(myClass.guessNumber(n));
	}
	
    public int guessNumber(int n) {
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

}
