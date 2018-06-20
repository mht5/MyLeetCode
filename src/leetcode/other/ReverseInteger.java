package leetcode.other;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * https://leetcode.com/problems/reverse-integer/description/
 * @author mhts
 * @date 2018Äê6ÔÂ20ÈÕ
 */
public class ReverseInteger {

	public static void main(String[] args) {
		int result = reverse(120300);
		System.out.println(result);
	}

	private static int reverse(int i) {
		int result = 0;
		while (i != 0) {
			int n = i % 10;
			i /= 10;
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && n > 7)) {
				return 0;
			} else if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE && n < -8)) {
				return 0;
			}
			result = result * 10 + n;
		}
		return result;
	}

}
