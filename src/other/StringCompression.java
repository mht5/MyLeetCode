package other;

import java.util.Scanner;

public class StringCompression {

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        String str = input.nextLine();
//        String str = "aabbcccjjaa";
        str = compressString1(str);
        System.out.println(str);
    }

    public static String compressString1(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(count);
                    count = 1;
                }
                sb.append(str.charAt(i));
            }
        }
        if (count > 1) {
            sb.append(count);
        }
        return sb.toString();
    }

    public static String compressString(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i<str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        int index = 0;
        int count = 0;
        for (int i = 0; i <chars.length; i++) {
            if (i + 1 == chars.length || chars[i + 1] != chars[i]) {
                chars[count++] = chars[index];
                if (i > index) {
                    for (char ch : ((i - index + 1) + "").toCharArray()) {
                        chars[count++] = ch;
                    }
                }
                index = i + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
