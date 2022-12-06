package org.arraysets;

import java.util.Arrays;

/* Set partition problem*/
/*
Just finds if Set can be partitioned
 */
public class EqualSumSubsets {
    public static void main(String args[]) {
        int arr[] = {3, 1, 5, 9, 12};
        int n = arr.length;

        if (findPartition(arr, n))
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println(
                    "Can not be divided into two subsets of equal sum");

        int arr1[] = { 3, 1, 1, 2, 2, 1 };
         n = arr1.length;
        if (findPartitionByTabularApproach(arr1, n))
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println(
                    "Can not be divided into two subsets of equal sum");

        int arr2[] =  { 3, 1, 5, 9, 14 };
        n = arr2.length;
        if (findPartitionByTabularApproach(arr2, n))
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println(
                    "Can not be divided into two subsets of equal sum");
    }

    public static boolean findPartition(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        //return containsSubsetsWithSum(arr, n, sum / 2);
        int dp[][] = new int[sum + 1][n + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return containsSubsetsWithSumUsingMemoization(arr, n, sum / 2, dp) != 0;
    }

    /* Complexity is exponential 2^n, because it explores all subsets possible, and there are 2^n subsets for n elements
    And at any point of time stack space used is O(N) so is the space complexity
     */
    public static boolean containsSubsetsWithSum(int arr[], int n, int sum) {
        if (sum == 0) return true;
        if (n == 0 && sum != 0) {
            return false;
        }
        /*
        If the current element itself is grater than required sum, then dont consider that element in subset
         */
        if (arr[n - 1] > sum)
            return containsSubsetsWithSum(arr, n - 1, sum);
        /*
        Otherwise consider a subset without including that element and may be equal to sum
        or a subset with including that element and other subset elements is equal to (sum - that element)
         */
        return containsSubsetsWithSum(arr, n - 1, sum)
                || containsSubsetsWithSum(arr, n - 1, sum - arr[n - 1]);

    }

    /*
    --Dynamic programming is a technique for solving problems of recursive nature, iteratively and
     is applicable when the computations of the sub problems overlap.
      break the complex problem into smaller problems. It can be top0down approach or bottom up approach
   -- Dynamic programming is typically implemented using tabulation, but can also be implemented using memoization.
    So as you can see, neither one is a "subset" of the other.
    ---Memoization is a term describing an optimization technique where you cache previously computed results,
    and return the cached result when the same computation is needed again.
   -- Memoization (Top Down) - Using recursion to solve the sub-problem and storing the result in some hash table.
    --Tabulation (Bottom Up) - Using Iterative approach to solve the problem by solving the smaller sub-problems first
    and then using it during the execution of bigger problem.
     */

    /*
    Using dynamic programming, we break into sub problem
    For given sol(sum, n), all possible sub problems are sol(0....sum, 0..n)
    Here we should actually solve O(sum*N) sub problems. But sub problem computations are repeated
     due to recursion, so we cache the result of a sub problem when computed
    Using memoization reduce the time complexity to O(sum*n). Because those many sub problems to solve
    Space Complexity also O(sum*n)
     */
    public static int containsSubsetsWithSumUsingMemoization(int[] arr, int n, int sum, int[][] dp) {
        if (sum == 0) return 1;
        if (n == 0 && sum != 0) {
            return 0;
        }
        if (dp[sum][n] != -1) return dp[sum][n];
        /*
        If the current element itself is grater than required sum, then dont consider that element in subset
         */
        if (arr[n - 1] > sum)
            return containsSubsetsWithSumUsingMemoization(arr, n - 1, sum, dp);
        /*
        Otherwise consider a subset without including that element and may be equal to sum
        or a subset with including that element and other subset elements is equal to (sum - that element)
         */
        if (containsSubsetsWithSumUsingMemoization(arr, n - 1, sum, dp) != 0
                || containsSubsetsWithSumUsingMemoization(arr, n - 1, sum - arr[n - 1], dp) != 0) {
            return dp[sum][n] = 1;
        }
        return dp[sum][n] = 0;

    }

    //Using dynamic programming tabular bottom up approach
    public static boolean findPartitionByTabularApproach(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] dp = new boolean[sum / 2 + 1][n + 1];
        for (int s = 0; s <= sum / 2; s++) {
            dp[s][0] = false;
        }
        for (int k = 0; k <=n ; k++) {
            dp[0][k] = true;
        }
        for(int s=1;s<=sum/2;s++) {
            for(int k=1;k<=n;k++){
                dp[s][k] = dp[s][k-1];
                if(arr[k-1] <=s){
                    dp[s][k] = dp[s][k-1] || dp[s-arr[k-1]][k-1];
                }
            }
        }
        return dp[sum/2][n];
    }

}
