package leetcode.other;

/**
 * https://leetcode.com/problems/power-of-four/
 * @time: 4/14/21 8:15 PM
 */
public class PowerOfFour {

    public static void main(String[] args) {
        int n = 256;
        System.out.println(isPowerOfFour(n));
    }

    private static boolean isPowerOfFour(int n) {
        while (n % 4 == 0 && n >= 1) {
            n /= 4;
        }
        return n == 1;
    }

}
