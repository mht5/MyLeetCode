package leetcode.string;

/**
 * https://leetcode.com/problems/rotated-digits/description/
 * @author mhts
 * @date 2018Äê7ÔÂ27ÈÕ
 */
public class RotatedDigits {

	public static void main(String[] args) {
		int num = 10;
		System.out.println(rotatedDigits(num));
	}
	
	public static int rotatedDigits(int N) {
		int count = 0;
        for (int i = 1; i <= N; i++) {
        	if (isValid(i)) {
        		count ++;
        	}
        }
        return count;
    }

	private static boolean isValid(int num) {
		int count = 0;
		while (num > 0) {
			int n = num % 10;
			if (n == 2 || n == 5 || n ==6 || n == 9) {
				count ++;
			} else if (n == 3 || n == 4 || n == 7) {
				return false;
			}
			num /= 10;
		}
		return count > 0;
	}

}
