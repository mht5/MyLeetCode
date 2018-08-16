package leetcode.array;

/**
 * https://leetcode.com/problems/flipping-an-image/description/
 * @author mhts
 * @date 2018Äê8ÔÂ16ÈÕ
 */
public class FlippingAnImage {

	public static void main(String[] args) {
		int[][] a = {{1,1,0},{1,0,1},{0,0,0}};
		a = flipAndInvertImage(a);
		for (int[] n : a) {
			for (int i : n) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}
	
    public static int[][] flipAndInvertImage(int[][] A) {
		for (int[] n : A) {
			for (int i = 0; i < (n.length + 1) / 2; i++) {
				int t = n[i] ^ 1;
				n[i] = n[n.length - 1 - i] ^ 1;
				n[n.length - 1 - i] = t;
			}
		}
    	return A;
    }

}
