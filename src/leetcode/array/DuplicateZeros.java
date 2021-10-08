package leetcode.array;

/**
 * https://leetcode.com/problems/duplicate-zeros/
 * @time: 4/28/21 7:53 PM
 */
public class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = {1,0,7,2,4,3,1,0,2,6};
        duplicateZeros(arr);
        for (int i : arr) {
            System.out.printf("%d\t", i);
        }
    }

    public static void duplicateZeros(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        int index = 0;
        for (int i = 0; i < copy.length && index < arr.length; i++) {
            if (copy[i] == 0) {
                arr[index] = 0;
                if (index < arr.length - 1) {
                    arr[index + 1] = 0;
                }
                index += 2;
            } else {
                arr[index] = copy[i];
                index++;
            }
        }
    }
}
