package other;

public class InsertSort {

	public static void main(String[] args) {
		int[] array = new int[]{1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
		insertSort(array);
		for (int i : array) {
			System.out.print(i + ", ");
		}
		System.out.println();
		array = new int[]{1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
		insertSort1(array);
		for (int i : array) {
			System.out.print(i + ", ");
		}

		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			array = new int[]{1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
			insertSort(array);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			array = new int[]{1,5,6,8,7,4,3,2,1,5,6,7,9,0,8,7,6,5,6,7,8};
			insertSort1(array);
		}
		long time3 = System.currentTimeMillis();
		System.out.println();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}

	private static void insertSort1(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int tmp = array[i];
			int j;
			for (j = i; j > 0 && array[j - 1] > tmp; j--) {
				array[j] = array[j - 1];
			}
			array[j] = tmp;
		}
	}

	private static void insertSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
				int tmp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = tmp;
			}
		}
	}

}
