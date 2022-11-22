package org.exmaples.permutations;

public class countParenthesis {

    static int count = 0;

    public static int BracketCombinations(int num) {
        // code goes here
        if (num == 1) {
            System.out.print("()");
            return 1;
        }
        computeBracs(num, 0, 0, "");
        return count;
    }

    public static void computeBracs(int num, int open, int close, String str) {
        if (open == num && close == num) {
            System.out.println(str);
            count++;
        }
        if (open < num) {
            computeBracs(num, open+1, close, str+"(");
        }
        if (close < open) {
            computeBracs(num, open, close+1, str+")");
        }
    }

    public static void main(String[] args) {
        // keep this function call here
        System.out.print(BracketCombinations(5));
    }
}
