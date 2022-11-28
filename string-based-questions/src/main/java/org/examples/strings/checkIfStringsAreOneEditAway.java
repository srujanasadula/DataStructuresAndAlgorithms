package org.examples.strings;

public class checkIfStringsAreOneEditAway {
    //pale, bale is one replacement away
    //apple and aple is one removal or one insertion away

    public static void main(String args[]) {
        String s1 = "pale";
        String s2 = "aable";

        if (s1.length() == s2.length()) {
            System.out.println(checkIfStringsAreOneReplacementAway(s1, s2));
        } else if (s1.length() + 1 == s2.length()) {
            System.out.println(checkIfStringsAreOneInsertionAway(s1, s2));
        } else if (s1.length() - 1 == s2.length()) {
            System.out.println(checkIfStringsAreOneInsertionAway(s2, s1));
        } else
            System.out.println(false);
    }

    private static boolean checkIfStringsAreOneInsertionAway(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) return false;
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private static boolean checkIfStringsAreOneReplacementAway(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) return false;
                foundDifference = true;
            }
        }
        return true;
    }


}
