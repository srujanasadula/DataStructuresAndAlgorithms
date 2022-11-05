package org.examples.strings;

public class CheckStringHasUniqueChars {
    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.println(ifUniqueCharsString(args[0]));
            System.out.println(ifUniqueCharsStringNoDs(args[0]));
            //System.out.println(ifUniqueCharsString("asde g"));
            //System.out.println(ifUniqueCharsStringNoDs("asde g"));
        } else {
            System.out.println("Please enter a ascii string has input argument");
        }
    }
    /*
    This method checks the input string is made of all unique characters
     */
    private static boolean ifUniqueCharsString(String input) {
        System.out.println(input);
        if (input.length() > 128)
            return false;
        else {
            boolean[] checker = new boolean[128];
            for (int c : input.toCharArray()) {
                System.out.println("character:" + (char) c);
                if (checker[c]) return false;
                checker[c] = true;
            }
        }
        return true;
    }

    //This method checks the input string is made of all unique characters - Without using additional data structure
    private static boolean ifUniqueCharsStringNoDs(String input) {
        System.out.println(input);
        if (input.length() > 128)
            return false;
        else {
            int checker = 0;
            for (int c : input.toCharArray()) {
                int check = c - 'a';
                System.out.println("character:" + (char) c);
                System.out.println("shifted bit:" + (1 << check));
                if ((checker & (1 << check)) > 0) {
                    return false;
                }
                checker |= (1 << check);
                System.out.println("checker:" +  checker);
            }
        }
        return true;
    }

}