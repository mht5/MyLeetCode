package leetcode.other;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * https://leetcode.com/problems/climbing-stairs/description/
 * @author mhts
 *
 */
public class ClimbingStairs {
	public static void main(String[] args){
		int n=123432;
		System.out.println(climbStairs(n));
	}

    public static int climbStairs(int n) {
       if(n<=2){
        	return n;
        }
       int[] count=new int[n];
       count[0]=1;
       count[1]=2;
       for(int i=2; i<n ;i++){
    	   count[i]=count[i-1]+count[i-2];
       }
        return count[n-1];
    }
}
