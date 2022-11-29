package Basics;

import static Algorithms.Sorting.quickSort_Sorting;

public class Arrays {
    public static void main(String[] args) {
        /*int[] arr = {1, 5, 2};
        System.out.println(String.format("Expected: %d, actual: %d",  1, peakElement(arr, arr.length)));
        int[] arr1 = {5, 1, 2};
        System.out.println(String.format("Expected: %d, actual: %d",  0, peakElement(arr1, arr1.length)));
        int[] arr2 = {2, 1, 5};
        System.out.println(String.format("Expected: %d, actual: %d",  2, peakElement(arr2, arr2.length)));*/
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(String.format("%dth smallest element: %d", 3, kthSmallest(arr, 0, arr.length-1, 2)));
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    public static int peakElement(int[] arr,int n) {
        int peakElementIndex = 0, peakElement = arr[0];
        for (int j = 1; j < n; j++) {
            if (arr[j-1] < arr[j] && arr[j] > peakElement) {
                peakElementIndex = j;
                peakElement = arr[j];
            }
        }

        return peakElementIndex;
    }

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        // Sort the array, and return kth element from sorted array
        printArray(arr);
        quickSort_Sorting(arr, l, r);
        printArray(arr);
        return arr[k];
    }

    public static void swapInArray(int[] arr, int sourceIndex, int destinationIndex) {
        int temp = arr[sourceIndex];
        arr[sourceIndex] = arr[destinationIndex];
        arr[destinationIndex] = temp;
    }
}
