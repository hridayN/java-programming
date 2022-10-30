package Algorithms;

public class Sorting {
    public static void main(String[] args) {
        //int[] arr = {7, 8, 3, 1, 2};
        /*// arr = bubbleSort(arr);
        // arr = bubbleSortUsingWhile(arr);*/
        /*// arr = selectionSort(arr);
        // arr = selectionSortUsingWhile(arr);*/

        /*arr = insertionSort(arr);
        arr = insertionSortUsingWhile(arr);*/
        //print(arr);
        /*int a = 5, b = 7;
        System.out.println("Before swapping, a: " + a + ", b: " + b);
        swap(a, b);
        System.out.println("After swapping, a: " + a + ", b: " + b);*/
        // quickSort(arr, 0, arr.length-1);
        /*int[] temp = new int[arr.length];
        mergeSortDivide(arr, temp, 0, arr.length - 1);*/
        /*int[] arr = {9, -3, 2, 5, 9, 6, 8, -6, 1, 8};
        //System.out.println(quickSort_Partition(arr, 0, arr.length - 1));
        quickSort_Sorting(arr, 0, arr.length - 1);*/

        int[] arr = { -4, -1, 0, 3, 10 };
        sortQuaresArray(arr);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    // Principle: Compare each element with it's next and take the largest element to last in every iteration
    public static int[] bubbleSort(int[] arr) {
        int passThrough = 0, comparisons = 0;
        // Outer loop will run as many times as there are elements in the array
        for (int i = 0; i < arr.length; i++) {
            int swaps = 0;
            System.out.println("Passthrough " + ++passThrough);
            /*Inner loop will run elements-sortedElements many times as there are elements in the array
             * arr.length - passThrough: it indicates no. of the unsorted elements
             */
            for (int j = 0; j < arr.length - passThrough; j++) {
                System.out.println("Comparing (" + arr[j] + ", " + arr[j + 1] + ")");
                comparisons++;
                // If current element is greater than it's next element, swap both
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] - arr[j + 1];
                    arr[j + 1] = arr[j] + arr[j + 1];
                    arr[j] = arr[j + 1] - arr[j];
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
        //long startTime = System.currentTimeMillis();
        int passThrough = 0, comparisons = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int smallestValueIndex = i, swaps = 0;
            System.out.println("\n" + (i + 1) + "th Pass");
            for (int j = i + 1; j < arr.length; j++) {
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
                swaps++;
            }
            passThrough++;
            System.out.println("Smallest: " + arr[i]);
            print(arr);

            // if no swaps are performed, means array is sorted
            if (swaps == 0) {
                System.out.println("Total Comparisons: " + comparisons);
                return arr;
            }
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
        /*long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in seconds: " + timeElapsed);*/
        return arr;
    }

    //Best in case of mostly sorted array
    public static int[] insertionSort(int[] arr) {
        int comparisons = 0, pass = 0;
        for (int i = 1; i < arr.length; i++) {
            pass++;
            System.out.println("Passthrough: " + pass);
            int temp = arr[i], gapIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                System.out.println("Comparing (" + arr[j] + ", " + temp + ")");
                comparisons++;
                if (arr[j] > temp) {
                    // shift arr[j] to right
                    arr[j + 1] = arr[j];
                    // update gap
                    gapIndex = j;
                    System.out.println(String.format("Gap created at: %d index", gapIndex));
                }
                // If current element is less than temp, start next pass
                else break;

                /*if (arr[j] <= temp) {
                    break;
                }*/
            }
            arr[gapIndex] = temp;
            print(arr);
            System.out.println();
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
        a = a + b;
        b = a - b;
        a = a - b;
    }

    public static int getItself(int itself, int dummy) {
        return itself;
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = partition(arr, startIndex, endIndex);
            quickSort(arr, startIndex, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, endIndex);
        }
    }

    /* Principle: at the end, all elements smaller than pivot will be to the left of pivot and
     * larger will be to the right of the pivot
     */
    public static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex], left = startIndex - 1;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] <= pivot) {
                left++;
                arr[i] = getItself(arr[left], arr[left] = arr[i]);
            }
        }

        arr[endIndex] = getItself(arr[left + 1], arr[left + 1] = arr[endIndex]);
        return left + 1;
    }

    public static int[] bubbleSortUsingWhile(int[] arr) {
        int counter = 1;
        while (counter < arr.length) {
            int swaps = 0, j = 0;
            while (j < arr.length - counter) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
                j++;
            }
            if (swaps == 0) return arr;
            counter++;
        }
        return arr;
    }

    public static int[] selectionSortUsingWhile(int[] arr) {
        int counter = 0;
        while (counter < arr.length - 1) {
            int smallestValueIndex = counter, swaps = 0, innerCounter = counter + 1;
            while (innerCounter < arr.length) {
                if (arr[smallestValueIndex] > arr[innerCounter]) {
                    smallestValueIndex = innerCounter;
                }
                if (smallestValueIndex != counter) {
                    int temp = arr[smallestValueIndex];
                    arr[smallestValueIndex] = arr[counter];
                    arr[counter] = temp;
                    swaps++;
                }
                innerCounter++;
            }
            if (swaps == 0) return arr;
            counter++;
        }
        return arr;
    }

    public static int[] insertionSortUsingWhile(int[] arr) {
        int counter = 1;
        while (counter < arr.length) {
            int gapIndex = counter, temp = arr[counter], innerCounter = counter - 1;
            while (innerCounter >= 0) {
                if (arr[innerCounter] > temp) {
                    arr[innerCounter + 1] = arr[innerCounter];
                    gapIndex = innerCounter;
                } else break;
                innerCounter--;
            }
            arr[gapIndex] = temp;
            counter++;
        }
        return arr;
    }

    /*
     * This method is the Divide part of our Divide & Conquer approach
     * Here, we'll keep dividing the array till it contains only 1 element.
     * Then, in the Conquer part, we'll keep Sorting & Merging these unsorted parts
     */
    public static void mergeSortDivide(int[] arr, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSortDivide(arr, temp, low, mid);
            mergeSortDivide(arr, temp, mid + 1, high);
            mergeSortConquer(arr, temp, low, mid, high);
        }
    }

    public static void mergeSortConquer(int[] arr, int[] temp, int low, int mid, int high) {
        // Copy the contents from arr to temp
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        int i = low; // traverse left sorted sub-array
        int j = mid + 1; // traverse right sorted sub-array
        int k = low; // will merge both sorted arrays into main array(arr)

        // Update value from temp to original arr in correct order
        while (i <= low && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Add remaining elements from temp to arr
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
    }

    public static int quickSort_Partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low, j = low;
        while (i <= high) {
            if (arr[i] <= pivot) {
                swapInArr(arr, i, j);
                j++;
            }
            i++;
        }
        return j - 1;
    }

    public static void quickSort_Sorting(int[] arr, int low, int high) {
        if (low < high) {
            int p = quickSort_Partition(arr, low, high);
            quickSort_Sorting(arr, low, p-1);
            quickSort_Sorting(arr, p+1, high);
        }
    }
    public static void swapInArr(int[] arr, int sourceIndex, int destinationIndex) {
        int temp = arr[sourceIndex];
        arr[sourceIndex] = arr[destinationIndex];
        arr[destinationIndex] = temp;
    }

    public static void sortQuaresArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= arr[i];
        }

        quickSort_Sorting(arr, 0, arr.length - 1);
    }
}
