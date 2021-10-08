package leetcode.array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * @time: 6/4/21 4:32 PM
 */
public class LongestContinuousSubarrayWithLimit {

    public static void main(String[] args) {
        int[] nums = {1,5,6,7,8,10,6,5,6};
        int limit = 4;
        System.out.println(longestSubarray(nums, limit));
        System.out.println(longestSubarray1(nums, limit));
    }

    public static int longestSubarray1(int[] nums, int limit) {
        int left = 0;
        int right = 1;
        int maxLength = 1;
        while (right < nums.length) {
            if (nums[right] != nums[right - 1]) {
                for (int i = left; i < right; i++) {
                    if (Math.abs(nums[i] - nums[right]) > limit) {
                        left = i + 1;
                    }
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            if (Math.abs(num - max) <= limit && Math.abs(num - min) <= limit && Math.abs(max - min) <= limit) {
                queue.offer(num);
                max = Math.max(num, max);
                min = Math.min(num, min);
            } else {
                queue.offer(num);
                queue.poll();
                max = Collections.max(queue);
                min = Collections.min(queue);
            }
        }
        return queue.size();
    }
}
