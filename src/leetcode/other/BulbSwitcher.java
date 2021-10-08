package leetcode.other;

/**
 * https://leetcode.com/problems/bulb-switcher/
 * @time: 4/14/21 8:25 PM
 */
public class BulbSwitcher {

    public static void main(String[] args) {
        System.out.println(bulbSwitch(100));
        System.out.println(bulbSwitch1(100));
    }

    public static int bulbSwitch1(int n) {
        return (int) Math.sqrt(n);
    }

    public static int bulbSwitch(int n) {
        if (n <= 1) {
            return n;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }
        int index = 2;
        while (index <= n) {
            for (int i = index; i <= n; i+=index) {
                arr[i - 1] = Math.abs(arr[i - 1] - 1);
            }
            index++;
        }
        int count = 0;
        for (int i : arr) {
            if (i == 1) {
                count++;
            }
        }
        return count;
    }

}
