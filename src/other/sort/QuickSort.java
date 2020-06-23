package other.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] a = {1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
		quickSort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private static void quickSort(int[] a, int left, int right) {
		if (left < right) {
			int partition = partitionIt(a, left, right);
			quickSort(a, left, partition - 1);
			quickSort(a, partition + 1, right);
		}
	}

	private static int partitionIt(int[] a, int left, int right) {
		int i = left;
		int j = right + 1;
		int pivot = a[left];
		while (true) {
			while (i < right && a[++i] < pivot) {}
			while (j > 0 && a[--j] > pivot) {}
			if (i >= j) {
				break;
			} else {
				swap(a, i, j);
			}
		}
		swap(a, left, j);
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
