package leetcode.array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * @time: 4/25/21 8:18 PM
 */
public class BestTimeToBuyAndSellStock_01 {

    public static void main(String[] args) {
        int[] prices = { 1,2,4 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int[] dp = new int[length];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return dp[length - 1];
    }
}
