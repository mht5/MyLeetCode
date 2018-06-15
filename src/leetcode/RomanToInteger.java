package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author mhts
 *
 */
public class RomanToInteger {
	public static void main(String[] args){
		String s="DCXXI";
		System.out.println(romanToInt(s));
	}
	
	public static int romanToInt(String s) {
        Map<Character, Integer> map=new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int number=map.get(s.charAt(s.length()-1));
        for(int i=s.length()-1; i>0; i--){
        	if(map.get(s.charAt(i-1)) < map.get(s.charAt(i))){
        		number-=map.get(s.charAt(i-1));
        	}
        	else{
        		number+=map.get(s.charAt(i-1));
        	}
        }
        return number;
    }
}
