package leetcode.other;

/**
 * Digital Root
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * https://leetcode.com/problems/add-digits/description/
 * @author mhts
 *
 */
public class AddDigits {
	public static void main(String[] args){
		for(int i=0; i<10000; i++){
			System.out.println(addDigits(i));
		}
	}
	public static int addDigits(int num) {
		return num==0 ? 0 : (num%9==0 ? 9 : num%9);
//	    if(num==0){
//	        return num;
//	    }
//	    else{
//	    	return num%9==0 ? 9 : num%9;
//	    }
	}
}
