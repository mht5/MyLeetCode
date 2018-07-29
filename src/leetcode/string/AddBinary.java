package leetcode.string;

/**
 * Given two binary strings, return their sum (also a binary string).
 * https://leetcode.com/problems/add-binary/description/
 * @author mhts
 * @date 2018Äê7ÔÂ29ÈÕ
 */
public class AddBinary {

	public static void main(String[] args) {
		String a = "1011";
		String b = "1011";
		System.out.println(addBinary(a, b));
	}
	
    public static String addBinary(String a, String b) {
    	int m = a.length() - 1;
    	int n = b.length() - 1;
    	int tmp = 0;
    	int sum;
    	StringBuilder sb = new StringBuilder();
    	while (m > -1 || n > -1 || tmp > 0) {
    		sum = 0;
    		sum += m > -1 ? a.charAt(m--) - '0' : 0;
    		sum += n > -1 ? b.charAt(n--) - '0' : 0;
    		sum += tmp;
    		tmp = sum / 2;
    		sb.append(sum % 2);
    	}
    	return sb.reverse().toString();
    }

}
