package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * @time: 6/4/21 4:15 PM
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{8,10},{15,18},{2,6}};
        intervals = merge(intervals);
        for (int[] arr : intervals) {
            for (int i : arr) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> result = new ArrayList<>();
        int len = intervals.length;
        for (int i = 0; i < len; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i < len - 1 && intervals[i + 1][0] <= end) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            result.add(new int[]{start, end});
        }
        return result.toArray(new int[0][0]);
    }
}
