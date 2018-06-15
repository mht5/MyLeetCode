package leetcode;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * @author mhts
 *
 */
public class ExcelSheetColumnNumber {
	public static void main(String[] args){
		String s="ABC";
		System.out.println(titleToNumber(s));
	}

	private static int titleToNumber(String s) {
		int n=0;
		for(int i=0; i<s.length(); i++){
			n=n*26+(s.charAt(i)-'A'+1);
		}
		return n;
	}
}
