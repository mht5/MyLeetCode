package leetcode.string;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 * @time: 4/21/21 6:55 PM
 */
public class DeleteOperationForTwoStrings {

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]: 以i结尾的子串和以j结尾的子串的最大子序列长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果字符不同，两个字符串中其中一个减少一个字符后的最长子序列为当前字符串的最长子序列
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - dp[m][n] * 2;
    }
}
