package DataStructures.Arrays;

public class ArrayProblems {
    public static void main(String[] args) {
        // findSumPair(new int[]{8, 7, 2, 5, 3, 1}, 10);
        // subArrayHavingZeroSum(new int[]{3, 4, -7, 3, 1, 3, 1, -4, -2, -2});
        // multiply(new int[]{1,2,3,4}, 4);
        // find_multiplication(new int[]{5, 7, 9, 3, 6, 2}, new int[]{1, 2, 6, -1, 0, 9}, 6, 6);
        // removeEvens(new int[]{1, 3, 6, 7});
        //displayArray(reverseArray(new int[]{1, 3, 6, 7}));
        // System.out.println(String.format("Min: %d", getMinimumValue(new int[]{1, 3, 6, 7})));
        // System.out.println(String.format("2nd Max: %d", get2ndMax(new int[]{1, 3, 6, 7})));
        // displayArray(moveAll0sToEnd(new int[] { 5, 0, 1, 0, 1, 5, 0 }));
        // displayArray(resizeArrayToGivenCapacity(new int[] { 5, 0, 1, 0 }, 3));
        //System.out.println(String.format("%d is missing" , findMissingNumberInGivenRangeUsingBinarySearch(new int[] { 1, 2, 3, 4, 6, 7, 8, 9 }, 1, 9)));
        // System.out.println(String.format("%d is missing" , findMissingNumberInGivenRangeByNaturalNumberSum(new int[] { 1, 2, 3, 4 }, 1, 5)));
        /*int[] arr = {4, 7, 3, 4, 8, 1};
        displayArray(findNextGreaterElementToRight(arr));*/
        /*int[] a1 = {1, 2, 5, 6}, a2 = {3, 4};
        displayArray(mergeTwoSortedArrays(a1, a2));*/

        /*int[] arr = {2, 1, 0, 1, 0, 2};
        displayArray(sortArrayHavingGivenValuesEnhanced(arr));*/
        int[] arr = { 2, 3, 5, 6, 8, 9 };
        arrangeArrayInMaxMinForm(arr);
        displayArray(arr);
    }

    public static void displayArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
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

