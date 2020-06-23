package other.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {1,5,6,4,3,6,3,2,8};
        bubbleSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private static void bubbleSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
