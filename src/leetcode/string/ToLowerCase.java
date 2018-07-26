package leetcode.string;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * https://leetcode.com/problems/to-lower-case/description/
 * @author mhts
 * @date 2018Äê7ÔÂ26ÈÕ
 */
public class ToLowerCase {

	public static void main(String[] args) {
		String str = "!!!Hello, World...";
		System.out.println(str.toLowerCase());
		System.out.println(toLowerCase(str));
	}
	
	private static String toLowerCase(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				result += (char) (ch + 32);
			} else {
				result += ch;
			}
		}
		return result;
	}

}
