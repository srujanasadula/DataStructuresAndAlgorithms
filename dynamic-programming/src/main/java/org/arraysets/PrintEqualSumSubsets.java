package org.arraysets;

import java.util.ArrayList;
import java.util.List;

public class PrintEqualSumSubsets {
    static List<Integer> set1 = new ArrayList<>();
    static List<Integer> set2 = new ArrayList<>();

    public static void main(String args[]) {
        int[] arr = {5, 5, 1, 11};
        int n = arr.length;
        if (findPositions(arr, n) == false) {
            System.out.print("-1");
        }
         set1 = new ArrayList<>();
        set2 = new ArrayList<>();
        int arr1[] = { 3, 1, 1, 2, 2, 1 };
        findSetsByTabularApproach(arr1, 6);
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
            if (!res) {
                set2.remove(set2.size() - 1);
            }
            return res;
        }

    }

    private static void printSets() {
        for (int i : set1) {
            System.out.print(i + ",");
        }
        System.out.println();
        for (int i : set2) {
            System.out.print(i + ",");
        }
        System.out.println(set1);
        System.out.println(set2);
    }
    /*
    Using dynamic programming top-down approach using memoization
     */

    public static void findSetsByTabularApproach(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        if ((sum & 1) == 1) {
            System.out.println("Cannot find equal sum subsets");

        }
        int finalSum = sum >> 1;
        boolean dp[][] = new boolean[finalSum + 1][n + 1];
        for (int s = 0; s <= finalSum; s++) {
            dp[s][0] = false;
        }
        for (int k = 0; k <= n; k++) {
            dp[0][k] = true;
        }
        for (int s = 1; s <= finalSum; s++) {
            for (int k = 1; k <= n; k++) {
                dp[s][k] = dp[s][k - 1];
                if (arr[k - 1] <= s) {
                    dp[s][k] = dp[s][k-1] || dp[s - arr[k - 1]][k - 1];
                }
            }
        }
        if (!dp[finalSum][n]) {
            System.out.print("Cannot be divided into subsets of equal sum");
            return;
        }
        int i = n;
        int curSum = finalSum;
        while (i > 0 && curSum >= 0) {
            //If current element does not contribute curSum, then it belongs to set
            if(dp[curSum][i-1]){
                i--;
                set2.add(arr[i]);
            }else if(dp[curSum-arr[i-1]][i-1]){
                i--;
                set1.add(arr[i]);
                curSum = curSum-arr[i];
            }
        }
        printSets();
    }
}
