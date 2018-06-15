package leetcode;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * @author mhts
 *
 */
public class PlusOne_02 {
	public static void main(String[] args){
		int[] num=new int[]{9,9,8};
		num=plusOne(num);
		for(int i : num){
			System.out.print(i+", ");
		}
		System.out.println();
		num=plusOne(num);
		for(int i : num){
			System.out.print(i+", ");
		}
	}
	
	public static int[] plusOne(int[] digits) {
		int l=digits.length;
		for(int i=l-1; i>=0; i--){
			if(digits[i]<9){
				digits[i]++;
				return digits;
			}
			digits[i]=0;
		}
		int[] answer=new int[l+1];
		answer[0]=1;
		return answer;
    }
}
