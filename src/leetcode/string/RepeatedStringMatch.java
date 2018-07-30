package leetcode.string;

public class RepeatedStringMatch {

	public static void main(String[] args) {
		String a = "abcd";
		String b = "cdabcdabd";
		System.out.println(repeatedStringMatch(a, b));
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
