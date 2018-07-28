package leetcode.string;

/**
 * https://leetcode.com/problems/count-and-say/description/
 * @author mhts
 * @date 2018Äê7ÔÂ28ÈÕ
 */
public class CountAndSay {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(countAndSay(n));
	}
	
    public static String countAndSay(int n) {
        if (n == 1) {
        	return "1";
        } else {
        	return count(countAndSay(n - 1));
        }
    }

	private static String count(String str) {
		char[] array = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		int n = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] != array[i - 1]) {
				sb.append(n + "" + array[i - 1]);
				n = 1;
			} else {
				n++;
			}
		}
		sb.append(n + "" + array[array.length-1]);
		return sb.toString();
	}

}
