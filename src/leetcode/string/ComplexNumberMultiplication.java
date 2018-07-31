package leetcode.string;

/**
 * https://leetcode.com/problems/complex-number-multiplication/description/
 * @author mhts
 * @date 2018Äê7ÔÂ31ÈÕ
 */
public class ComplexNumberMultiplication {

	public static void main(String[] args) {
		String str1 = "1+-1i";
		String str2 = "1+-1i";
		System.out.println(complexNumberMultiply(str1, str2));
	}
	
    public static String complexNumberMultiply(String a, String b) {
    	int index = a.indexOf("+");
        int a1 = Integer.parseInt(a.substring(0, index));
        int a2= Integer.parseInt(a.substring(index + 1, a.indexOf("i")));
        index = b.indexOf("+");
        int b1 = Integer.parseInt(b.substring(0, index));
        int b2= Integer.parseInt(b.substring(index + 1, b.indexOf("i")));
    	return (a1 * b1 - a2 * b2) + "+" + (a1 * b2 + a2 * b1) + "i";
    }

}
