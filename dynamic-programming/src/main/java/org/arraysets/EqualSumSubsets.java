package org.arraysets;

/* Set partition problem*/
/*
Just finds if Set can be partitioned
 */
public class EqualSumSubsets {
    public static void main(String args[]) {
        int arr[] = { 3, 1, 5, 9, 12 };
        int n = arr.length;

        if (findPartition(arr, n) == true)
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
        return containsSubsetsWithSum(arr, n, sum / 2);
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
            return containsSubsetsWithSum(arr,n-1, sum);
        /*
        Otherwise consider a subset without including that element and may be equal to sum
        or a subset with including that element and other subset elements is equal to (sum - that element)
         */
        return containsSubsetsWithSum(arr,n-1, sum)
                || containsSubsetsWithSum(arr, n-1, sum - arr[n-1]);

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
    Using dynamic programming
    Here we should actually solve O(sum*N) sub problems. But sub problem computations are repeated due to recursion
    and possible exploration of all subsets.
    Using memoization reduce the time complexity to O(sum*n). Because those many sub problems to solve
    Space Complexity also O(sum*n)
     */
}
