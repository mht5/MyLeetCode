package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * @time: 4/24/21 8:03 PM
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);
        for (List<String> list : result) {
            for (String str : list) {
                System.out.printf("%s\t", str);
            }
            System.out.println();
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int length = s.length();
        int index = 0;
        List<String> tempList = new ArrayList<>();
        getPartitions(s, result, tempList, length, index);
        return result;
    }

    private static void getPartitions(String s, List<List<String>> result,
                                      List<String> tempList, int length, int index) {
        if (index == length) {
            result.add(new ArrayList<>(tempList));
        }
        for (int i = index; i < length; i++) {
            if (isPalindrome(s, index, i)) {
                tempList.add(s.substring(index, i + 1));
                getPartitions(s, result, tempList, length, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int from, int to) {
        while (from < to) {
            if (s.charAt(from) != s.charAt(to)) {
                return false;
            }
            from++;
            to--;
        }
        return true;
    }
}
