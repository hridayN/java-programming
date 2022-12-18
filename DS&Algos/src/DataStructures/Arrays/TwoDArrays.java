package DataStructures.Arrays;

import java.util.Scanner;

public class TwoDArrays {
    public static void main(String[] args) {
        /*int[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        PrintRowElementsSum_Driver();*/
        /*int[][] arr1 = {{3, 6, 9}, {1, 4, 7}, {2, 8, 9}};
        PrintColumnElementsSum_Logic(arr1);*/

        int[][] arr1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        // PrintSineWave(arr1);
        // PrintSpiral(arr1);
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

    public static void PrintColumnElementsSum_Logic(int[][] arr) {
        int rows = arr.length, cols = arr[0].length;
        int colsMaxSum = Integer.MIN_VALUE, rowsMaxSum = Integer.MIN_VALUE, rowOrColumnIndex = 0;

        // Get rows sum
        for (int i = 0; i < rows; i++) {
            int currentRowElementsSum = 0;
            for (int j = 0; j < cols; j++) {
                currentRowElementsSum += arr[i][j];
            }
            if (rowsMaxSum < currentRowElementsSum) {
                rowsMaxSum = currentRowElementsSum;
                rowOrColumnIndex = i;
            }
            //System.out.print(currentRowElementsSum + " ");
        }

        // Get cols sum
        for (int i = 0; i < cols; i++) {
            int currentColumnElementsSum = 0;
            for (int j = 0; j < rows; j++) {
                currentColumnElementsSum += arr[j][i];
            }
            if (colsMaxSum < currentColumnElementsSum) {
                colsMaxSum = currentColumnElementsSum;
                rowOrColumnIndex = i;
            }
            //System.out.print(colsMaxSum + " ");
        }

        if (rowsMaxSum >= colsMaxSum) {
            System.out.println(String.format("Row %d %d", rowOrColumnIndex, rowsMaxSum));
        } else {
            System.out.println(String.format("Column %d %d", rowOrColumnIndex, colsMaxSum));
        }
    }

    /*Print array elements in Sine wave order*/
    public static void PrintSineWave(int[][] arr) {
        int rows = arr.length, cols = arr[0].length;

        for (int col = 0; col < cols; col++) {
            // Print Top -> Down if col is even
            if (col % 2 == 0)
                for (int row = 0; row < rows; row++) {
                    System.out.print(arr[row][col] + " ");
                }
            else    // Print Down -> Top if col is odd
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(arr[row][col] + " ");
                }
        }
    }

    /*Print array elements in Spiral order*/
    public static void PrintSpiral(int[][] arr) {
        int rows = arr.length, cols = arr[0].length;
        int rowStart = 0, rowEnd = rows - 1, colStart = 0, colEnd = cols - 1, totalElements = rows * cols, elementsVisited = 0;

        while(elementsVisited < totalElements) {// Print left -> right
            int counter = colStart;
            while (counter <= colEnd) {
                System.out.print(arr[rowStart][counter] + " ");
                elementsVisited++;
                counter++;
            }
            rowStart++;

            // Print right -> bottom right
            counter = rowStart;
            while (counter <= rowEnd) {
                System.out.print(arr[counter][colEnd] + " ");
                elementsVisited++;
                counter++;
            }
            colEnd--;

            // Print right bottom -> left bottom
            counter = colEnd;
            while (counter >= colStart) {
                System.out.print(arr[rowEnd][counter] + " ");
                elementsVisited++;
                counter--;
            }
            rowEnd--;

            // Print left-bottom > top
            counter = rowEnd;
            while (counter >= rowStart) {
                System.out.print(arr[counter][colStart] + " ");
                elementsVisited++;
                counter--;
            }
            colStart++;
        }
    }
}
