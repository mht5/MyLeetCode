package leetcode;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * @author mhts
 *
 */
public class PlusOne_01 {
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
		if(digits.length==0){
			return digits;
		}
		boolean flag=true;
		int i=digits.length-1;
		while(flag && i>=0){
			digits[i]+=1;
			if(digits[i]>9){
				digits[i]=0;
				i--;
			}
			else{
				flag=false;
			}
		}
		if(flag){
			int[] answer=new int[digits.length+1];
			answer[0]=1;
			for(int j=0; j<digits.length; j++){
				answer[j+1]=digits[j];
			}
			return answer;
		}
		return digits;
    }
}
