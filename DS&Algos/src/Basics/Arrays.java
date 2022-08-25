package Basics;

import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        //int[] arr = {15};
        //System.out.println(peakElement(arr, arr.length));
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
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
