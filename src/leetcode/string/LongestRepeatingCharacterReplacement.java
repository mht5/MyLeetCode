package leetcode.string;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * @time: 4/19/21 6:50 PM
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }

    public static int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        int[] nums = new int[26];
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int charMax = 0;
        for (right = 0; right < s.length(); right++) {
            int index = chars[right] - 'A';
            nums[index]++;
            charMax = Math.max(charMax, nums[index]);
            if ((right - left + 1) > charMax + k) {
                nums[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}
