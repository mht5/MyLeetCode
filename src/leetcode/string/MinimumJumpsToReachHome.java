package leetcode.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-jumps-to-reach-home/
 * @time: 4/28/21 8:07 PM
 */
public class MinimumJumpsToReachHome {

    public static void main(String[] args) {
        int[] forbidden = {1,6,2,14,5,17,4};
        int a = 16;
        int b = 9;
        int x = 7;
        System.out.println(minimumJumps(forbidden, a, b, x));
    }

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<>();
        for (int i : forbidden) {
            set.add(i);
        }
        int border = 6000;
        int[] step = new int[border];
        boolean[] flag = new boolean[border];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (index == x) {
                return step[index];
            }
            if (index + a < border && set.add(index + a)) {
                queue.offer(index + a);
                step[index + a] = step[index] + 1;
                flag[index + a] = true;
            }
            if (flag[index] && index - b > 0 && !set.contains(index - b)) {
                queue.offer(index - b);
                step[index - b] = step[index] + 1;
                flag[index - b] = false;
            }
        }
        return -1;
    }
}
