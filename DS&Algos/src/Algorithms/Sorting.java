package Algorithms;

public class Sorting {
    public static void main(String[] args){
        int[] arr = {4, 2, 7, 1, 3};
        //arr = bubbleSort(arr);
        //arr = selectionSort(arr);
        arr = insertionSort(arr);
        //print(arr);
        /*int a = 5, b = 7;
        System.out.println("Before swapping, a: " + a + ", b: " + b);
        swap(a, b);
        System.out.println("After swapping, a: " + a + ", b: " + b);*/
        // quickSort(arr, 0, arr.length-1);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static int[] bubbleSort(int[] arr) {
        int passThrough = 0, comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            int swaps = 0;
            System.out.println("Passthrough " + ++passThrough);
            for (int j = 0; j < arr.length - passThrough; j++) {
                System.out.println("Comparing (" + arr[j] + ", " + arr[j+1] + ")");
                comparisons++;
                if (arr[j] > arr[j+1]) {
                    arr[j] = arr[j]-arr[j+1];
                    arr[j+1] = arr[j]+arr[j+1];
                    arr[j] = arr[j+1]-arr[j];
                    swaps++;
                }
            }

            // if no swaps are performed, means array is sorted
            if (swaps == 0) {
                System.out.println("Total Comparisons: " + comparisons);
                return arr;
            }
        }
        System.out.println("Total Comparisons: " + comparisons);
        return arr;
    }

    //Selection Sort is 2x faster than Bubble Sort
    //with data that is mostly sorted in reverse order, Selection Sort will be faster
    public static int[] selectionSort(int[] arr) {
        // Principle: Smallest value will be placed at starting index in every subsequent pass
        // Step 1: Determine the lowest value in the array
        // Step 2: Swap the lowest value and smallest value after every pass
        long startTime = System.currentTimeMillis();
        int passThrough = 0, comparisons = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int smallestValueIndex = i;
            System.out.println("\n" + (i+1) +  "th Pass");
            for (int j = i+1; j < arr.length; j++) {
                System.out.println("Compared (" + arr[smallestValueIndex] + ", " + arr[j] + ")");
                comparisons++;
                if (arr[smallestValueIndex] > arr[j]) {
                    smallestValueIndex = j;
                }
            }

            // If smallestValueIndex is updated, swap the values
            if (i != smallestValueIndex) {
                arr[i] = arr[i] - arr[smallestValueIndex];
                arr[smallestValueIndex] = arr[i] + arr[smallestValueIndex];
                arr[i] = arr[smallestValueIndex] - arr[i];
            }
            passThrough++;
            System.out.println("Smallest: " + arr[i]);
            print(arr);
        }
        /*for (int i = 0; i < arr.length-1; i++) {
            int smallestValueIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[smallestValueIndex]) {
                    smallestValueIndex = j;
                }
            }

            if (i != smallestValueIndex) {
                arr[i] = arr[i] - arr[smallestValueIndex];
                arr[smallestValueIndex] = arr[i] + arr[smallestValueIndex];
                arr[i] = arr[smallestValueIndex] - arr[i];
            }
        }*/

        System.out.println("Total Comparisons: " + comparisons);
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in seconds: " + timeElapsed);
        return arr;
    }

    //Best in case of mostly sorted array
    public static int[] insertionSort(int[] arr) {
        int comparisons = 0, pass = 0;
        for(int i = 1; i < arr.length; i++){
            pass++;
            System.out.println("Passthrough: " + pass);
            int temp = arr[i], gapIndex = i;
            for (int j = i-1; j >= 0; j--) {
                System.out.println("Comparing (" + arr[j] + ", " + temp + ")");
                comparisons++;
                if (arr[j] > temp){
                    // shift arr[j] to right
                    arr[j+1] = arr[j];
                    // update gap
                    gapIndex = j;
                }
                // If current element is less than temp, start next pass
                if (arr[j] <= temp) {
                    break;
                }
            }
            arr[gapIndex] = temp;
        }
        System.out.println("Total comparisons: " + comparisons);
        return arr;
    }

    public static int getLowestValue(int[] arr) {
        int lowest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (lowest < arr[i]) {
                lowest = arr[i];
            }
        }
        return lowest;
    }

    public static int getLargestValue(int[] arr) {
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static int getLowestValueIndex(int[] arr) {
        int lowestIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (lowestIndex < arr[i]) {
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    // doesn't work for arrays
    public static void swap(int a, int b) {
        a = a+b;
        b = a-b;
        a = a-b;
    }

    public static int getItself(int itself, int dummy) {
        return itself;
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = partition(arr, startIndex, endIndex);
            quickSort(arr, startIndex, pivotIndex-1);
            quickSort(arr, pivotIndex+1, endIndex);
        }
    }

    /* Principle: at the end, all elements smaller than pivot will be to the left of pivot and
    * larger will be to the right of the pivot
    */
    public static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex], left = startIndex-1;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] <= pivot) {
                left++;
                arr[i] = getItself(arr[left], arr[left] = arr[i]);
            }
        }

        arr[endIndex] = getItself(arr[left+1], arr[left+1]=arr[endIndex]);
        return left+1;
    }
}
