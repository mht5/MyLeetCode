package leetcode.other;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * @time: 4/27/21 8:18 PM
 */
public class CountSquareSubmatrices {

    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int count = 0;
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                count++;
            }
        }
        for (int i = 0; i < len2; i++) {
            if (matrix[0][i] == 1) {
                dp[0][i] = 1;
                count++;
            }
        }
        if (matrix[0][0] == 1) {
            count--;
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i- 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    count += dp[i][j];
                }
            }
        }
        return count;
    }
}
