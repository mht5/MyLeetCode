package leetcode;

/**
 * Write a function that takes an unsigned integer and returns the number of ¡¯1' bits it has (also known as the Hamming weight).
 * @author mhts
 *
 */
public class NumberOf1Bits {
	public static void main(String[] args){
		int n=111;
		System.out.println(hammingWeight(n));
	}

	private static int hammingWeight(int n) {
		int count=0;
		String s=Integer.toBinaryString(n);
		System.out.println(s);
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='1'){
				count++;
			}
		}
		return count;
	}
}
