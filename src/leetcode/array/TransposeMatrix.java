package leetcode.array;

/**
 * Given a matrix A, return the transpose of A.
 * https://leetcode.com/problems/transpose-matrix/description/
 * @author mhts
 * @date 2018Äê8ÔÂ17ÈÕ
 */
public class TransposeMatrix {

	public static void main(String[] args) {
		int[][] a = {{1,2,3},{4,5,6}};
		a = transpose(a);
		for (int[] n : a) {
			for (int i : n) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}
	
    public static int[][] transpose(int[][] A) {
        int[][] b = new int[A[0].length][A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				b[j][i] = A[i][j];
			}
		}
    	return b;
    }

}
