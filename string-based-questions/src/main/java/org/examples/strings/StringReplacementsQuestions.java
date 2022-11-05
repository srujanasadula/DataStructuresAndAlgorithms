package org.examples.strings;

public class StringReplacementsQuestions {
    public static void main(String[] args) {
        substituteSpaces("my name is John         ", 15);
    }

    public static void substituteSpaces(String input, int trueLength) {
        char[] charStringArr = input.toCharArray();
        System.out.println("Substituted String:" + new String(charStringArr));
        int middleIndex = trueLength - 1;
        if (input.length() < trueLength) {
            System.out.println("Could not substitute");
            System.exit(1);
        }
        int noOfSpaces = 0;
        int i = 0;
        for (i = input.length() - 1; i >= 0 && middleIndex >= 0; i--) {
            if (charStringArr[middleIndex] == ' ') {
                charStringArr[i] = '0';
                charStringArr[i - 1] = '2';
                charStringArr[i - 2] = '%';
                i = i - 2;
                middleIndex--;
                noOfSpaces++;
            } else {
                charStringArr[i] = charStringArr[middleIndex];
                middleIndex--;
            }
        }
        if (i == middleIndex)
            System.out.println("Substituted String:" + new String(charStringArr));
        else {
            System.out.println("No of spaces calculated from true length backwards is:" + noOfSpaces);
            System.out.println("String input length:" + input.length());
            System.out.println("So could not do substitution. True length may be incorrect");
        }
    }
}
