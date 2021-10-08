package leetcode.string;

/**
 * https://leetcode.com/problems/decode-ways/
 * @time: 4/22/21 7:09 PM
 */
public class DecodeWays {

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.equals("0")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = s.charAt(i - 1) == '0' ? 0 : dp[i - 1];
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
