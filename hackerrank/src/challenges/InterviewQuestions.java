package challenges;

import java.util.Scanner;

public class InterviewQuestions {
    public static void main(String[] args) {
        // System.out.print(shopping(5, new int[] { 1, 4, 5, 3, 2 }, new int[] { 3, 2, 3, 4, 1 }));
        /*// Partially sorted
        int[] arr = {1, 5, 3, 2, 0, 4 };*/
        /*// Fully sorted
        int[] arr = {0, 1, 2, 3, 4, 5};*/
        // Reverse sorted
        int[] arr = {5, 4, 3, 2, 1, 0};

        //1,5   3,2,0,4
        //1,3,5    2,0,4
        //1,2,3,5   0,4
        //0,1,2,3,5 4
        //012345
        // int[] arr = { 5, 4, 3, 2, 1, 0 };
        printArray(BubbleSort(arr));
        // printArray(InsertionSort(arr));
    }

    public static void javaOutputFormatting() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            System.out.print(s1);
            for (int s = 0; s < 15 - s1.length(); s++) {
                System.out.print(" ");
            }
            String updatedX = x + "", tempX = "";
            int zeroesToAdd = 3 - updatedX.length();
            for (int z = 0; z < zeroesToAdd; z++) {
                tempX = tempX.concat("0");
            }
            updatedX = tempX + x;
            System.out.print(updatedX);
            System.out.println();
        }
        System.out.println("================================");

    }

    public static void printMultiplesAsTable(int N) {
        for (int i = 1; i <= 10; i++) {
            System.out.print(N + " x " + i + " = " + (N * i));
            System.out.println();
        }
    }

    public static void printSeries() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();   // no. of terms in series
            int s = a + b;
            System.out.print(s + " ");
            for (int k = 1; k < n; k++) {
                s += Math.pow(2, k) * b;
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static int shopping(int customers, int[] waitingTimes, int[] buyingTimes) {
        int timeElapsed = 0, customersProcessed = 0, maxWaitingTime = getMax(waitingTimes), counter = 0;
        int[] tempBuyingTimes = buyingTimes;
        int[] sortedBuyingTimes = InsertionSort(buyingTimes);
        int[] updatedWaitingTimes = setArrayBasedOnOtherArray(sortedBuyingTimes, tempBuyingTimes, waitingTimes);
        while (timeElapsed <= maxWaitingTime) {
            int currentBuyingTime = sortedBuyingTimes[counter];
            if (updatedWaitingTimes[counter] > timeElapsed) {
                customersProcessed += 1;
                timeElapsed += currentBuyingTime;
            }
            counter++;
        }
        return customersProcessed;
    }

    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int getIndexOfMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public int[] getNewArray(int startIndex, int endIndex, int[] arr) {
        int[] result = new int[endIndex - startIndex];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    /*public static int[] InsertionSort(int[] arr) {
        int startIndex = 1, round = 1;
        while (startIndex < arr.length) {
            int temp = arr[startIndex], gapIndex = -1;
            for(int i = startIndex-1; i >= 0; i--) {
                // if any value to the left of temp is greater, move it to right till temp
                if (arr[i] > temp) {
                    arr[i+1] = arr[i];
                    gapIndex = i;
                } else {
                    break;
                }
            }
            startIndex++;
            if (gapIndex != -1) {
                arr[gapIndex] = temp;
            }
        }
        return arr;
    }*/

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static int[] setArrayBasedOnOtherArray(int[] sortedInput1, int[] unsortedInput1, int[] input2) {
        int[] result = new int[sortedInput1.length];
        for (int i = 0; i < sortedInput1.length; i++) {
            int indexInUnsorted = BinarySearch(unsortedInput1, sortedInput1[i]);
            result[i] = input2[indexInUnsorted];
        }
        return result;
    }

    public static int BinarySearch(int[] arr, int valueToFind) {
        int left = 0, right = arr.length - 1, mid = (left + right) / 2, foundAtIndex = -1;
        while (left <= right) {
            if (valueToFind == arr[mid]) {
                foundAtIndex = mid;
                break;
            } else if (valueToFind < arr[mid]) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else if (valueToFind > arr[mid]) {
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }
        return foundAtIndex;
    }

    public static int[] BubbleSort(int[] arr) {
        int leftValue = 0, rightValue = 1, comparison = 1, round = 0;
        boolean sorted = false;
        while (!sorted) {
            int swaps = 0;
            round++;
            System.out.println("****" + round + "th round ****");
            while (rightValue <= (arr.length - round)) {
                System.out.println(comparison++ + "th comparison: " + arr[leftValue] + " with " + arr[rightValue]);
                if (arr[leftValue] > arr[rightValue]) {
                    // swap
                    int a = arr[leftValue], b = arr[rightValue];
                    a = a - b;
                    b = a + b;
                    a = b - a;
                    arr[leftValue] = a;
                    arr[rightValue] = b;
                    swaps++;
                    System.out.println("swapped " + arr[leftValue] + " with " + arr[rightValue]);
                }
                leftValue++;
                rightValue++;
            }
            leftValue = 0;
            rightValue = 1;
            if (swaps == 0) {
                sorted = true;
            }
        }
        return arr;
    }

    public static int[] SelectionSort(int[] arr) {
        int startIndex = 0, round = 1, comparison = 1;
        while (startIndex < (arr.length - 1)) {
            System.out.println("****" + (round++) + "th round ****");
            int smallest = arr[startIndex], indexToSwap = startIndex;
            for (int i = (startIndex + 1); i < arr.length; i++) {
                System.out.println(comparison++ + "th comparison: " + smallest + " with " + arr[i]);
                if (smallest > arr[i]) {
                    smallest = arr[i];
                    indexToSwap = i;
                }
            }
            // swap
            if (smallest != arr[startIndex]) {
                int a = arr[indexToSwap], b = arr[startIndex];
                System.out.println("swapped " + b + " with " + a);
                a = a - b;
                b = a + b;
                a = b - a;
                arr[indexToSwap] = a;
                arr[startIndex] = b;
            }
            startIndex++;
        }
        return arr;
    }

    public static int GetLeastElement(int[] arr) {
        int smallest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (smallest > arr[i]) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    public static int[] InsertionSort(int[] arr) {
        int startIndex = 1, comparison = 1, round = 1;
        while (startIndex < arr.length) {
            System.out.println("****" + (round++) + "th round ****");
            int temp = arr[startIndex], gapIndex = -1;
            for (int i = startIndex - 1; i >= 0; i--) {
                // if any value to the left of temp is greater, move it to right till temp
                System.out.println(comparison++ + "th comparison: " + arr[i] + " with " + temp);
                if (arr[i] > temp) {
                    arr[i + 1] = arr[i];
                    System.out.println("moved " + arr[i] + " from index '" + i + "' to '" + (i + 1) + "'");
                    gapIndex = i;
                } else {
                    System.out.println("Since " + arr[i] + " < " + temp + ", end of round " + (round - 1));
                    break;
                }
            }
            startIndex++;
            if (gapIndex != -1) {
                arr[gapIndex] = temp;
                System.out.println("Placed " + temp + " at index '" + gapIndex + "'");
            }
            System.out.println();
        }
        return arr;
    }
}
