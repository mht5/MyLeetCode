package leetcode.string;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/goat-latin/description/
 * @author mhts
 * @date 2018Äê7ÔÂ27ÈÕ
 */
public class GoatLatin {

	public static void main(String[] args) {
		String str = "The quick brown fox jumped over the lazy dog";
//		String str = "I espeak iGoat Latin";
		System.out.println(toGoatLatin(str));
		System.out.println(toGoatLatin1(str));
		System.out.println(toGoatLatin2(str));
//		long time1 = System.currentTimeMillis();
//		for (int i = 0; i < 1000000; i++) {
//			toGoatLatin(str);
//		}
//		long time2 = System.currentTimeMillis();
//		for (int i = 0; i < 1000000; i++) {
//			toGoatLatin1(str);
//		}
//		long time3 = System.currentTimeMillis();
//		for (int i = 0; i < 1000000; i++) {
//			toGoatLatin2(str);
//		}
//		long time4 = System.currentTimeMillis();
//		System.out.println(time2 - time1);
//		System.out.println(time3 - time2);
//		System.out.println(time4 - time3);
	}
	
	public static String toGoatLatin2(String S) {
		String suffix = "ma";
		java.util.StringJoiner sj = new java.util.StringJoiner(" ");
        for (String word : S.split(" ")) {
        	suffix += 'a';
        	char ch = word.charAt(0);
        	if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
        			|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')) {
        		int length = word.length();
        		char[] array = new char[length];
        		for (int i = 1; i < length; i++) {
        			array[i - 1] = word.charAt(i);
        		}
        		array[length-1] = ch;
        		word = new String(array);
        	}
        	word += suffix;
        	sj.add(word);
        }
        return sj.toString();
    }
	
	public static String toGoatLatin1(String S) {
		List<Integer> vowels = Arrays.asList(65, 69, 73, 79, 85, 97, 101, 105, 111, 117);
		String suffix = "ma";
		java.util.StringJoiner sj = new java.util.StringJoiner(" ");
        for (String word : S.split(" ")) {
        	suffix += 'a';
        	char ch = word.charAt(0);
        	if (!vowels.contains((int) ch)) {
        		int length = word.length();
        		char[] array = new char[length];
        		for (int i = 1; i < length; i++) {
        			array[i - 1] = word.charAt(i);
        		}
        		array[length-1] = ch;
        		word = new String(array);
        	}
        	word += suffix;
        	sj.add(word);
        }
        return sj.toString();
    }
	
	public static String toGoatLatin(String S) {
		List<Integer> vowels = Arrays.asList(65, 69, 73, 79, 85, 97, 101, 105, 111, 117);
		String suffix = "ma";
		java.util.StringJoiner sj = new java.util.StringJoiner(" ");
        for (String word : S.split(" ")) {
        	suffix += 'a';
        	char ch = word.charAt(0);
        	String w = "";
        	if (!vowels.contains((int) ch)) {
        		w = word.substring(1, word.length());
        		word = w + word.charAt(0);
        	}
        	word += suffix;
        	sj.add(word);
        }
        return sj.toString();
    }

}
