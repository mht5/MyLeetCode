package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangle_02 {

    public static void main(String[] args) {
        int n = 3;
        List<Integer> row = getRow(n);
        System.out.println(row);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        if (rowIndex == 0) {
            return prev;
        }
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>(i);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }
            row.add(1);
            prev = row;
        }
        return prev;
    }
}
