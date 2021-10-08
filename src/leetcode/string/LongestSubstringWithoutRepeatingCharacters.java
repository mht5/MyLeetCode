package leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @time: 4/28/21 7:13 PM
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int start = 0;
        int end = 0;
        Set<Character> charSet = new HashSet<>();
        while (start < s.length() && end < s.length()) {
            if (charSet.contains(s.charAt(end))) {
                charSet.remove(s.charAt(start));
                start++;
            } else {
                charSet.add(s.charAt(end));
                end++;
                result = Math.max(result, end - start);
            }
        }
        return result;
    }
}
