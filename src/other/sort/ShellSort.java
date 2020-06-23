package other.sort;

public class ShellSort {

    public static void main(String[] args) {
        int[] a = {2,3,4,5,7,4,2,5};
        shellSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private static void shellSort(int[] a) {
        int step = 1;
        while (step <= a.length / 3) {
            step = step * 3 + 1;
        }
        while (step > 0) {
            for (int i = step; i < a.length; i++) {
                int tmp = a[i];
                int j = i;
                while (j > step - 1 && tmp < a[j - step]) {
                    a[j] = a[j - step];
                    j -= step;
                }
                a[j] = tmp;
            }
            step = (step - 1) / 3;
        }
    }
}
