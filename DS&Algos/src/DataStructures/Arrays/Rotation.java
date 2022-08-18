package DataStructures.Arrays;

public class Rotation {
    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 2};
        //arr = reverseRotate(arr, 2, arr.length);
        /*printArray(arr);*/

        //System.out.println("min: " + findMinElement(arr));
        //int minElementIndex = findMinElementIndexInSortedRotated(arr);
        //System.out.println("minElementIndex: " + minElementIndex);
        //System.out.println("Sum exists: " + findIfPairExistsForGivenSum(arr, -1));
        //System.out.println("Sum : " + sumOfProductOfIndexAndElement(arr));
        //arr = singleRotation(arr);
        //printArray(arr);
        long start = System.nanoTime();
        System.out.println("Max: " + findMaxSumOfProductOfIndexAndElementWithAllRotations(arr));
        long end = System.nanoTime();
        System.out.println("Total time: " + (end - start));
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    // d: elements to be rotated
    // n: no. of elements in array
    public static int[] reverseRotate(int[] arr, int d, int n) {
        int[] result = new int[n];

        // set first d elements
        for (int i = 0; i < d; i++) {
            result[n-d+i] = arr[i];
        }

        // set remaining (n-d) elements
        for (int i = d; i < n; i++) {
            result[i-d] = arr[i];
        }
        return result;
    }

    public static int[] singleRotation(int[] arr) {
        int[] result = new int[arr.length];

        //set last element of input array as 1st element of result
        result[0] = arr[arr.length-1];

        // set remaining elements
        for (int i = 0; i < arr.length-1; i++) {
            result[i+1] = arr[i];
        }

        return result;
    }

    public static int findMinElement(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int findMinElementIndex(int[] arr) {
        int minIndex = 0, min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findMaxElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMaxElementIndex(int[] arr) {
        int maxIndex = 0, max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int findMinElementIndexInSortedRotated(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            counter++;
            if (i+1 != arr.length && arr[i] > arr[i+1]) {
                // desired element's index
                return i+1;
            }
        }
        System.out.println("iterated " + counter + " times");

        // reaching here indicates array is not rotated
        return 0;
    }

    public static boolean findIfPairExistsForGivenSum(int[] arr, int sum) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                //System.out.println("Checked pair: (" + arr[i] + ", " + arr[j] + ")");
                counter++;
                if (arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        System.out.println("Counter: " + counter);
        return false;
    }

    public static int sumOfProductOfIndexAndElement(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += i*arr[i];
        }
        return sum;
    }

    public static int findMaxSumOfProductOfIndexAndElementWithAllRotations(int[] arr) {
        int[] sums = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            sums[i] = sumOfProductOfIndexAndElement(arr);
            arr = singleRotation(arr);
        }

        return findMaxElement(sums);
    }
}
