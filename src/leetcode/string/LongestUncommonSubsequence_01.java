package leetcode.string;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/description/
 * @author mhts
 * @date 2018Äê7ÔÂ27ÈÕ
 */
public class LongestUncommonSubsequence_01 {

	public static void main(String[] args) {
		String str1 = "aaa";
		String str2 = "aaa";
		System.out.println(findLUSlength(str1, str2));
	}
	
	public static int findLUSlength(String a, String b) {
        if (a.equals(b)) {
        	return -1;
        }
        return Math.max(a.length(), b.length());
    }

}
