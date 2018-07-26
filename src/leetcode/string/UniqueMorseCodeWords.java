package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-morse-code-words/description/
 * @author mhts
 * @date 2018Äê7ÔÂ26ÈÕ
 */
public class UniqueMorseCodeWords {
	
	private static Map<Character, String> map = new HashMap<Character, String>();
	
	public static void main(String[] args) {
		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));
		System.out.println(uniqueMorseRepresentations1(words));
	}

	private static int uniqueMorseRepresentations1(String[] words) {
		String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
				".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", 
				"..-", "...-", ".--", "-..-", "-.--", "--.."};
		Set<String> morseSet = new HashSet<>();
		for (String word : words) {
			StringBuilder sb = new StringBuilder();
			for (char ch : word.toCharArray()) {
//				ch = (ch >= 'A' && ch <= 'Z') ? (char) (ch + 32) : ch;
				sb.append(morse[ch - 'a']);
			}
			morseSet.add(sb.toString());
		}
		return morseSet.size();
	}
	
	private static int uniqueMorseRepresentations(String[] words) {
		init();
		
		Set<String> morseSet = new HashSet<>();
		for (String word : words) {
			String code = "";
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				String symbol = map.get((ch >= 'A' && ch <= 'Z') ? (char) (ch + 32) : ch);
				code += symbol;
			}
			morseSet.add(code);
		}
		return morseSet.size();
	}

	private static void init() {
		map.put('a', ".-"); map.put('b', "-..."); map.put('c', "-.-.");
		map.put('d', "-.."); map.put('e', "."); map.put('f', "..-.");
		map.put('g', "--."); map.put('h', "...."); map.put('i', "..");
		map.put('j', ".---"); map.put('k', "-.-"); map.put('l', ".-..");
		map.put('m', "--"); map.put('n', "-."); map.put('o', "---");
		map.put('p', ".--."); map.put('q', "--.-"); map.put('r', ".-.");
		map.put('s', "..."); map.put('t', "-"); map.put('u', "..-");
		map.put('v', "...-"); map.put('w', ".--"); map.put('x', "-..-");
		map.put('y', "-.--"); map.put('z', "--..");
	}

}
