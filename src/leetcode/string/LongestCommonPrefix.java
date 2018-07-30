package leetcode.string;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 * @author mhts
 * @date 2018Äê7ÔÂ30ÈÕ
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {};
//		String[] strs = {"flower","flow","flight"};
//		String[] strs = {"racecar","dog32","car1","asd"};
		System.out.println(longestCommonPrefix(strs));
	}
	
    public static String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length < 1) {
    		return "";
    	}
        String prefix = "";
        int index = 0;
        for (int i = 1; i < strs.length; i++) {
        	if (strs[i].length() < strs[i - 1].length()) {
        		index = i;
        	}
        }
        for (int i = strs[index].length(); i > 0; i--) {
        	boolean match = true;
        	prefix = strs[index].substring(0, i);
        	for (int j = 0; j < strs.length; j++) {
        		if (strs[j].indexOf(prefix) != 0) {
        			match = false;
        			break;
        		}
        	}
        	if (match) {
        		return prefix;
        	}
        }
    	return "";
    }

}
