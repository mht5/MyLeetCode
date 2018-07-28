package leetcode.string;

/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/description/
 * @author mhts
 * @date 2018Äê7ÔÂ28ÈÕ
 */
public class NumberOfSegmentsInAString {

	public static void main(String[] args) {
		String str = "g        today,  is     a@#@#  good!  day     ";
		System.out.println(countSegments(str));
	}
	
    public static int countSegments(String s) {
    	int count = 0;
    	char[] array = s.toCharArray();
    	for (int i = 0; i < array.length; i++) {
    		if (array[i] != ' ' && (i ==0 || array[i - 1] == ' ')) {
    			count++;
    		}
    	}
        return count;
    }

}
