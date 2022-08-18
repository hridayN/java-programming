package com.arrays;

public class ArrayProblems {
    public static void main(String[] args) {
        int[] charArray = {'a', 'b', 'c', 'd', 'e' };
        int deleteFrom = 0;
        Arrays arraysObj = new Arrays();
        System.out.println("before: ");
        arraysObj.print1DArray(charArray);
        charArray = deleteFromArray(charArray, deleteFrom);
        System.out.println("after: ");
        arraysObj.print1DArray(charArray);
    }

    public static int[] copyArray(int[] arr) {
        int[] result = new int[arr.length];
        for(int i = 0;i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static int[] deleteFromArray(int[] arr, int index) {
        int[] result = new int[arr.length-1];
        boolean nextIdentifier = false;
        for(int i = 0; i < result.length; i++) {
            if (index == i && nextIdentifier == false) {
                result[i] = arr[i+1];
                nextIdentifier = true;
            } else if(nextIdentifier == false) {
                result[i] = arr[i];
            } else {
                result[i] = arr[i+1];
            }
        }
        return result;
    }
}
