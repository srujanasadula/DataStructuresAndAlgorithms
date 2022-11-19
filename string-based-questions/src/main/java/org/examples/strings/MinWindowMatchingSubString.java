package org.examples.strings;

import java.util.Scanner;

public class MinWindowMatchingSubString {
    public static void main(String args[]) {
            // keep this function call here
            //Scanner s = new Scanner(System.in);
            System.out.print(MinWindowSubstring(new String[]{"ahffaksfajeeubsne", "jefaa"}));

    }
    public static String MinWindowSubstring(String[] strArr) {
        // code goes here
        String largerStr = strArr[0];
        String smallStr = strArr[1] ;
        //Set<Character> charSet = new HashSet<>();
        char[] smallStrArray= smallStr.toCharArray();
        //for(char ch: array) {
        //  charSet.add(ch);
        //}
        System.out.println(smallStrArray);
        int minWindow = smallStr.length();
        System.out.println(minWindow);
        int smallestLen = largerStr.length();
        String foundString = largerStr;
        int i=0;
        int j=minWindow;

        while(j-i>=minWindow && j>=i && i<largerStr.length()) {
            while(j<largerStr.length())
            {
                String subStr = largerStr.substring(i,j);
                boolean found = true;
                for(char ch: smallStrArray) {
                    if(!subStr.contains(ch+"")){
                        found = false;
                        break;
                    }
                }
                if(found) {
                    if(subStr.length()<=smallestLen){
                        foundString = subStr;
                        smallestLen = subStr.length();
                    }
                    break;
                }
                j++;
            }
            i++;
            System.out.println("i" + i);
            System.out.println("j" + j);
        }
        return foundString;
    }
}

/*
import java.util.*;
import java.io.*;

class Main {

  public static String MinWindowSubstring(String[] strArr) {
    String N = strArr[0];
    String K = strArr[1];
    int min = Integer.MAX_VALUE;
    String result = "";
    for (int i = 0; i < N.length(); i++) {
        StringBuilder match = new StringBuilder(K);
        for (int j=i; j < N.length(); j++) {
            if (match.toString().contains(String.valueOf(N.charAt(j)))) {
                int index = match.indexOf(String.valueOf(N.charAt(j)));
                match.replace(index, index + 1, "");
            }

            if (match.length() == 0) {
                if (j - i < min) {
                    min = j - i;
                    result = N.substring(i, j+1);
                }
                break;
            }
        }
    }

        return result;
  }

  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(MinWindowSubstring(s.nextLine()));
  }

}


 private static boolean isSubmultiset(Map<Character, Integer> K, Map<Character, Integer> N) {
        for (Character c : K.keySet()) {
            if (K.get(c) > N.getOrDefault(c, 0)){
                return false;
            }
        }
        return true;
    }

    public static String MinWindowSubstring(String[] strArr) {
        int i = 0;
        int j = 1;
        String N = strArr[0];
        String K = strArr[1];
        Map<Character, Integer> counts = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        String result = N;
        for (Character c : K.toCharArray()) {
            int count = counts.getOrDefault(c, 0);
            count++;
            counts.put(c, count);
        }
        window.put(N.charAt(0), 1);
        while (j <= N.length()) {
            if (i < j && isSubmultiset(counts, window)) {
                if (j-i < result.length()) {
                    result = N.substring(i, j);
                }
                char c = N.charAt(i);
                int val = window.get(c);
                val--;
                window.put(c, val);
                i++;
            } else {
                if (j == N.length()) break;
                char c = N.charAt(j);
                int val = window.getOrDefault(c, 0);
                val++;
                window.put(c, val);
                j++;
            }
        }
        return result;
    }

  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(MinWindowSubstring(s.nextLine()));
  }

}


 */
