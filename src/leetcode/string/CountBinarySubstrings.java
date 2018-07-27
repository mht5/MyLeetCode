package leetcode.string;

/**
 * https://leetcode.com/problems/count-binary-substrings/description/
 * @author mhts
 * @date 2018Äê7ÔÂ27ÈÕ
 */
public class CountBinarySubstrings {

	public static void main(String[] args) {
		String str = "0101010011";
		System.out.println(countBinarySubstrings(str));
	}

	public static int countBinarySubstrings(String s) {
		int count = 0;
		int prev = 0;
		int current = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) != s.charAt(i)) {
				count += Math.min(prev, current);
				prev = current;
				current = 1;
			} else {
				current++;
			}
		}
		return count + Math.min(prev, current);
    }
	
}
