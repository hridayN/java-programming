package DataStructures.Arrays;

import Algorithms.Search;
import Algorithms.Sorting;

public class ArrangementRearrangement {
    public static void main(String[] args) {
        int[] arr = { 3, 0, 4, 2, 5 };
        final long NANOSECONDS = 1000000000;
        //System.out.println("Element exists: " + binarySearch(arr, -1));

        // get the start time
        long start = System.nanoTime();

        arr = rearrangeAsPerIndex(arr);

        // get the end time
        long end = System.nanoTime();

        // execution time
        long execution = end - start;
        double seconds = (double)execution/NANOSECONDS;
        System.out.println("Operation took: " + seconds + " seconds");
        print(arr);
    }

    public static int[] rearrangeAsPerIndex(int[] arr) {
        arr = Sorting.insertionSort(arr);
        int inputLength = arr.length;
        int[] result = new int[inputLength];
        for (int i = 0; i < inputLength; i++) {
            if (i != 0) {
                arr = createSubArray(arr, i, inputLength-1);
            }
            if (Search.binarySearch(arr, i)) {
                result[i] = i;
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static int[] createSubArray(int[] arr, int startIndex, int endIndex) {
        int[] result = new int[endIndex-startIndex+1];
        int counter = result.length-1;
        for (int i = 0; i < result.length; i++, counter--) {
            result[i] = arr[result.length-counter];
        }
        return result;
    }
}
