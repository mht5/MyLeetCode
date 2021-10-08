package leetcode.other;

/**
 * https://leetcode.com/problems/maximum-score-from-removing-stones/
 * @time: 4/18/21 5:34 PM
 */
public class MaximumScoreFromRemovingStones {

    public static void main(String[] args) {
        int a = 1, b = 8, c = 8;
        System.out.println(maximumScore(a, b, c));
    }

    public static int maximumScore(int a, int b, int c) {
        int count = 0;
        int max, less1, less2;
        if (a > b && a > c) {
            max = a;
            less1 = b;
            less2 = c;
        } else if (b > a && b > c) {
            max = b;
            less1 = a;
            less2 = c;
        } else {
            max = c;
            less1 = a;
            less2 = b;
        }
        if (max >= less1 + less2) {
            return less1 + less2;
        }
        while (max < less1 + less2) {
            less1--;
            less2--;
            count++;
        }

        return count + (less1 + less2);
    }
}
