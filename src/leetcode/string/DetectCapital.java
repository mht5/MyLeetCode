package leetcode.string;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * https://leetcode.com/problems/detect-capital/description/
 * @author mhts
 * @date 2018Äê7ÔÂ27ÈÕ
 */
public class DetectCapital {

	public static void main(String[] args) {
		String str = "fLAG";
		System.out.println(detectCapitalUse(str));
	}
	
	public static boolean detectCapitalUse(String word) {
        char[] array = word.toCharArray();
        int firstElement = array[0];
		boolean isFirstCapital = firstElement >= 'A' && firstElement <= 'Z';
		boolean hasUpperCase = false;
		boolean hasLowerCase = false;
        for (int i = 1; i < array.length; i++) {
        	if (isFirstCapital) {
        		if (array[i] >= 'A' && array[i] <= 'Z') {
        			hasUpperCase = true;
        		} else if (array[i] >= 'a' && array[i] <= 'z') {
        			hasLowerCase = true;
        		}
        		if (hasUpperCase && hasLowerCase) {
        			return false;
        		}
        	} else {
        		if (array[i] >= 'A' && array[i] <= 'Z') {
        			return false;
        		}
        	}
        }
		return true;
    }

}
