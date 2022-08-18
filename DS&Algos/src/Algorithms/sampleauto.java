package Algorithms;

// Driver class
public class sampleauto {
    public static void main(String[] args) {
        int[] arr = {7, 9, 3, 10};
        int result = intoTwo(arr);
        System.out.println("result: " + result);
    }

    public static int intoTwo(int[] arr) {
        // We are referencing bubbleSort method of Sorting class here
        int[] sortedArr = Sorting.bubbleSort(arr);
        int lastElement = sortedArr[sortedArr.length-1] * 2;
        return lastElement;
    }
}
