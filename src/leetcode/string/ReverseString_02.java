package leetcode.string;

/**
 * https://leetcode.com/problems/reverse-string-ii/description/
 * @author mhts
 * @date 2018Äê7ÔÂ27ÈÕ
 */
public class ReverseString_02 {

	public static void main(String[] args) {
		String str = "abcdefghijklmno";
		int k = 2;
		System.out.println(reverseStr(str, k));
	}
	
    public static String reverseStr(String s, int k) {
    	StringBuilder sb = new StringBuilder();
    	boolean endOfLine = false;
    	int length = s.length();
    	int k2 = k * 2;
    	int n = length % k2 == 0 ? length / k2 : length / k2 + 1;
        for (int i = 0; i < n; i++) {
        	if (k2 * i + k > s.length() - 1) {
            	sb.append(reverseWord(s.substring(k2 * i)));
            	endOfLine = true;
        	} else {
            	sb.append(reverseWord(s.substring(k2 * i, k2 * i + k)));
        	}
        	if (!endOfLine) {
            	if (k2 * (i + 1) > s.length() - 1) {
                	sb.append(s.substring(k2 * i + k));
            	} else {
                	sb.append(s.substring(k2 * i + k, k2 * (i + 1)));
            	}
        	}
        }
    	return sb.toString();
    }

	private static char[] reverseWord(String str) {
		char[] array = str.toCharArray();
		int h = array.length - 1;
		int l = 0;
		while (h > l) {
			char tmp = array[h];
			array[h] = array[l];
			array[l] = tmp;
			h--;
			l++;
		}
		return array;
	}

}
