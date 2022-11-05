package org.arrays;

public class GCDOfTwoNumbers {
    public static void main(String args[]) {
        int a = 7;
        int b = 15;
        System.out.println(gcd(a, b));
    }

    public static int gcd(int a, int b) {
        if (b > a) {
            //Swapping 2 varaibles in place
            a = a + b;
            b = a - b;
            a = a - b;
        }
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
