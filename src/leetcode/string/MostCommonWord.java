package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-common-word/description/
 * @author mhts
 * @date 2018Äê7ÔÂ27ÈÕ
 */
public class MostCommonWord {

	public static void main(String[] args) {
		String str = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		System.out.println(mostCommonWord(str, banned));
	}
	
	public static String mostCommonWord(String paragraph, String[] banned) {
		Map<String, Integer> wordMap = new HashMap<>();
        String[] array = paragraph.split(" ");
    	boolean isBanned = false;
    	
        for (String word : array) {
        	isBanned = false;
        	word = word.toLowerCase();

        	if (word.endsWith(",") || word.endsWith("!") ||word.endsWith("?")
        			|| word.endsWith("'") || word.endsWith(";") || word.endsWith(".")) {
        		word = word.substring(0, word.length() - 1);
        	}
        	
        	for (int i = 0; i < banned.length; i++) {
        		if (word.equals(banned[i])) {
        			isBanned = true;
        			break;
        		}
        	}
        	
        	if (!isBanned) {
            	wordMap.put(word, wordMap.containsKey(word) ? wordMap.get(word) + 1 : 1);
        	}
        }
        
        int count = 0;
        String word = "";
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
        	if (entry.getValue() > count) {
        		word = entry.getKey();
        		count = entry.getValue();
        	}
        }
		return word;
    }

}