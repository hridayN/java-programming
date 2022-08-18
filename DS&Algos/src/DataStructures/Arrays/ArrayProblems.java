package DataStructures.Arrays;

public class ArrayProblems {
    public static void main(String[] args) {
        // findSumPair(new int[]{8, 7, 2, 5, 3, 1}, 10);
        // subArrayHavingZeroSum(new int[]{3, 4, -7, 3, 1, 3, 1, -4, -2, -2});
        // multiply(new int[]{1,2,3,4}, 4);
        find_multiplication(new int[]{5, 7, 9, 3, 6, 2}, new int[]{1, 2, 6, -1, 0, 9}, 6, 6);
    }

    public static void findSumPair(int[] arr, int sum) {
        boolean pairFound = false;
        int pass = 1;
        for (int i = 0; i <= arr.length-1; i++) {
            System.out.println(String.format("Pass %d", pass++));
            for (int j = i+1; j <= arr.length-1; j++) {
                System.out.println(String.format("Checking (%d + %d)", arr[i], arr[j]));
               if (arr[i] + arr[j] == sum) {
                   System.out.println(String.format("Pair found: (%d, %d)", arr[i], arr[j]));
                   pairFound = true;
               }
            }
            if (i == arr.length - 2 && !pairFound) {
                break;
            }
        }

        if (!pairFound) {
            System.out.print("Pair not found");
        }
    }

    public static void subArrayHavingZeroSum(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (i != j) {
                    System.out.println(String.format("(%d, %d)", j, i));
                    findZeroSumWithSpecifiedIndex(arr, j, i);
                }
            }
        }
    }

    public static void findZeroSumWithSpecifiedIndex(int[] arr, int startIndex,  int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += arr[i];
        }
        if (sum == 0) {
            System.out.print("{ ");
            for (int i = startIndex; i <= endIndex; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.print("}");
            System.out.println();
        }
    }

    // Function for finding maximum and value pair
    public static void multiply (int arr[], int n) {
        int leftSum = 0, rightSum = 0, sumProduct = 0, medianIndex = n/2;
        for (int i =0; i < medianIndex; i++) {
            leftSum += arr[i];
        }
        for (int i = medianIndex; i <= n-1; i++) {
            rightSum += arr[i];
        }
        sumProduct = leftSum * rightSum;
        System.out.println(String.format("medianIndex: %d, LeftSum: %d, RightSum: %d, Product: %d", medianIndex, leftSum, rightSum, sumProduct));
    }

    public static long find_multiplication (int arr[], int brr[], int n, int m) {
        int maxFromFirst = arr[0], minFromSecond = brr[0], product = 1;
        for(int i = 0; i <= arr.length - 1; i++){
            if (maxFromFirst < arr[i]) {
                maxFromFirst = arr[i];
            }
        }
        for (int j =0; j <= brr.length - 1; j++) {
            if (minFromSecond > brr[j]) {
                minFromSecond = brr[j];
            }
        }
        product = maxFromFirst * minFromSecond;
        System.out.println("Product: "+ product);
        return product;
    }
}
