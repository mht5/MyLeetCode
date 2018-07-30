package leetcode.string;

/**
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * https://leetcode.com/problems/implement-strstr/description/
 * @author mhts
 * @date 2018Äê7ÔÂ30ÈÕ
 */
public class ImplementStrStr {
	
	public static void main(String[] args) {
		String str1 = "mississippi";
		String str2 = "pi";
		System.out.println(strStr(str1, str2));
		System.out.println(strStr1(str1, str2));
		System.out.println(str1.indexOf(str2));
		
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			strStr(str1, str2);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			strStr1(str1, str2);
		}
		long time3 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			str1.indexOf(str2);
		}
		long time4 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
		System.out.println(time4 - time3);
	}
	
    public static int strStr1(String haystack, String needle) {
    	int start = 0;
    	int end=  needle.length();
        if (haystack == null || haystack.length() < end) {
        	return -1;
        }
        if (needle.isEmpty() || haystack.equals(needle)) {
        	return 0;
        }
    	while (end <= haystack.length()) {
    		if (haystack.substring(start, end).equals(needle)) {
    			return start;
    		}
    		start++;
    		end++;
    	}
    	return -1;
    }
    	
	public static int strStr(String haystack, String needle) {
		int needleLength = needle.length();
        if (haystack == null || haystack.length() < needleLength) {
        	return -1;
        }
        if (needle.isEmpty() || haystack.equals(needle)) {
        	return 0;
        }
        for (int i = 0; i <= haystack.length() - needleLength; i++) {
        	if (haystack.substring(i, i + needleLength).equals(needle)) {
        		return i;
        	}
        }
        return -1;
    }

}
