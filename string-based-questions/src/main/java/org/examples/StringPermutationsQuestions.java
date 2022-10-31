package org.examples;

import java.util.Arrays;

public class StringPermutationsQuestions {
    public static void main(String args[]) {
        String input1 = "Bsas";
        String input2 = "sas    BS";
        System.out.println(ifStringsArePermutations(input1, input2));
        System.out.println(ifStringsArePermutations2(input1, input2));
    }

    //This method checks if the given string has a permutation that is a palindrome
    //This approach ignores whitespaces and assumes ascii
    public static boolean ifStringPermutationIsPalindrome(String input) {
        int[] charArray = new int[128];
        for(char c: input.toCharArray()) {
            charArray[c]++;
        }
        for(int c: charArray[])
        return false;
    }

    // This method checks if one string is a permutation of other string
    public static boolean ifStringsArePermutations(String input1, String input2) {
        input1 = cleanUpString(input1);
        input2 = cleanUpString(input2);
        System.out.println(input1);
        System.out.println(input2);
        if (input1.length() != input2.length())
            return false;
        else {
            return sortString(input1.toLowerCase()).equals(sortString(input2.toLowerCase()));
        }
    }

    //Uses additional space
    // This method checks if one string is a permutation of other using 128 char
    public static boolean ifStringsArePermutations2(String input1, String input2) {
        input1 = cleanUpString(input1);
        input2 = cleanUpString(input2);
        System.out.println(input1);
        System.out.println(input2);
        if (input1.length() != input2.length())
            return false;
        else {
            int[] input1CharsLengths = new int[128];
            for (int c : input1.toCharArray()) {
                input1CharsLengths[c]++;
            }
            for (int c : input2.toCharArray()) {
                input1CharsLengths[c]--;
                if (input1CharsLengths[c] < 0)
                    return false;
            }
        }
        return true;
    }

    /*
    Cleans up spaces inside the string
     */
    public static String cleanUpString(String input) {
        StringBuilder builderString = new StringBuilder();
        if (input == null) return null;
        String trimmedString = input.trim();
        if (trimmedString.length() == 0) return "";
        for (char c : trimmedString.toCharArray()) {
            if (c != '\t' && c != ' ')  // \t  not required, because in strings, \t is encoded as 4 space characters
                builderString.append(c);
        }
        return builderString.toString();
    }

    public static String sortString(String input) {
        char[] stringArray = input.toCharArray();
        Arrays.sort(stringArray);
        return new String(stringArray);
    }

}