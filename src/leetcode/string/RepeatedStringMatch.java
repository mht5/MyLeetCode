package leetcode.string;

/**
 * https://leetcode.com/problems/repeated-string-match/description/
 * @author mhts
 * @date 2018Äê7ÔÂ30ÈÕ
 */
public class RepeatedStringMatch {
	
	public static void main(String[] args) {
		String a = "abcd";
		String b = "cdabcdab";
		System.out.println(repeatedStringMatch(a, b));
		System.out.println(repeatedStringMatch1(a, b));
		
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			repeatedStringMatch(a, b);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			repeatedStringMatch1(a, b);
		}
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}
	
    public static int repeatedStringMatch1(String A, String B) {
        int a = A.length();
        int b = B.length();
        int times = b / a == 0 ? 1 : b / a;
        StringBuilder sb = new StringBuilder(A);
        for (int i = 1; i < times; i++) {
        	sb.append(A);
        }
        if (sb.lastIndexOf(B) != -1) {
        	return times;
        }
        sb.append(A);
        if (sb.lastIndexOf(B) != -1) {
        	return times + 1;
        }
        sb.append(A);
        if (sb.lastIndexOf(B) != -1) {
        	return times + 2;
        }
        return -1;
    }
    
    public static int repeatedStringMatch(String A, String B) {
        int count = 1;
        StringBuilder sb = new StringBuilder(A);
        while (sb.length() < B.length()) {
        	sb.append(A);
        	count++;
        }
        if (sb.indexOf(B) >= 0) {
        	return count;
        }
        if (sb.append(A).indexOf(B) >= 0) {
        	return count + 1;
        }
        return -1;
    }

}
