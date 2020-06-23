package other.sort;

public class InsertSort {

	public static void main(String[] args) {
		int[] a = {3,6,3,1,4,6,4,2,3,4,2,8};
		insertSort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int tmp = a[i];
			int j = i;
			while (j > 0 && tmp < a[j - 1]) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = tmp;
		}
	}

}
