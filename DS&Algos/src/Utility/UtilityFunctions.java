package Utility;

public class UtilityFunctions {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void printArray(int[][] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print("[" + i + "," + j + "] :" + arr2[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("'%s', ", arr[i]));
        }
        System.out.println();
    }
}
