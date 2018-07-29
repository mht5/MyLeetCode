package leetcode.string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * https://leetcode.com/problems/valid-palindrome/description/
 * @author mhts
 * @date 2018Äê7ÔÂ29ÈÕ
 */
public class ValidPalindrome_01 {

	public static void main(String[] args) {
		String str = "1A man, a pLan, a cAnal: Panama2";
		System.out.println(isPalindrome(str));
		System.out.println(isPalindrome1(str));

		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			isPalindrome(str);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			isPalindrome1(str);
		}
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}
	
    public static boolean isPalindrome1(String s) {
    	if ("".equals(s)) {
    		return true;
    	}
    	s = trim1(s);
    	int l = 0;
    	int h = s.length() - 1;
    	while (l < h) {
    		if (s.charAt(l++) != s.charAt(h--)) {
    			return false;
    		}
    	}
    	return true;
    }

	private static String trim1(String s) {
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
				sb.append(ch);
			} else if (ch >= 'A' && ch <= 'Z') {
				sb.append((char) (ch + 32));
			}
				
		}
		return sb.toString();
	}
	
    public static boolean isPalindrome(String s) {
    	if ("".equals(s)) {
    		return true;
    	}
    	s = trim(s);
    	String s1, s2;
        if (s.length() % 2 == 0) {
        	s1 = s.substring(0, s.length() / 2);
        	s2 = s.substring(s.length() / 2);
        } else {
        	s1 = s.substring(0, s.length() / 2);
        	s2 = s.substring(s.length() / 2 + 1);
        }
    	if (s1.equalsIgnoreCase(reverseWord(s2))) {
    		return true;
    	}
    	return false;
    }

	private static String trim(String s) {
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static String reverseWord(String s) {
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

}
