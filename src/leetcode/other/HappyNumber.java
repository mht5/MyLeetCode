package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, 
 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
 * Those numbers for which this process ends in 1 are happy numbers.
 * https://leetcode.com/problems/happy-number/description/
 * @author mhts
 *
 */
public class HappyNumber {
	static List<Integer> list=new ArrayList<Integer>();
	
	public static void main(String[] args){
		int n=12;
		System.out.println(isHappy(n));
	}

    public static boolean isHappy(int n) {
    	if(n<1){
    		return false;
    	}
        if(n==1){
        	return true;
        }
        list.add(n);
        int sum=0;
        while(n>0){
        	sum+=Math.pow(n%10, 2);
        	n/=10;
        }
        if(list.contains(sum)){
            return false;
        }
        return isHappy(sum);
    }
}
