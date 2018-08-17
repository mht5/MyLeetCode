package leetcode.array;

/**
 * https://leetcode.com/problems/reshape-the-matrix/description/
 * @author mhts
 * @date 2018Äê8ÔÂ17ÈÕ
 */
public class ReshapeTheMatrix {

	public static void main(String[] args) {
//		int[][] a = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
//		int[][] a = {{1,2,3},{2,1,2}};
		int[][] a = {{1,2},{3,4}};
		int r = 2;
		int c = 4;
		a = matrixReshape(a, r ,c);
		for (int[] n : a) {
			for (int i : n) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}
	
    public static int[][] matrixReshape1(int[][] nums, int r, int c) {
        if ((r * c  + r) < nums.length * nums[0].length || (r * c > nums.length * nums[0].length)) {
        	return nums;
        }
        int[][] array = new int[r][c];
        int row = 0;
        int col = 0;
        int l = nums[0].length;
        for (int i = 0; i < nums.length; i++) {
        	for (int j = 0; j < l; j++) {
        		array[row][col++] = nums[i][j];
        		if (col == c) {
        			row++;
        			col = 0;
        		}
        	}
        }
        return array;
    }
	
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if ((r * c  + r) < nums.length * nums[0].length || (r * c > nums.length * nums[0].length)) {
        	return nums;
        }
        int[][] array = new int[r][c];
        int[] a = new int[10000];
        int j = 0;
        for (int[] n : nums) {
        	for (int i : n) {
        		a[j++] = i;
        	}
        }
        j = 0;
        for (int m = 0 ; m < r; m++) {
        	for (int n = 0; n < c; n++) {
        		array[m][n] = a[j++];
        	}
        }
        return array;
    }

}
