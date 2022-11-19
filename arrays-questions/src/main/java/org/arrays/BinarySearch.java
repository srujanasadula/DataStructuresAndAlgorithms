package org.arrays;

public class BinarySearch {
    public static void main(String args[]) {
        int[] sortedArr = new int[]{4, 5, 5, 7, 8, 10, 14};
        int search = 20;
        int searchIndex = binarySearchAnyArray(sortedArr, 0, sortedArr.length-1, search);
        if (searchIndex == -1) {
            System.out.println(search + " not found in array");
        } else {
            System.out.println(search + "  found in array at " + searchIndex);
        }

    }

    public static int binarySearchAnyArray(int[] sorted, int startIndex, int endIndex, int search) {
        if (startIndex > endIndex) return -1;
        int mid = (startIndex + endIndex) / 2;
        if (sorted[mid] == search) return mid;
        else if (sorted[mid] > search)  return binarySearchAnyArray(sorted, startIndex, mid, search);
        else return binarySearchAnyArray(sorted, mid + 1, endIndex, search);
    }
}
