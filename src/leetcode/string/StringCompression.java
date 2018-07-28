package leetcode.string;

/**
 * https://leetcode.com/problems/string-compression/description/
 * @author mhts
 * @date 2018Äê7ÔÂ28ÈÕ
 */
public class StringCompression {

	public static void main(String[] args) {
		char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
		System.out.println(compress(chars));
		for (char ch : chars) {
			System.out.print(ch + ", ");
		}
		System.out.println();
		System.out.println(compress1(chars));
		for (char ch : chars) {
			System.out.print(ch + ", ");
		}
	}
	
	public static int compress1(char[] chars) {
		int index = 0;
		int count = 0;
		for (int i = 0; i <chars.length; i++) {
			if (i + 1 == chars.length || chars[i + 1] != chars[i]) {
				chars[count++] = chars[index];
				if (i > index) {
					for (char ch : ((i - index + 1) + "").toCharArray()) {
						chars[count++] = ch;
					}
				}
				index = i + 1;
			}
		}
		return count;
	}
	
    public static int compress(char[] chars) {
        int count = 1;
        int length = 0;
        for (int i = 1; i < chars.length; i++) {
        	if (chars[i] != chars[i - 1]) {
        		length += (count == 1 ? 1 : 1 + (count == 1000 ? 4 : (count > 99 ? 3 : (count > 9 ? 2 : 1))));
        		count = 1;
        	} else {
        		count++;
        	}
        }
		length += (count == 1 ? 1 : 1 + (count == 1000 ? 4 : (count > 99 ? 3 : (count > 9 ? 2 : 1))));
    	return length;
    }

}
