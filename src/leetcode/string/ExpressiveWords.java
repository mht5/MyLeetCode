package leetcode.string;

/**
 * https://leetcode.com/problems/expressive-words/
 * @time: 3/28/21 4:53 PM
 */
public class ExpressiveWords {

    public static void main(String[] args) {
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        int count = countExpressiveWords(s, words);
        System.out.println(count);
    }

    private static int countExpressiveWords(String S, String[] words) {
        int count = 0;
        char[] target = S.toCharArray();
        for (String word : words) {
            if (word.length() > S.length()) {
                break;
            }
            char[] from = word.toCharArray();
            int i = 0;
            int j = 0;
            boolean match = true;
            while (i < from.length && j < target.length) {
                if (from[i] != target[j]) {
                    break;
                }

                char c = from[i];

                int count1 = 0;
                while (i < from.length && from[i] == c) {
                    count1++;
                    i++;
                }

                int count2 = 0;
                while (j < target.length && target[j] == c) {
                    count2++;
                    j++;
                }

                if (count2 == count1) {
                    continue;
                }
                if (count2 < count1) {
                    match = false;
                    break;
                }
                if (count2 < 3) {
                    match = false;
                    break;
                }
            }
            if (match && i == from.length && j == target.length) {
                count++;
            }
        }
        return count;
    }
}
