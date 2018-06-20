package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * https://leetcode.com/problems/pascals-triangle/description/
 * @author mhts
 *
 */
public class PascalsTriangle {
	public static void main(String[] args){
		int n=5;
		List<List<Integer>> list=generate(n);
		for(List<Integer> l : list){
			System.out.println(l);
		}
	}
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer=new ArrayList<List<Integer>>();
        if(numRows==0){
            return answer;
        }
        List<Integer> sub=new ArrayList<Integer>();
        sub.add(1);
        answer.add(sub);
        for(int i=1; i<numRows; i++){
            List<Integer> list=answer.get(i-1);
            List<Integer> subList=new ArrayList<Integer>();
            subList.add(1);
            for(int j=1; j<i; j++){
                subList.add(list.get(j-1)+list.get(j));
            }
            subList.add(1);
            answer.add(subList);
        }
        return answer;
    }
}
