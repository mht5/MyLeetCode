package leetcode;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * @author mhts
 *
 */
public class PowerOfTwo {
	public static void main(String[] args){
		int n=1020;
		System.out.println(isPowerOfTwo(n));
	}
	
	public static boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        while(n%2==0){
            n>>=1;
        }
        return n==1;
    }
}
