package leetcode.other;

/** 
 * NOT SOLVED YET!!!
 * Given an input string, reverse the string word by word.
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * @author mhts
 * 
 */
public class ReverseWordsInAString {
	public static void main(String[] args){
//		String s="      do  not  go gentle  into     that  dark night   ";
//		String s=" 1";
		String s="do  not  go gentle  into     that  dark night   ";
		System.out.println("*"+reverseWords(s)+"*");
	}
	
	public static String reverseWords(String s) {
        String[] sArray=s.split("");
        String word=null;
        StringBuffer answer=new StringBuffer();
        for(String w : sArray){
        	System.out.print(w+", ");
        }
        System.out.println();
        for(int i=sArray.length-1; i>=0; i--){
        	System.out.println("("+i+")="+sArray[i]);
        	if(!sArray[i].equals(" ")){
        		if(word==null){
        			word=sArray[i];
        		}
        		else{
        			word+=sArray[i];
        		}
        	}
        	else{
        		System.out.println("*"+word+"*");
        		if(word!=null){
            		word=reverseWord(word);
            		System.out.println("#"+word+"#");
            		answer.append(word);
        			answer.append(" ");
//            		if(!allSpace(sArray, i-1)){
//            			answer.append(" ");
//            		}
        		}
        		word=null;
        	}
        }
		System.out.println("*"+word+"*");
		if(word!=null){
    		word=reverseWord(word);
    		System.out.println("#"+word+"#");
    		answer.append(word);
		}
        return answer.toString();
    }

	public static boolean allSpace(String[] sArray, int i) {
		System.out.println("allSpace "+sArray[i]+i);
		for(; i>0; i--){
			if(!sArray[i].equals(" ")){
				System.out.println("false");
				return false;
			}
		}
		System.out.println("true");
		return true;
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
