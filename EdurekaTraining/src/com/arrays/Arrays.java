package com.arrays;

public class Arrays {
    public static void main(String[] args) {
        /*int index = 5;
        int element = getElementAtGivenIndex(index);
        System.out.print("element at " + index + " is: " + element);*/
        //print1DArray();
        int[][] arr = {
                {1, 2, 3}, {3, 4}
        };
        int rowNumber = 1;
        int length = getGivenRowLength(rowNumber, arr);
        System.out.println("row " + rowNumber + "'s length: " + length);
    }

    public static void initialization_1D() {
        /*Using new operator and size*/
        int size=5;
        int[] a = new int[size];
        int b[] = new int[size];

        /*Using initializer*/
        int[] c = {1, 2, 3, 4, 5};

        /*Using new operator and initializer*/
        int []d = new int[] {1, 2, 3, 4, 5};
    }

    public static void print1DArray() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int index = 0; index < arr.length; index++) {
            System.out.print("[" + index + "]: " + arr[index] + ", ");
        }
    }

    public static void initialization_2D() {
        int[][] arr = {
                {1, 2}, {3, 4}
        };
    }

    public static void print2DArray() {
        int[][] arr = {
                {1, 2}, {3, 4}
        };
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr.length; col++) {
                System.out.print("[" + row + "," + col + "]: " + arr[row][col] + ", ");
            }
            System.out.println();
        }
    }

    public static int getElementAtGivenIndex(int index) {
        int[] arr = {2, 4, 6, 8, 10};
        return (index >= 0 && index <= arr.length-1) ? arr[index] : -1;
    }

    public static int getGivenRowLength(int rowNumber, int[][] arr) {
        return arr[rowNumber-1].length;
    }
}
