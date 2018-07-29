package leetcode.string;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 * @author mhts
 * @date 2018��7��29��
 */
public class ValidPalindrome_02 {

	public static void main(String[] args) {
		String str = "abca";
		System.out.println(validPalindrome(str));
		System.out.println(validPalindrome1(str));
		System.out.println(validPalindrome2(str));

		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			validPalindrome(str);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			validPalindrome1(str);
		}
		long time3 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			validPalindrome2(str);
		}
		long time4 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
		System.out.println(time4 - time3);
	}

    public static boolean validPalindrome2(String s) {
    	int j;
    	for (int i = 0; i < s.length() / 2; i++) {
    		j = s.length() - 1 - i;
    		if (s.charAt(i) != s.charAt(j)) {
//    			�����ƥ�䣬Ҫô�ǵ�i�������⣬Ҫô�ǵ�j�������⣬������һ��
    			return isPalindrome2(s, i + 1, j) || isPalindrome2(s, i, j - 1);
    		}
    	}
    	return true;
    }
	
    public static boolean isPalindrome2(String s, int i, int j) {
    	for (int k = i; k <= (i + (j - i) / 2); k++) {
    		if (s.charAt(k) != s.charAt(i + j - k)) {
    			return false;
    		}
    	}
    	return true;
    }

    public static boolean validPalindrome1(String s) {
    	if (isPalindrome1(s)) {
    		return true;
    	}
    	for (int i = 0; i < s.length(); i++) {
        	if (isPalindrome1(s.substring(0, i) + s.substring(i + 1))) {
        		return true;
        	}
    	}
    	
    	return false;
    }
	
    public static boolean isPalindrome1(String s) {
    	int l = 0;
    	int h = s.length() - 1;
    	while (l < h) {
    		if (s.charAt(l++) != s.charAt(h--)) {
    			return false;
    		}
    	}
    	return true;
    }

    public static boolean validPalindrome(String s) {
    	if (isPalindrome(s)) {
    		return true;
    	}
    	for (int i = 0; i < s.length(); i++) {
        	if (isPalindrome(s.substring(0, i) + s.substring(i + 1))) {
        		return true;
        	}
    	}
    	
    	return false;
    }
    
	public static boolean isPalindrome(String s) {
    	String s1, s2;
        if (s.length() % 2 == 0) {
        	s1 = s.substring(0, s.length() / 2);
        	s2 = s.substring(s.length() / 2);
        } else {
        	s1 = s.substring(0, s.length() / 2);
        	s2 = s.substring(s.length() / 2 + 1);
        }
    	if (s1.equals(reverseWord(s2))) {
    		return true;
    	}
    	return false;
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
