package leetcode.array;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 * @time: 4/20/21 2:32 PM
 */
public class MinimumNumberOfOperations {

    public static void main(String[] args) {
        String boxes = "001011";
        int[] result = minOperations1(boxes);
        for (int i : result) {
            System.out.printf("%d\t", i);
        }
    }

    public static int[] minOperations1(String boxes) {
        int n = boxes.length();
        char[] chars = boxes.toCharArray();

        int[] left = new int[n];
        int count = chars[0] - '0';
        for (int i = 1; i < n; i++) {
            // 每一个位置需要的数量是前面一个位置的数量加上前面所有需要移动(1)的数量
            left[i] = left[i - 1] + count;
            count += chars[i] - '0';
        }

        int[] right = new int[n];
        count = chars[n - 1] - '0';
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + count;
            count += chars[i] - '0';
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] + right[i];
        }
        return result;
    }

    public static int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        char[] chars = boxes.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int left = 0; left < i; left++) {
                if (chars[left] == '1') {
                    result[i] += (i - left);
                }
            }
            for (int right = chars.length - 1; right > i; right--) {
                if (chars[right] == '1') {
                    result[i] += (right - i);
                }
            }
        }
        return result;
    }
}
