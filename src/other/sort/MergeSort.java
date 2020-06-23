package other.sort;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] a = {2,3,4,5,7,4,2,5};
        mergeSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (high - low) / 2 + low;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= high) {
            tmp[k++] = a[j++];
        }
        for (i = 0; i < tmp.length; i++) {
            a[low + i] = tmp[i];
        }
    }
}
