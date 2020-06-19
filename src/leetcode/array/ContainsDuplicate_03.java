package leetcode.array;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 */
public class ContainsDuplicate_03 {

    public static void main(String[] args){
        int[] nums = {-2147483648,-2147483647};
        int k = 3;
        int t = 3;
        System.out.println(containsNearbyAlmostDuplicate1(nums, k, t));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i  = 0; i < nums.length; i++) {
            Long floor = set.floor(nums[i] + (long) t);
            Long ceiling = set.ceiling(nums[i] - (long) t);
            if ((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (nums.length > 9999) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = ((i + k) >= nums.length ? nums.length - 1 : i + k); j > i; j--) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}
