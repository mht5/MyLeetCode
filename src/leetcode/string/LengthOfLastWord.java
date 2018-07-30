package leetcode.string;

/**
 * https://leetcode.com/problems/length-of-last-word/description/
 * @author mhts
 * @date 2018Äê7ÔÂ30ÈÕ
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		String str = "Hello,World!  ";
		System.out.println(lengthOfLastWord(str));
	}
	
    public static int lengthOfLastWord(String s) {
    	int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
        	if (s.charAt(i) != ' ') {
        		count++;
        	} else if (count != 0) {
    			return count;
        	}
        }
    	return count;
    }

}
