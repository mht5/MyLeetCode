package leetcode.string;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 * @author mhts
 * @date 2018Äê7ÔÂ27ÈÕ
 */
public class FirstUniqueCharacterInAString {

	public static void main(String[] args) {
		String str = "tisisatestmessage";
		System.out.println(firstUniqChar(str));
		System.out.println(firstUniqChar1(str));
		
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			firstUniqChar(str);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			firstUniqChar1(str);
		}
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}

    public static int firstUniqChar1(String s) {
    	int index = s.length();
    	for (char ch = 'a'; ch <= 'z'; ch++) {
    		int tmp= s.indexOf(ch);
    		if (tmp != -1 && tmp == s.lastIndexOf(ch)) {
    			index = index < tmp ? index : tmp;
    		}
    	}
        return index == s.length() ? -1 : index;
    }

    public static int firstUniqChar(String s) {
    	int index = -1;
    	char[] array = s.toCharArray();
    	for (int i = 0; i < array.length; i++) {
    		if (s.indexOf(array[i]) == i && s.indexOf(array[i], i + 1) == -1) {
    			index = i;
    			break;
    		}
    	}
        return index;
    }
}
