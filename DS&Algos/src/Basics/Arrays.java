package Basics;

import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        _2DArray();
        //arrayOfTestCases();
        //int[] arr = {15};
        //System.out.println(peakElement(arr, arr.length));
    }

    public static void _2DArray(){
        //total size = rows * columns
        //Indirect method: Initialize later
        int[][] arr1 = new int[2][2];

        //Direct method: Initialize at declaration
        int[][] arr2 = {{1, 2}, {3, 4}};
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                System.out.print("[" + i + "," + j + "] :" + arr2[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[][] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print("[" + i + "," + j + "] :" + arr2[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void arrayOfTestCases() {
        /* rows: total no. of test cases
        * columns: test values in each test case
        * */
        System.out.println("Enter total Test Cases: ");
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();

        //Create 2d-array for test cases
        int[][] testCases = new int[rows][];
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter no. of tests in " + (i+1) + "th testCase: ");
            int tests = input.nextInt();
            // initialize every testCase array
            testCases[i] = new int[tests];
            for (int j = 0; j < tests; j++) {
                System.out.print("Enter " + (j+1) + "/" + tests + "th test value: ");
                testCases[i][j] = input.nextInt();;
            }
            System.out.println();
        }
        printArray(testCases);

        //check for odd even
        int odds = 0, evens = 0;
        for (int i = 0; i < testCases.length; i++) {
            for (int j = 0; j < testCases[i].length; j++) {
                if (testCases[i][j] % 2 == 0) {
                    evens++;
                } else {
                    odds++;
                }
            }
            System.out.println((i+1) + "th Testcase has " + odds + " odd numbers, and " + evens + " even numbers");
            odds = 0;
            evens = 0;
        }
    }

    public static int peakElement(int[] arr,int n) {
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] > arr[i]) {
                i = j;
            }
        }

        return i;
    }

}
