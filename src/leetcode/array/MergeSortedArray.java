package leetcode.array;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7, 9, 11};
        int[] nums2 = {0, 2, 4, 6, 8, 10, 13, 14};
        new MergeSortedArray().merge(nums1, nums1.length, nums2, nums2.length);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
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
        nums1 = new int[m + n];
        for (int i = 0; i < arr.length; i++) {
            nums1[i] = arr[i];
            System.out.print(nums1[i] + " ");
        }
    }
}
