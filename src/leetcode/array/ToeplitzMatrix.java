package leetcode.array;

/**
 * https://leetcode.com/problems/toeplitz-matrix/description/
 * @author mhts
 * @date 2018Äê8ÔÂ17ÈÕ
 */
public class ToeplitzMatrix {

	public static void main(String[] args) {
		int[][] a = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
//		int[][] a = {{1,2,3},{2,1,2}};
        for (int[] n : a) {
        	for (int i : n) {
        		System.out.print(i + ", ");
        	}
        	System.out.println();
        }
		System.out.println(isToeplitzMatrix(a));
		System.out.println(isToeplitzMatrix1(a));
		System.out.println(isToeplitzMatrix2(a));

		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			isToeplitzMatrix(a);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			isToeplitzMatrix1(a);
		}
		long time3 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			isToeplitzMatrix2(a);
		}
		long time4 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
		System.out.println(time4 - time3);
	}
	
    public static boolean isToeplitzMatrix2(int[][] matrix) {
    	int r = matrix.length - 1;
    	int c = matrix[0].length - 1;
    	for (int i = 0; i < r; i++) {
    		for (int j = 0; j < c; j++) {
    			if (matrix[i + 1][j + 1] != matrix[i][j]) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
	
    public static boolean isToeplitzMatrix1(int[][] matrix) {
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[i].length; j++) {
    			if (i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j]) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
	
    public static boolean isToeplitzMatrix(int[][] matrix) {
    	return isToeplitz(matrix, 0, matrix[0].length - 1);
    }

	private static boolean isToeplitz(int[][] matrix, int i, int j) {
		if (j - 1 < 0 || i + 1 >= matrix.length) {
			return true;
		}
		if (matrix[i][j - 1] == matrix[i + 1][j]) {
			return isToeplitz(matrix, i, j - 1) && isToeplitz(matrix, i + 1, j);
		}
		return false;
	}

}
