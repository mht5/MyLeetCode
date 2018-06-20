package leetcode.other;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * https://leetcode.com/problems/excel-sheet-column-number/description/
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
