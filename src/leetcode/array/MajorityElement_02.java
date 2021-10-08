package leetcode.array;

import java.util.*;

/**
 * https://leetcode.com/problems/majority-element-ii/
 * @time: 4/18/21 4:22 PM
 */
public class MajorityElement_02 {

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        List<Integer> result = majorityElement2(nums);
        for (Integer num : result) {
            System.out.printf("%d\t", num);
        }
    }

    public static List<Integer> majorityElement2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int val1 = nums[0];
        int count1 = 1;
        int val2 = val1;
        int count2 = 0;
        int i = 1;
        // 先找到两个不同的值
        for (i = 1; i < nums.length; i++) {
            if (nums[i] != val1) {
                val2 = nums[i];
                count2++;
                i++;
                break;
            }
            count1++;
        }
        // 找到出现次数最多的两个值
        while (i < nums.length) {
            if (nums[i] == val1) {
                count1++;
            } else if (nums[i] == val2) {
                count2++;
            } else if (count1 == 0) {
                val1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                val2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
            i++;
        }
        // 统计两个值的出现次数
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == val1) {
                count1 ++;
            } else if (num == val2) {
                count2 ++;
            }
        }

        if (count1 > nums.length / 3) {
            result.add(val1);
        }
        if (count2 > nums.length / 3) {
            result.add(val2);
        }

        return result;
    }

    public static List<Integer> majorityElement1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int threshold = nums.length / 3;
        int val = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count > threshold) {
                break;
            }
            if (nums[i] != val) {
                val = nums[i];
                count = 1;
            } else {
                count++;
            }
            if (count > threshold) {
                if (!result.contains(nums[i])) {
                    result.add(nums[i]);
                    count = 0;
                }
            }
        }
        return result;
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            int count = countMap.getOrDefault(i, 0);
            countMap.put(i, count + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > (nums.length / 3)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
