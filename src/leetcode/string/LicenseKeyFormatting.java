package leetcode.string;

/**
 * https://leetcode.com/problems/license-key-formatting/
 * @time: 4/18/21 5:05 PM
 */
public class LicenseKeyFormatting {

    public static void main(String[] args) {
        String s = "2-5g-3-J";
        int k = 2;
        System.out.println(licenseKeyFormatting1(s, k));
    }

    public static String licenseKeyFormatting1(String s, int k) {
        int index = s.length() * 2;
        char[] result = new char[index + 1];
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                if (count % k == 0 && count != 0) {
                    result[index--] = '-';
                }
                if (c >= 'a' && c <= 'z') {
                    result[index] = (char) (c - 32);
                } else {
                    result[index] = c;
                }
                index--;
                count++;
            }
        }
        return new String(result, index + 1, result.length - index - 1);
    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int val = chars[i];
            if (val == '-') {
                continue;
            } else {
                if (val >= 'a' && val <= 'z') {
                    val -= 32;
                }
                sb.insert(0, (char) val);
                if (++count == k) {
                    sb.insert(0, '-');
                    count = 0;
                }
            }
        }
        if (sb.length() > 0 && count == 0) {
            return sb.substring(1);
        }
        return sb.toString();
    }
}
