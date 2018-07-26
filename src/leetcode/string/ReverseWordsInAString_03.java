package leetcode.string;

public class ReverseWordsInAString_03 {

	public static void main(String[] args) {
		String s = "do not go gentle into that dark night";
		System.out.println(reverseWords(s));
		System.out.println(reverseWords1(s));
		long time1 = System.currentTimeMillis();
		for (int i = 0 ; i < 100000; i++) {
			reverseWords(s);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0 ; i < 100000; i++) {
			reverseWords1(s);
		}
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}
	
	public static String reverseWords1(String s) {
        java.util.StringJoiner sj = new java.util.StringJoiner(" ");
        for (String word : s.split(" ")) {
        	sj.add(reverseWord(word));
        }
        return sj.toString();
    }
	
	public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] array = s.split(" ");
        for (int i = 0; i < array.length; i++) {
        	if (i < array.length - 1) {
        		sb.append(reverseWord(array[i]) + " ");
        	} else {
        		sb.append(reverseWord(array[i]));
        	}
        }
        return sb.toString();
    }

	public static String reverseWord(String s) {
		char[] array = s.toCharArray();
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			char tmp = array[high];
			array[high] = array[low];
			array[low] = tmp;
			low++;
			high--;
		}
		return new String(array);
	}

}
