package leetcode.binary_search;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 * @author mhts
 * @date 2018Äê8ÔÂ2ÈÕ
 */
public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
//		char[] a = new char[] {'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
		char[] a = new char[] {'c', 'f', 'j'};
		char t = 'j';
		System.out.println(nextGreatestLetter(a, t));
		System.out.println(nextGreatestLetter1(a, t));

		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			nextGreatestLetter(a, t);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			nextGreatestLetter1(a, t);
		}
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}
	
    public static char nextGreatestLetter1(char[] letters, char target) {
    	int l = 0;
    	int h = letters.length - 1;
    	int m;
    	while (l <= h) {
    		m = l + (h - l) / 2;
    		if (letters[m] > target) {
    			if (m - 1 < l || letters[m - 1] <= target) {
    				return letters[m];
    			}
    			h = m;
    		} else {
    			l = m + 1;
    		}
    	}
		return letters[0];
    }
	
    public static char nextGreatestLetter(char[] letters, char target) {
    	int l = 0;
    	int h = letters.length - 1;
    	int m;
    	while (l <= h) {
    		m = l + (h - l) / 2;
    		if (letters[m] > target) {
    			if (m == 0 || letters[m - 1] < target) {
    				return letters[m];
    			}
    			h = m - 1;
    		} else if (letters[m] < target) {
    			if (m == letters.length - 1) {
    				return letters[0];
    			}
    			if (letters[m + 1] > target) {
    				return letters[m + 1];
    			}
    			l = m + 1;
    		} else {
    			if (m == letters.length - 1) {
    				return letters[0];
    			}
    			if (letters[m + 1] > target) {
    				return letters[m + 1];
    			}
    			l = m + 1;
    		}
    	}
		return 0;
    }

}