    public static void removeEvens(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) arr[i] = -1;
        }
        for (int i : arr) {
            if (i != -1) System.out.print(i + ", ");
        }
        // return arr;
    }

    public static int[] reverseArray(int[] arr) {
        int[] result = new int[arr.length];

        int count = 0, mainArrayIndex = arr.length-1;
        while (count < arr.length) {
            result[count] = arr[mainArrayIndex];
            mainArrayIndex--;
            count++;
        }
        return result;
    }

    public static int getMinimumValue(int arr[]) {
        int min = arr[0];
        for(int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }

    public static int get2ndMax(int arr[]) {
        int max = arr[0], maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                // max = arr[i];
                maxIndex = i;
            }
        }
        arr[maxIndex] = -1;
        //int secondMax = max;
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    public static int[] moveAll0sToEnd(int[] arr) {
        int passThrough = 0;
        for(int i = 0; i < arr.length; i++) {
            ++passThrough;
            for (int j = 0; j < arr.length-passThrough; j++) {
                if (arr[j] == 0) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] resizeArrayToGivenCapacity(int[] arr, int capacity) {
        int[] newArr = new int[capacity];
        int iterateTill = (capacity < arr.length) ? capacity : arr.length;
        for(int i = 0; i < iterateTill; i++) {
            //if (i < capacity)
            newArr[i] = arr[i];
        }

        arr = newArr;
        return arr;
    }

    public static int findMissingNumberInGivenRangeUsingBinarySearch(int[] arr, int startRange, int endRange) {
        int num = startRange, missingNum = -1, counter = 0;
        while (num != endRange) {
            if (findElementIndex(arr, num) == -1) return num;
            num++;
        }

        return missingNum;
    }

    public static int findElementIndex(int[] arr, int num) {
        int leftIndex = 0, rightIndex = arr.length-1, mid = 0;
        while (leftIndex <= rightIndex) {
            mid = (leftIndex + rightIndex)/2;
            if (num < arr[mid]) {
                rightIndex = mid - 1;
            } else if (num > arr[mid]) {
                leftIndex = mid + 1;
            } else {
                if (num == arr[mid]) {
                    return mid;
                }
            }
        }
        return -1;
    }

    public static int findMissingNumberInGivenRangeByNaturalNumberSum(int[] arr, int startRange, int endRange) {
        int totalNumbers = endRange-startRange+1, missingNumnber = -1;
        int sumOfRange = (totalNumbers * (totalNumbers+1))/2, actualSum = getArrayElementsSum(arr);
        missingNumnber = sumOfRange - actualSum;
        return missingNumnber;
    }

    public static int getArrayElementsSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /*Task is to find current's greater element towards it's right, else store -1*/
    public static int[] findNextGreaterElementToRight(int[] arr) {
        // Iterate the outer loop only till last-1th element
        for (int i = 0; i < arr.length-1; i++) {
            int currentElement = arr[i];
            // System.out.print(String.format("[%d, (", arr[i]));
            // Start inner loop from i+1th element
            for (int j = i+1; j < arr.length; j++) {
                int nextElement = arr[j];
                // System.out.print(String.format("%d, ", arr[j]));
                // System.out.print(String.format("Comparing (%d, %d)", currentElement, nextElement));
                if (nextElement > currentElement) {
                    arr[i] = nextElement;
                    break;
                }
                // if we're comparing last-1th element, set -1 to arr[i]
                if (j == arr.length -1) {
                    arr[i] = -1;
                }
            }
            //System.out.println(")]");
            System.out.println();
        }
        arr[arr.length-1] = -1;
        return arr;
    }

    public static int[] mergeTwoSortedArrays(int[] a1, int[] a2) {
        int combinedLength = a1.length + a2.length, i = 0, firstArrayIndex = 0, secondArrayIndex = 0;
        int[] arr = new int[combinedLength];
        while (i < combinedLength && firstArrayIndex < a1.length && secondArrayIndex < a2.length) {
            int minValue = 0;
            if (a1[firstArrayIndex] >= a2[secondArrayIndex]) {
                minValue = a2[secondArrayIndex];
                secondArrayIndex++;
            } else {
                minValue = a1[firstArrayIndex];
                firstArrayIndex++;
            }

            arr[i] = minValue;
            i++;
        }

        if (firstArrayIndex != a1.length) {
            while (firstArrayIndex < a1.length) {
                arr[i] = a1[firstArrayIndex];
                firstArrayIndex++;
                i++;
            }
        }

        if (secondArrayIndex != a2.length) {
            while (secondArrayIndex < a2.length) {
                arr[i] = a2[secondArrayIndex];
                secondArrayIndex++;
                i++;
            }
        }
        return arr;
    }

    public static int[] sortArrayHavingGivenValues(int[] arr) {
        int zerosCount = 0, onesCount = 0, twosCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) zerosCount++;
            else if (arr[i] == 1) onesCount++;
            else twosCount++;
        }
        int counter = 0;
        while (zerosCount > 0) {
            arr[counter] = 0;
            counter++;
            zerosCount--;
        }

        while (onesCount > 0) {
            arr[counter] = 1;
            counter++;
            onesCount--;
        }

        while (twosCount > 0) {
            arr[counter] = 2;
            counter++;
            twosCount--;
        }

        return arr;
    }

    public static int[] sortArrayHavingGivenValuesEnhanced(int[] arr) {
        int i = 0, j = 0, k = arr.length - 1;
        while (i <= k) {
            switch (arr[i]) {
                case 0:
                    if (arr[i] != arr[j]) swapValuesInArrayAtGivenIndex(arr, i, j);
                    i++;
                    j++;
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    if (arr[i] != arr[k]) swapValuesInArrayAtGivenIndex(arr, i, k);
                    k--;
                    break;
            }
        }

        System.out.println(String.format("(i: %d, j: %d, k: %d)", i, j, k));
        return arr;
    }

    public static void swapValuesInArrayAtGivenIndex(int[] arr, int sourceIndex, int destinationIndex) {
        int temp = arr[sourceIndex];
        arr[sourceIndex] = arr[destinationIndex];
        arr[destinationIndex] = temp;
    }

    public static void arrangeArrayInMaxMinForm(int[] arr) {
        int minIndex = 0, maxIndex = arr.length-1;
        int max = arr[maxIndex] + 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[maxIndex] % max) * max;
                maxIndex--;
            } else {
                arr[i] += (arr[minIndex] % max) * max;
                minIndex++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] /= max;
        }
    }
}
