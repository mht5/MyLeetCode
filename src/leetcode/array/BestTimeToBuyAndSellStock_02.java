package leetcode.array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @time: 4/25/21 8:47 PM
 */
public class BestTimeToBuyAndSellStock_02 {

    public static void main(String[] args) {
        int[] prices = { 1,2,3,4,5 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int[] dp = new int[length];
        int minPrice = prices[0];
        for (int i = 1; i < length; i++) {
            dp[i] = dp[i - 1];
            if (i < length - 1) {
                if (prices[i] > minPrice && prices[i + 1] < prices[i]) {
                    dp[i] += prices[i] - minPrice;
                    minPrice = prices[i + 1];
                } else if (prices[i] < minPrice) {
                    minPrice = prices[i];
                }
            } else {
                if (prices[i] > minPrice) {
                    dp[i] += prices[i] - minPrice;
                }
            }
        }
        return dp[length - 1];
    }
}
