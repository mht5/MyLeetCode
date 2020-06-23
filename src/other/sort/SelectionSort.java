package other.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {1,5,4,2,5,7,2,5,7};
        selectionSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = a[min];
                a[min] = a[i];
                a[i] = tmp;
            }
        }
    }
}
