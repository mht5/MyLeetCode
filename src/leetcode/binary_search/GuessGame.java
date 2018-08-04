package leetcode.binary_search;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/
 * @author mhts
 * @date 2018Äê8ÔÂ4ÈÕ
 */
public class GuessGame {
	int num;
	
	public GuessGame(int num) {
		this.num = num;
	}
	
	public int guess(int num) {
		if (this.num == num) {
			return 0;
		} else if (this.num > num) {
			return 1;
		} else {
			return -1;
		}
	}
}
