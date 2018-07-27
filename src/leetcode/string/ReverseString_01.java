package leetcode.string;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * https://leetcode.com/problems/reverse-string/description/
 * @author mhts
 * @date 2018Äê7ÔÂ26ÈÕ
 */
public class ReverseString_01 {

	public static void main(String[] args) {
		String str = "Hello, World";
		System.out.println(reverseString1(str));
	}

	public static String reverseString1(String s) {
		char[] array = s.toCharArray();
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			char tmp = array[high];
			array[high] = array[low];
			array[low] = tmp;
			low++;
			high--;
		}
		return new String(array);
	}

	public static String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}
