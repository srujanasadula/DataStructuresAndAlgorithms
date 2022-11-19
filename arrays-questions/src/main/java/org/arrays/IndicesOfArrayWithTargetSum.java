package org.arrays;

import java.util.*;
import java.util.stream.Collectors;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. Return all such pairs
 */
public class IndicesOfArrayWithTargetSum {
    public static void main(String args[]) {
        int[] givenArray = {5, 4, 3, 1, 4, 3, 6, 2};
        //int[] givenArray = {5, 4, 3, 1, 4, 3, 6, 2};
        int sum = 6;
        //Brute force method
        Set<List<Integer>> result = findPairsGivenSumByBruteForce(givenArray, sum);
        if (result.size() == 0)
            System.out.println("No pairs exists for the given sum");
        else
            System.out.println(result);

        result = findPairsGivenSumByExtraMap(givenArray, sum);
        if (result.size() == 0)
            System.out.println("No pairs exists for the given sum");
        else
            System.out.println(result);
    }

    private static Set<List<Integer>> findPairsGivenSumByBruteForce(int[] givenArray, int sum) {
        Set<List<Integer>> pairsOfSum = new HashSet<>();
        for (int i = 0; i < givenArray.length; i++) {
            int number1 = givenArray[i];
            for (int j = i; j < givenArray.length; j++) {
                int number2 = givenArray[j];
                if (number1 + number2 == sum) {

                    //if (i != j) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    if (!pairsOfSum.contains(pair)) pairsOfSum.add(pair);
                    //}
                }
            }
        }
        return pairsOfSum;
    }

    private static Set<List<Integer>> findPairsGivenSumByExtraMap(int[] givenArray, int sum) {
        Set<List<Integer>> pairsOfSum = new HashSet<>();
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < givenArray.length; i++) {
            int number1 = givenArray[i];
            if (hashMap.containsKey(number1)) {
                hashMap.get(number1).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                hashMap.put(number1, indices);
            }
            if (hashMap.containsKey(sum - number1)) {
                List<Integer> indices = hashMap.get(sum - number1);
                int finalI = i;
                Set<List<Integer>> toAdd = indices.stream().map(x -> {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(x);
                    pair.add(finalI);
                    return pair;
                }).collect(Collectors.toSet());
                pairsOfSum.addAll(toAdd);
            }
            if (number1 * 2 == sum) {
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(i);
                if (!pairsOfSum.contains(pair)) pairsOfSum.add(pair);
            }
        }
        return pairsOfSum;
    }

}
