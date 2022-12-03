package org.examples.strings;

public class LongestPrefixThatIsSuffixLengthArray {
    public static void main(String args[]) {
        String s = "afkaslfasaf";
        System.out.println(getLPSArray(s));
        //Check number of characters to add at the front to make a string palindrome;
        String str = "abcbade";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("$");
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        System.out.println("TotalString:" + stringBuilder.toString());
        int LPS[] = getLPSArray(stringBuilder.toString());
        System.out.println(str.length() - LPS[2 * str.length()]);

        //Check number of characters to add at the end to make a string palindrome;
        String input = "abac";
        stringBuilder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            stringBuilder.append(input.charAt(i));
        }
        stringBuilder.append("$");
        stringBuilder.append(input);

        System.out.println("TotalString:" + stringBuilder);
        LPS = getLPSArray(stringBuilder.toString());
        System.out.println(input.length() - LPS[2 * input.length()]);

        //Check no of occurrences of a pattern in a string
        String pattern = "ab";
        String main = "abcdefab";
        StringBuilder builder = new StringBuilder();
        builder.append(pattern);
        builder.append("S");
        builder.append(main);
        LPS = getLPSArray(builder.toString());
        int count = 0;
        for (int i = 0; i < LPS.length; i++) {
            if (LPS[i] == pattern.length()) count++;
        }
        System.out.println("Pattern:" + pattern + " is found #" + count + " times");
    }

    public static int[] getLPSArray(String str) {
        int i = 0;
        int[] LPS = new int[str.length()];
        for (i = 1; i < str.length(); i++) {
            int next = LPS[i - 1];
            while (str.charAt(i) != str.charAt(next)) {
                if (next == 0) {
                    next = -1;
                    break;
                }
                next = LPS[next - 1];
            }
            LPS[i] = next + 1;
            System.out.println("For " + i + ": " + LPS[i]);
        }
        return LPS;
    }
}
