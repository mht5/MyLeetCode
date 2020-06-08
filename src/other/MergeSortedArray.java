package other;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7, 9, 11};
        int[] nums2 = {0, 2, 4, 6, 8, 10, 13, 14};
        int[] nums3 = {1, 2, 3, 6, 8, 9, 12, 15};
        int[] nums4 = {0, 7, 8, 16, 17};
        List<int[]> numbers = new ArrayList<>();
        numbers.add(nums1);
        numbers.add(nums2);
        numbers.add(nums3);
        numbers.add(nums4);
        new MergeSortedArray().multiMerge(numbers);
    }

    public void multiMerge(List<int[]> numbers) {
        int[] arr;
        arr = merge(numbers.get(0), numbers.get(0).length, numbers.get(1), numbers.get(1).length);
        for (int i = 2; i< numbers.size(); i++) {
            arr = merge(arr, arr.length, numbers.get(i), numbers.get(i).length);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int x = 0;
        int y = 0;
        int[] arr = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            if (x < m && y < n) {
                if (nums1[x] < nums2[y]) {
                    arr[i] = nums1[x++];
                } else {
                    arr[i] = nums2[y++];
                }
            } else if (x >= m) {
                arr[i] = nums2[y++];
            } else if (y >= n) {
                arr[i] = nums1[x++];
            }
        }
        return arr;
    }
}
