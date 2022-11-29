package DataStructures.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = createMatrix(3,3);
        // displayMatrix(matrix);
        //searchElementByKeyInSortedMatrix(matrix, 10);
        printRightwardSpiralMatrix(matrix);
    }

    public static int[][] createMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = num++;
            }
        }
        return matrix;
    }

    public static void displayMatrixWithFullInfo(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[rows-1].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(String.format("[(%d, %d): %d] ", i, j, matrix[i][j]));
            }
            System.out.println();
        }
    }

    public static void displayMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[rows-1].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(String.format("%d ", matrix[i][j]));
            }
            System.out.println();
        }
    }

     public static void searchElementByKeyInSortedMatrix(int[][] matrix, int key) {
        int currentRow = 0, matrixLength = matrix.length;
        int currentCol = matrixLength-1;
        while (currentRow < matrixLength && currentCol >= 0) {
            if (matrix[currentRow][currentCol] == key) {
                System.out.println(String.format("%d found at (%d, %d)", key, currentRow, currentCol));
                return;
            }

            if (matrix[currentRow][currentCol] > key) currentCol--;
            else currentRow++;
        }
         System.out.println(String.format("%d not found", key));
     }

     public static void printRightwardSpiralMatrix(int[][] matrix) {
        int rows = matrix.length, iterator = 0, currentRow = 0, currentCol = 0;
        int cols = matrix[rows-1].length;
        while (currentRow < rows && currentCol < cols) {
            // Print left to right
            for (iterator = currentCol; iterator < cols; iterator++) {
                System.out.print(String.format("%d ", matrix[currentRow][iterator]));
            }
            currentRow++;

            // Print right to bottom
            for (iterator = currentRow; iterator < rows; iterator++) {
                System.out.print(String.format("%d ", matrix[iterator][cols-1]));
            }
            cols--;

            // Print bottom to left
            if (currentRow < rows) {
                for (iterator = cols - 1; iterator >= currentCol; iterator--) {
                    System.out.print(String.format("%d ", matrix[rows-1][iterator]));
                }
                rows--;
            }

            // Print bottom to top
            if (currentCol < cols) {
                for (iterator = rows-1; iterator >= currentRow ; iterator--) {
                    System.out.print(String.format("%d ", matrix[iterator][currentCol]));
                }
                currentCol++;
            }
        }
     }
}
