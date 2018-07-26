package leetcode.string;

import java.util.StringJoiner;

/**
 * Given an input string, reverse the string word by word.
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * @author mhts
 *
 */
public class ReverseWordsInAString {
	public static void main(String[] args){
		String s = "     do  not  go gentle  into     that  dark night   ";
//		String s = "        ";
		System.out.println("*"+reverseWords2(s)+"*");
	}

	public static String reverseWords2(String s) {
		String[] words = s.trim().split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			if (!words[i].isEmpty()) {
				sb.append(words[i] + " ");
			}
		}
		return sb.toString();
	}

	public static String reverseWords1(String s) {
		String[] words = s.split(" ");
		StringJoiner sj = new StringJoiner(" ");
		for (int i = words.length - 1; i >= 0; i--) {
			if (!words[i].isEmpty()) {
				sj.add(words[i]);
			}
		}
		return sj.toString();
	}
	
	public static String reverseWords(String s) {
		if ("".equals(s.trim())) {
			return "";
		}
        String[] sArray=s.split("");
        String word=null;
        StringBuffer sb=new StringBuffer();
        for(int i=sArray.length-1; i>=0; i--){
        	if(!sArray[i].equals(" ")){
        		if(word==null){
        			word=sArray[i];
        		}
        		else{
        			word+=sArray[i];
        		}
        	}
        	else{
        		if(word!=null){
            		word=reverseWord(word);
            		sb.append(word);
            		sb.append(" ");
        		}
        		word=null;
        	}
        }
		if(word!=null){
    		word=reverseWord(word);
    		sb.append(word);
		}
		String result = sb.toString();
		if (result.lastIndexOf(" ") == result.length() - 1) {
			result = result.substring(0, result.length()-1);
		}
        return result;
    }

	public static String reverseWord(String word) {
        String[] chars=word.split("");
        String w=null;
        for(int i=chars.length-1; i>=0; i--){
        	if(w==null){
        		w=chars[i];
        	}
        	else{
        		w+=chars[i];
        	}
        }
        return w;
	}
}
