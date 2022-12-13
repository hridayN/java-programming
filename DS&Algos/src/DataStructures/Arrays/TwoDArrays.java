package DataStructures.Arrays;

import java.util.Scanner;

public class TwoDArrays {
    public static void main(String[] args) {
        /*int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        PrintRowElementsSum_Logic(arr, arr.length, arr[0].length);*/

        PrintRowElementsSum_Driver();
    }

    public static int[][] takeInput() {
        Scanner scn = new Scanner(System.in);

        // Get the no. of rows for array
        System.out.println(String.format("Enter number of rows for array"));
        int rows = scn.nextInt();

        // Get the no. of columns for array
        System.out.println(String.format("Enter number of columns for array"));
        int cols = scn.nextInt();

        // Get the no. of {row, col} element
        int[][] arr = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.println(String.format("Enter (%d, %d) element", r, c));
                arr[r][c] = scn.nextInt();
            }
        }
        scn.close();
        return arr;
    }

    public static void PrintRowElementsSum_Driver() {
        Scanner scn = new Scanner(System.in);

        // Get the no. of test cases
        System.out.println("Enter number of test cases: ");
        int testCases = scn.nextInt();

        // For each test case, perform logic
        for (int i = 0; i < testCases; i++) {
           /* // Get the no. of rows for {i+1}th array
            System.out.println(String.format("Enter number of rows for %dth array", i+1));
            int rows = scn.nextInt();

            // Get the no. of columns for {i+1}th array
            System.out.println(String.format("Enter number of columns for %dth array", i+1));
            int cols = scn.nextInt();

            // Get the no. of {row, col} element
            int[][] arr = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    System.out.println(String.format("Enter (%d, %d) element", r, c));
                    arr[r][c] = scn.nextInt();
                }
            }*/
            // Take {i+1} array input
            int[][] arr = takeInput();
            System.out.println("Row Elements sum for " + (i + 1) + "th array");
            PrintRowElementsSum_Logic(arr);
        }
        scn.close();
    }

    public static void PrintRowElementsSum_Logic(int[][] arr) {
        int rows = arr.length, cols = arr[0].length;
        for (int i = 0; i < rows; i++) {
            int currentRowElementsSum = 0;
            for (int j = 0; j < cols; j++) {
                currentRowElementsSum += arr[i][j];
            }
            System.out.print(currentRowElementsSum + " ");
        }
    }
}
