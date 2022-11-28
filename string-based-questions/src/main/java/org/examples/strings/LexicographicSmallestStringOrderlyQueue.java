package org.examples.strings;

import java.util.Arrays;
import java.util.Collections;

/*
You are given a string s and an integer k. You can choose any one of the first k letters of s and append it at the end of the string.
Return lexicographically the smallest string you could have after applying the mentioned step any number of moves.
 */
public class LexicographicSmallestStringOrderlyQueue {
    public static void main(String args[]) {
        int k = 9;
        String inputStr = "afajfhasf";
        System.out.println("The lexicographic smallest string is : " + getLexicographicSmallestString(inputStr, k));

    }

    public static String getLexicographicSmallestString(String input, int k) {
        if (k == 1) {
            String smallest = input;
            for (int i = 0; i < input.length(); i++) {
                String temp = input.substring(i + 1) + input.substring(0, i + 1);
                if (temp.compareTo(smallest) < 0) {
                    smallest = temp;
                }
            }
            return smallest;
        } else {
            char[] charArray = input.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        }
    }
    /*
    Algorithm
    If k = 1, only rotations of s are possible, and the answer is the lexicographically smallest rotation.
    If k > 1, any permutation of s is possible, and the answer is the letters of s written in lexicographic order.
    */

}
