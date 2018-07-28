package leetcode.string;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 * @author mhts
 * @date 2018Äê7ÔÂ28ÈÕ
 */
public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		String str = "aba";
		System.out.println(repeatedSubstringPattern(str));
		System.out.println(repeatedSubstringPattern1(str));
		System.out.println(repeatedSubstringPattern2(str));
		
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			repeatedSubstringPattern(str);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			repeatedSubstringPattern1(str);
		}
		long time3 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			repeatedSubstringPattern2(str);
		}
		long time4 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
		System.out.println(time4 - time3);
	}
	
	public static boolean repeatedSubstringPattern2(String s) {
		if (s == null || s.length() < 2) {
			return false;
		}
		int length = s.length();
		for (int i = length / 2; i > 0; i--) {
			if (length % i == 0 && fit(s, i, s.substring(0, i))) {
				return true;
			}
		}
		return false;
    }

	private static boolean fit(String s, int index, String substring) {
		if (index == s.length()) {
			return true;
		}
		return s.startsWith(substring, index) && fit(s, index + substring.length(), substring);
	}
	

	public static boolean repeatedSubstringPattern1(String s) {
		/**
		 * if S is composed of k substrings s, then S1 = S + S should contain 2k substrings. Destroying the first and the last character leads to at least (2k - 2) substrings left.
		 * since k >= 2, 2k - 2 >= k
		 * which means that S1[1:-1] should still contain S
		 */
    	String str = s + s;
    	return str.substring(1, str.length() - 1).contains(s);
    }
    	
    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length(); i++) {
        	String str = s.substring(0, i);
    		int index = 0;
    		int newIndex;
    		while (index < s.length()) {
    			newIndex = index + i;
        		if (s.indexOf(str, newIndex) != newIndex) {
        			if (newIndex == s.length()) {
        				return true;
        			}
        			break;
        		}
        		index += i;
    		}
        }
        return false;
    }

}
