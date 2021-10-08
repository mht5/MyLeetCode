package leetcode.string;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 * @time: 4/21/21 7:47 PM
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "leetcode";
        String text2 = "etco";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // dp[i][j]: 以i结尾的子串和以j结尾的子串的最大子序列长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果字符不同，两个字符串中其中一个减少一个字符后的最长子序列为当前字符串的最长子序列
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
