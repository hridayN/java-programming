package Algorithms;

public class Search {
    // Please feed me only sorted array
    public static boolean binarySearch(int[] arr, int element) {
        int left = 0, right = arr.length-1, mid = 0;
        while (left <= right) {
            mid = (left+right)/2;
             if (element < arr[mid]) {
                right = mid - 1;
             } else if (element > arr[mid]) {
                left = mid + 1;
             } else {
                 if (element == arr[mid]) {
                     return true;
                 }
             }
        }
        return false;
    }
}
