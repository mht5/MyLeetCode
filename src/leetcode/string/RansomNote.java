package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/ransom-note/description/
 * @author mhts
 * @date 2018Äê7ÔÂ27ÈÕ
 */
public class RansomNote {

	public static void main(String[] args) {
		String ransomNote = "whatdoyouhavetosay";
		String magazine = "whoahdauevsdtyoyfshajkot";
		System.out.println(canConstruct(ransomNote, magazine));
		System.out.println(canConstruct1(ransomNote, magazine));

		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			canConstruct(ransomNote, magazine);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			canConstruct1(ransomNote, magazine);
		}
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}
	
	public static boolean canConstruct1(String ransomNote, String magazine) {
		if (ransomNote.isEmpty()) {
			return true;
		}
		if (magazine.isEmpty()) {
			return false;
		}
		int[] indices = new int[26];
		for (char ch : ransomNote.toCharArray()) {
			int index = magazine.indexOf(ch, indices[ch - 'a']);
			if (index == -1) {
				return false;
			} else {
				indices[ch - 'a'] = index + 1;
			}
		}
		return true;
	}
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.isEmpty()) {
			return true;
		}
		if (magazine.isEmpty()) {
			return false;
		}
		Map<Character, Integer> ransomMap = new HashMap<>();
		Map<Character, Integer> magazineMap = new HashMap<>();
		boolean canConstruct = true;
        for (char ch : ransomNote.toCharArray()) {
        	ransomMap.put(ch, ransomMap.containsKey(ch) ? ransomMap.get(ch) + 1 : 1);
        }
        for (char ch : magazine.toCharArray()) {
        	magazineMap.put(ch, magazineMap.containsKey(ch) ? magazineMap.get(ch) + 1 : 1);
        }
	 	for (Map.Entry<Character, Integer> entry : ransomMap.entrySet()) {
	 		Character key = entry.getKey();
	 		if (!magazineMap.containsKey(key) || magazineMap.get(key) < entry.getValue()) {
	 			canConstruct = false;
	 			break;
	 		}
	 	}
		return canConstruct;
    }

}
