package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 * @time: 4/24/21 7:19 PM
 */
public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int depth = triangle.size();
        int width = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[depth + 1][width + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= depth; i++) {
            List<Integer> curLevel = triangle.get(i - 1);
            for (int j = 1; j <= curLevel.size(); j++) {
                int minSumUpper;
                if (j == 1) {
                    minSumUpper = dp[i - 1][j];
                } else if (j == curLevel.size()) {
                    minSumUpper = dp[i - 1][j - 1];
                } else {
                    minSumUpper = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
                dp[i][j] = minSumUpper + curLevel.get(j - 1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < dp[depth].length; i++) {
            int num = dp[depth][i];
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
