package leetcode.other;

/**
 * https://leetcode.com/problems/integer-replacement/
 * @time: 4/20/21 4:15 PM
 */
public class IntegerReplacement {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(integerReplacement1(n));
    }

    public static int integerReplacement1(int n) {
        long num = n;
        int count = 0;
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                // 对3进行特殊处理，不然到下面一步的话count会多一次
                if (num == 3) {
                    count += 2;
                    break;
                }
                // 11 & 11 = 11，如果是奇数，最后一位必定为1，如果倒数第二位也是1，则+1可以把最后两位的1去掉，否则-1
                num = (num & 2) == 2 ? num + 1 : num - 1;
            }
            count++;
        }
        return count;
    }

    public static int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        return integerReplacement((long) n);
    }

    public static int integerReplacement(long n) {
        int count = 0;
        while (n > 1) {
            if (n % 2 ==0) {
                n /= 2;
            } else {
                int countPlus = integerReplacement(n + 1);
                int countMinus = integerReplacement(n - 1);
                boolean shouldPlus = countPlus <= countMinus;
                n = shouldPlus ? n + 1 : n - 1;
            }
            count++;
        }
        return count;
    }
}
