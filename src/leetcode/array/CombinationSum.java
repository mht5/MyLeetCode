package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * @time: 4/27/21 9:18 PM
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(candidates, target);
        for (List<Integer> list : combinations) {
            for (Integer i : list) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);
        getCombinations(result, tempList, candidates, target, 0);
        return result;
    }

    private static void getCombinations(List<List<Integer>> result, List<Integer> tempList,
                                        int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    tempList.add(candidates[i]);
                    getCombinations(result, tempList, candidates, target - candidates[i], i);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
