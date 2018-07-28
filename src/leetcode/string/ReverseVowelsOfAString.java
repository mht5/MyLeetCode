package leetcode.string;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 * @author mhts
 * @date 2018Äê7ÔÂ28ÈÕ
 */
public class ReverseVowelsOfAString {

	public static void main(String[] args) {
		String str = "whatisthis";
		System.out.println(reverseVowels(str));
	}
	
    public static String reverseVowels(String s) {
        char[] array1 = s.toCharArray();
        char[] array2 = new char[array1.length];
        int num = 0;
        for (int i = 0; i < array1.length; i++) {
        	char ch = array1[i];
        	if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
        			||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
        		array2[num++] = ch;
        		array1[i] = (char) 0;
        	}
        }
        int h = num - 1;
        int l = 0;
        while (l < h) {
        	char ch = array2[h];
        	array2[h] = array2[l];
        	array2[l] = ch;
        	h--;
        	l++;
        }
        num = 0;
        for (int i = 0; i < array1.length; i++) {
        	if (array1[i] == 0) {
        		array1[i] = array2[num++];
        	}
        }
    	return new String(array1);
    }

}
