package leetcode;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * @author mhts
 *
 */
public class ExcelSheetColumnTitle {
	public static void main(String[] args){
		int n=971;
		System.out.println(convertToTitle(n));
	}

	private static String convertToTitle(int n) {
        String s="";
        while(n!=0){
            s=(char)((n-1)%26+'A')+s;
            n=(n-1)/26;
        }
        return s;
	}
}
