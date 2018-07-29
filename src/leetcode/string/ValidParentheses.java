package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 * @author mhts
 * @date 2018Äê7ÔÂ29ÈÕ
 */
public class ValidParentheses {

	public static void main(String[] args) {
		String str = "[])";
		System.out.println(isValid(str));
	}
	
    public static boolean isValid(String s) {
    	List<Character> list = new ArrayList<>();
    	int index;
        if (s.indexOf(')') == 0 || s.indexOf(']') == 0 || s.indexOf('}') == 0) {
        	return false;
        }
        for (char ch : s.toCharArray()) {
        	if (ch == '(' || ch == '[' || ch == '{') {
        		list.add(ch);
        	} else {
        		if (list.isEmpty()) {
        			return false;
        		}
        		index = list.size() - 1;
        		if (!match(list.get(index), ch)) {
        			return false;
        		}
        		list.remove(index);
        	}
        }
    	return list.size() == 0;
    }

	private static boolean match(Character c, char ch) {
		if (c == '(' && ch == ')') {
			return true;
		} else if (c == '[' && ch == ']') {
			return true;
		} else if (c == '{' && ch == '}') {
			return true;
		}
		return false;
	}

}
