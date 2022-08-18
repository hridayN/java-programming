package InterviewPreparation;

import Algorithms.Search;
import Algorithms.Sorting;

import java.util.ArrayList;
import java.util.Scanner;

class pair {
    long first, second;

    pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

public class Arrays {
    public static void main(String[] main) {
        int[] arr = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        // arr = new int[]{ 1, 2, 3, 7, 5};
        //ArrayList<Integer> result = subArraySum(arr, arr.length, 12);
        //System.out.println("result: " + result);
        /*
        arr = oneBasedIndexing(arr);
        printArrayWithIndex(arr);*/

        //System.out.println(countTriplets(new int[]{14,3,6,8,11,16}, 6));
        //System.out.println(maxSubArraySum(new int[]{-44,58}, 2));
        /*arr = new int[]{1,2,3,5};
        System.out.println("missingNumber: "+missingNumber(arr, arr.length+1));*/

        /*arr = new int[]{1};
        System.out.println("missingNumber: "+missingNumber(arr, arr.length+1));*/
        // arr = new int[]{6, 1, 15, 19, 9, 13, 12, 6, 7, 2, 10, 4, 1, 14, 11, 14, 14, 13};
        //System.out.println(peakElement(arr, arr.length));
        /*long[] a = new long[]{5, 1, 2, 5, 7, 10, 3, 4};
        pair p = getMinMax(a, a.length);
        System.out.println(String.format("{min: %2d, max: %2d}", p.first, p.second));*/
        arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(String.format("output: %d", conditionalArrayProblem1(arr.length, arr)));
    }

    public static ArrayList<Integer> subArraySum(int[] arr, int n, int sum) {
        int currentSum = 0, startIndex = -1, endIndex = -1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            //i = 37;
            for (int j = i; j < n; j++) {
                if (currentSum < sum) {
                    currentSum += arr[j];
                } else {
                    if (currentSum > sum) {
                        currentSum = 0;
                        startIndex = -1;
                        endIndex = -1;
                        break;
                    } else {
                        startIndex = i;
                        endIndex = j;
                        result.add(startIndex + 1);
                        result.add(endIndex);
                        return result;
                    }
                }
            }
        }
        result.add(startIndex);
        result.add(endIndex);
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void printArrayWithIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("[" + i + "]: " + arr[i]);
        }
    }

    public static int[] oneBasedIndexing(int[] arr) {
        int[] result = new int[arr.length + 1];
        result[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            result[i] = arr[i - 1];
        }
        return result;
    }

    public static int countTriplets(int[] arr, int n) {
        int triplets = 0;
        arr = Sorting.selectionSort(arr);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (Search.binarySearch(arr, sum)) {
                    triplets++;
                }
            }
        }
        return triplets;
    }

    public static int maxSubArraySum(int arr[], int n) {
        int maxSum = Sorting.getLargestValue(arr);
        for (int i = 0; i < n; i++) {
            int currentSum = arr[i];
            for (int j = i + 1; j < n; j++) {
                currentSum += arr[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    public static int missingNumber(int array[], int n) {
        int result = -1;
        int[] arr = new int[n];
        arr[n - 1] = -1;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = array[i];
            if (arr[i] != i + 1) {
                result = i + 1;
                break;
            }
        }

        if (result == -1) {
            result = array[array.length - 1] + 1;
        }
        return result;
    }

    public static int peakElement(int[] arr, int n) {
        int peak = 0;
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1 && arr[i - 1] < arr[i]) {
                peak = i;
            } else {
                if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                    peak = i;
                }
            }
        }
        System.out.println(String.format("Peak: (%d, %d)", peak, arr[peak]));
        return (peak == 0) ? 0 : 1;
    }

    public static pair getMinMax(long a[], long n) {
        long min = a[0], max = a[0];
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        pair p = new pair(min, max);
        return p;
    }

    public static void reverseArray() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for (int i = 0; i < T; i++) {
            // First line: Size of array
            int N = scn.nextInt();

            // Second line: Elements of array
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = scn.nextInt();
            }

            // Third line: reverse array
            for (int j = N - 1; j >= 0; j--) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    /*
    * Print 0 if n is even
    * Print sum of array elements, if n is odd
    */
    public static int conditionalArrayProblem1(int n, int[] arr) {
        int sum = 0;
        if (isEven(n)) {
            return sum;
        }
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static boolean isEven(int n) {
        return (n % 2 == 0) ? true : false;
    }
}


