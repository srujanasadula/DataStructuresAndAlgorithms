package org.examples.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//input [7,2,6,10,17,3], size of array n = 6 rotate by d = 2
//output [6,10,17,3,7,2]
//2 methods one by GCD and one by reversing strategy
public class RotateArrayLeft {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstMultipleInput = bufferedReader.readLine();
        int d = Integer.parseInt(firstMultipleInput);
        List<Integer> intArray = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(intArray);
        int n = intArray.size();
        if (d > intArray.size()) {
            d = d % n;
        }
        if (d == n)
            System.out.println(intArray);
        else {
            //rotateArrayByLeftByReversing(intArray, n, d);
            rotateArrayByLeftByGCD(intArray, n, d);
        }
    }

    public static void reverseSubArrayList(List<Integer> arrayList, int startIndex, int endIndex) {
        int size = endIndex - startIndex + 1;
        for (int counter = 0; counter < size / 2; counter++) {
            int temp = arrayList.get(startIndex);
            arrayList.set(startIndex, arrayList.get(endIndex));
            arrayList.set(endIndex, temp);
            startIndex++;
            endIndex--;
        }
    }

    public static void rotateArrayByLeftByReversing(List<Integer> intArray, int n, int d) {
        //Reversing the entire array
        reverseSubArrayList(intArray, 0, n - 1);
        System.out.println(intArray);
        reverseSubArrayList(intArray, 0, n - d - 1);
        System.out.println(intArray);
        reverseSubArrayList(intArray, n - d, n - 1);
        System.out.println(intArray);
    }

    public static void rotateArrayByLeftByGCD(List<Integer> intArray, int n, int d) {
        //Reversing the entire array
        //No of times to run the loop
        int counter = GCDOfTwoNumbers.gcd(n, d);
        for (int i = 0; i < counter; i++) {
            //start the inner loop of shifting the elements into their right rotated positions

            int nextIndex = i;
            int temp = intArray.get(nextIndex);
            do {
                nextIndex = nextIndex - d;
                if (nextIndex < 0)
                    nextIndex += n;
                int swapVar = intArray.get(nextIndex);
                intArray.set(nextIndex, temp);
                temp = swapVar;
            } while (i != nextIndex);
            System.out.println(intArray);
        }
        System.out.println(intArray);
    }

}
