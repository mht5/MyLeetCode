package other.sort;

public class BucketSort {

    public static void main(String[] args) {
        int[] a = {1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
        bucketSort(a, 10);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private static void bucketSort(int[] a, int max) {
        int[] buckets = new int[max];
        for (int i = 0; i < a.length; i++) {
            buckets[a[i]]++;
        }
        for (int i = 0, j = 0; i < max; i++) {
            while ((buckets[i]--) > 0) {
                a[j++] = i;
            }
        }
        buckets = null;
    }
}
