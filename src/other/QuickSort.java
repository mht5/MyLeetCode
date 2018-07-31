package other;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = new int[]{1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
		quickSort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + ", ");
		}
		System.out.println();
		array = new int[]{1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
		quickSort1(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + ", ");
		}
		System.out.println();
		array = new int[]{1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
		Arrays.sort(array);
		for (int i : array) {
			System.out.print(i + ", ");
		}
		System.out.println();
		array = new int[]{1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
		quickSort2(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + ", ");
		}

		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			array = new int[]{1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
			quickSort(array, 0, array.length - 1);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			array = new int[]{1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
			quickSort(array, 0, array.length - 1);
		}
		long time3 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			array = new int[]{1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
			Arrays.sort(array);
		}
		long time4 = System.currentTimeMillis();
		System.out.println();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
		System.out.println(time4 - time3);
	}

	private static void quickSort2(int[] array, int l, int h) {
		if (h - l < 5) {
//			如果子数组够小，可以使用其它排序
			return;
		}
		int random = (int) (Math.random() * (h - l) + l);
		int t = array[random];
		array[random] = array[l];
		array[l] = t;
		int i = l;
		int j = h + 1;
		while (true) {
			do {
				i++;
			} while (i <= h && array[i] < t);
			do {
				j--;
			} while (array[j] > t);
			if (i > j) {
				break;
			}
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}
		int tmp = array[l];
		array[l] = array[j];
		array[j] = tmp;
		quickSort2(array, l, j - 1);
		quickSort2(array, j + 1, h);
	}

	private static void quickSort1(int[] array, int l, int h) {
		if (l >= h) {
			return;
		}
		int t = array[l];
		int i = l;
		int j = h + 1;
		while (true) {
			do {
				i++;
			} while (i <= h && array[i] < t);
			do {
				j--;
			} while (array[j] > t);
			if (i > j) {
				break;
			}
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}
		int tmp = array[l];
		array[l] = array[j];
		array[j] = tmp;
		quickSort1(array, l, j - 1);
		quickSort1(array, j + 1, h);
	}

	private static void quickSort(int[] array, int l, int h) {
		if (l >= h) {
			return;
		}
		int m = l;
		int t;
		for (int i = l + 1; i <= h; i++) {
			if (array[i] < array[l]) {
				t = array[i];
				array[i] = array[++m];
				array[m] = t;
			}
		}
		t = array[m];
		array[m] = array[l];
		array[l] = t;
		quickSort(array, l, m - 1);
		quickSort(array, m + 1, h);
	}

}
