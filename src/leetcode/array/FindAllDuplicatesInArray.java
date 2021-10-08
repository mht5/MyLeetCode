package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * @time: 4/15/21 8:18 PM
 */
public class FindAllDuplicatesInArray {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = findDuplicates1(nums);
        for (Integer i : duplicates) {
            System.out.printf("%d\t", i);
        }
    }

    public static List<Integer> findDuplicates1(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > n * 2) {
                duplicates.add(i + 1);
            }
        }
        return duplicates;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            if (!numSet.contains(i)) {
                numSet.add(i);
            } else {
                duplicates.add(i);
            }
        }
        return duplicates;
    }

}
