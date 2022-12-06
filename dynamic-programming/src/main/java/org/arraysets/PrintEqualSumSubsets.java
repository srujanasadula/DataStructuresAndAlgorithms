package org.arraysets;

import java.util.ArrayList;
import java.util.List;

public class PrintEqualSumSubsets {
    static List<Integer> set1 = new ArrayList<>();
    static List<Integer> set2 = new ArrayList<>();

    public static void main(String args[]) {
        int[] arr = { 5, 5, 1, 11 };
        int n = arr.length;
        if (findPositions(arr, n) == false) {
            System.out.print("-1");
        }
    }

    public static boolean findPositions(int[] arr, int n) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        if (sum % 2 != 0) return false;
        return findSubsets(arr, n, 0, 0, 0);

    }

    public static boolean findSubsets(int[] arr, int n, int sum1, int sum2, int pos) {
        if (pos == n) {
            if (sum1 == sum2) {
                printSets();
                return true;
            }
            return false;

        }
        set1.add(arr[pos]);
        boolean res = findSubsets(arr, n, sum1 + arr[pos], sum2, pos + 1);
        if (res) {
            return res;
        } else {
            set1.remove(set1.size() - 1);
            set2.add(arr[pos]);
            res = findSubsets(arr, n, sum1, sum2 + arr[pos], pos + 1);
            if (res == false) {
                set2.remove(set2.size() - 1);
            }
            return res;
        }

    }

    private static void printSets() {
        for(int i :set1) {
            System.out.print(i + ",");
        }
        System.out.println();
        for(int i :set2) {
            System.out.print(i + ",");
        }
        System.out.println(set1);
        System.out.println(set2);
    }
}
