package leetcode.string;

/**
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * https://leetcode.com/problems/buddy-strings/description/
 * @author mhts
 * @date 2018Äê7ÔÂ30ÈÕ
 */
public class BuddyStrings {

	public static void main(String[] args) {
		String str1 = "ab";
		String str2 = "ab";
		System.out.println(buddyStrings(str1, str2));
		System.out.println(buddyStrings1(str1, str2));
		
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			buddyStrings(str1, str2);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			buddyStrings1(str1, str2);
		}
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}
	
    public static boolean buddyStrings1(String A, String B) {
        if (A.length() != B.length() || A.length() < 2) {
        	return false;
        }
        if (A.equals(B)) {
        	if (hasSameCharacter1(A)) {
        		return true;
        	}
        	return false;
        }
        char[] array = new char[4];
        for (int i = 0; i < A.length(); i++) {
        	if (A.charAt(i) != B.charAt(i)) {
        		if (array[3] != 0) {
        			return false;
        		}
        		if (array[1] == 0) {
        			array[0] = A.charAt(i);
        			array[1] = B.charAt(i);
        		} else {
        			array[2] = A.charAt(i);
        			array[3] = B.charAt(i);
        		}
        	}
        }
        if (array[2] == 0) {
        	return false;
        } else {
        	return array[0] == array[3] && array[1] == array[2];
        }
    }

	private static boolean hasSameCharacter1(String a) {
		if (a.length() > 26) {
			return true;
		}
		char[] array = new char[26];
		int index = 0;
		for (int i = 0; i < a.length(); i++) {
			index = a.charAt(i) - 'a';
			array[index]++;
			if (array[index] == 2) {
				return true;
			}
		}
		return false;
	}
	
    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
        	return false;
        }
        char[] array = new char[4];
        for (int i = 0; i < A.length(); i++) {
        	if (A.charAt(i) != B.charAt(i)) {
        		if (array[3] != 0) {
        			return false;
        		}
        		if (array[1] == 0) {
        			array[0] = A.charAt(i);
        			array[1] = B.charAt(i);
        		} else {
        			array[2] = A.charAt(i);
        			array[3] = B.charAt(i);
        		}
        	}
        }
        if (array[0] == 0) {
        	if (hasSameCharacter(A)) {
        		return true;
        	}
        	return false;
        } else if (array[2] == 0) {
        	return false;
        } else {
        	return array[0] == array[3] && array[1] == array[2];
        }
    }

	private static boolean hasSameCharacter(String a) {
		char[] array = new char[26];
		int index = 0;
		for (int i = 0; i < a.length(); i++) {
			index = a.charAt(i) - 'a';
			array[index]++;
			if (array[index] == 2) {
				return true;
			}
		}
		return false;
	}

}
