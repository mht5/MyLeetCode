package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 * @time: 4/17/21 8:35 PM
 */
public class FractionToRecurringDecimal {

    public static void main(String[] args) {
        int numerator = 1;
        int denominator = 6;
        System.out.println(fractionToDecimal(numerator, denominator));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) {
            return "0";
        }
        long num = Long.valueOf(numerator);
        long deno = Long.valueOf(denominator);
        boolean isNegative = false;
        if (num < 0) {
            isNegative = !isNegative;
            num = Math.abs(num);
        }
        if (deno < 0) {
            isNegative = !isNegative;
            deno = Math.abs(deno);
        }
        long intValue = num / deno;
        long mod = num % deno;
        StringBuilder result = new StringBuilder(isNegative ? "-" : "");
        result.append(intValue);
        if (mod > 0) {
            result.append(".");
            StringBuilder decimalStr = new StringBuilder();
            Map<Long, Integer> map = new HashMap<>();
            while (mod != 0) {
                if (map.containsKey(mod)) {
                    decimalStr.append(")");
                    decimalStr.insert(map.get(mod), "(");
                    break;
                }
                map.put(mod, decimalStr.length());
                mod *= 10;
                intValue = mod / deno;
                mod = mod % deno;
                decimalStr.append(Math.abs(intValue));
            }
            result.append(decimalStr);
        }
        return result.toString();
    }
}
