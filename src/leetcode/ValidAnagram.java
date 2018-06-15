package leetcode;

import java.util.Arrays;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * @author mhts
 *
 */
public class ValidAnagram {
	public static void main(String[] args){
		String s1="afcafcafc";
		String s2="cfaccaffa";
		System.out.println(isAnagram(s1, s2));
	}
	
	public static boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()){
			return false;
		}
		char[] sArray=s.toCharArray();
		char[] tArray=t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
		return new String(sArray).endsWith(new String(tArray));
    }
}
