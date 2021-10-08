package leetcode.string;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @time: 4/25/21 9:01 PM
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome1(s));
    }

    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getMaxLength(s, i, i);
            int len2 = getMaxLength(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int getMaxLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int length = s.length();
        int[][] dp = new int[length + 1][length + 1];
        int from = 0;
        int to = 0;
        for (int i = 1; i < length; i++) {
            int maxLength = dp[i - 1][length];
            if (i + maxLength > length) {
                dp[i][length] = maxLength;
            }
            for (int j = i + maxLength; j <= length; j++) {
                if (isPalindrome(s, i - 1, j - 1)) {
                    dp[i][j] = j - i;
                    from = i - 1;
                    to = j - 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][length]);
                }
            }
        }
        return s.substring(from, to + 1);
    }

    public static boolean isPalindrome(String s, int from, int to) {
        while (from < to) {
            if (s.charAt(from) != s.charAt(to)) {
                return false;
            }
            from++;
            to--;
        }
        return true;
    }
}
