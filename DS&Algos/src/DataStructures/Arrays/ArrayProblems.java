package DataStructures.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static Algorithms.Sorting.quickSort_Sorting;

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
        /*int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(String.format("%d is missing", findMissingNumberInGivenRangeByNaturalNumberSum(arr, arr.length + 1)));*/
        /*int[] arr = {4, 7, 3, 4, 8, 1};
        displayArray(findNextGreaterElementToRight(arr));*/
        /*int[] a1 = {1, 2, 5, 6}, a2 = {3, 4};
        displayArray(mergeTwoSortedArrays(a1, a2));*/

        /*int[] arr = {2, 1, 0, 1, 0, 2};
        displayArray(sortArrayHavingGivenValuesEnhanced(arr));*/
        //int[] arr = {101, 168, 93, 188, 133, 157, 175};
        //int[] arr = {1, 2, 3, 7, 5};
        // int[] arr = {142, 112, 54, 69, 148, 45, 63, 158, 38, 60, 124, 142, 130, 179, 117, 36, 191, 43, 89, 107, 41, 143, 65, 49, 47, 6, 91, 130, 171, 151, 7, 102, 194, 149, 30, 24, 85, 155, 157, 41, 167, 177, 132, 109, 145, 40, 27, 124, 138, 139, 119, 83, 130, 142, 34, 116, 40, 59, 105, 131, 178, 107, 74, 187, 22, 146, 125, 73, 71, 30, 178, 174, 98, 113};
        /*arrangeArrayInMaxMinForm(arr);
        displayArray(arr);*/

        /*arr = new int[]{2, 0, 1, 0, 2, 1, 1};
        displayArray(arr);
        sort0s1s2sArray(arr);
        displayArray(arr);*/
        // int[] arr = {9, 45, 10, 190};
        /*long startTime = System.currentTimeMillis();
        System.out.println(subarraySum(arr, arr.length - 1, 12).toString());
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in seconds: " + timeElapsed*1000);*/

        /*int[] arr = {1, 2};
        cyclicalRotate(arr, 1, arr.length);*/

        /*int[] arr = {14, 7, 14, 6, 1, 11, 3, 16, 16, 8, 7, 4, 11, 15, 17, 6, 1, 13};
        System.out.print(duplicates(arr, arr.length));*/

        /*int[] arr = {1, 5, 3, 4, 3, 5, 6};
        System.out.println(String.format("First repeated index: %d", firstRepeatedIndex(arr, arr.length)));*/


        /*int[] arr = {-1, 2, -1, 3, 2};
        System.out.println(String.format("First non-repeated element: %d", firstNonRepeatingElement(arr, arr.length)));*/

        /*int[] arr = {1, 3, 2, 2, 3, 1, 6, 2, 5};
        displayArray(arr);
        System.out.println(String.format("After removing duplicates: ", removeDuplicates(arr, arr.length)));*/

        /*int[] arr = {1, 4, 5};
        System.out.println(String.format("Most repeated element: %d", mostRepeatedElement(arr)));*/

        int[] a1 = {2, 6, 1, 2}, a2 = {1, 2, 3, 4, 2};
        System.out.println(getIntersection(a1, a2));
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
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.println(String.format("Pass %d", pass++));
            for (int j = i + 1; j <= arr.length - 1; j++) {
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

    public static void findZeroSumWithSpecifiedIndex(int[] arr, int startIndex, int endIndex) {
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
    public static void multiply(int arr[], int n) {
        int leftSum = 0, rightSum = 0, sumProduct = 0, medianIndex = n / 2;
        for (int i = 0; i < medianIndex; i++) {
            leftSum += arr[i];
        }
        for (int i = medianIndex; i <= n - 1; i++) {
            rightSum += arr[i];
        }
        sumProduct = leftSum * rightSum;
        System.out.println(String.format("medianIndex: %d, LeftSum: %d, RightSum: %d, Product: %d", medianIndex, leftSum, rightSum, sumProduct));
    }

    public static long find_multiplication(int arr[], int brr[], int n, int m) {
        int maxFromFirst = arr[0], minFromSecond = brr[0], product = 1;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (maxFromFirst < arr[i]) {
                maxFromFirst = arr[i];
            }
        }
        for (int j = 0; j <= brr.length - 1; j++) {
            if (minFromSecond > brr[j]) {
                minFromSecond = brr[j];
            }
        }
        product = maxFromFirst * minFromSecond;
        System.out.println("Product: " + product);
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

        int count = 0, mainArrayIndex = arr.length - 1;
        while (count < arr.length) {
            result[count] = arr[mainArrayIndex];
            mainArrayIndex--;
            count++;
        }
        return result;
    }

    public static int getMinimumValue(int arr[]) {
        int min = arr[0];
        for (int num : arr) {
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
        for (int i = 0; i < arr.length; i++) {
            ++passThrough;
            for (int j = 0; j < arr.length - passThrough; j++) {
                if (arr[j] == 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] resizeArrayToGivenCapacity(int[] arr, int capacity) {
        int[] newArr = new int[capacity];
        int iterateTill = (capacity < arr.length) ? capacity : arr.length;
        for (int i = 0; i < iterateTill; i++) {
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
        int leftIndex = 0, rightIndex = arr.length - 1, mid = 0;
        while (leftIndex <= rightIndex) {
            mid = (leftIndex + rightIndex) / 2;
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
        int totalNumbers = endRange - startRange + 1, missingNumnber = -1;
        int sumOfRange = (totalNumbers * (totalNumbers + 1)) / 2, actualSum = getArrayElementsSum(arr);
        missingNumnber = sumOfRange - actualSum;
        return missingNumnber;
    }

    public static int findMissingNumberInGivenRangeByNaturalNumberSum(int[] arr, int n) {
        int totalNumbers = n, missingNumnber = -1;
        int sumOfRange = (totalNumbers * (totalNumbers + 1)) / 2, actualSum = getArrayElementsSum(arr);
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
        for (int i = 0; i < arr.length - 1; i++) {
            int currentElement = arr[i];
            // System.out.print(String.format("[%d, (", arr[i]));
            // Start inner loop from i+1th element
            for (int j = i + 1; j < arr.length; j++) {
                int nextElement = arr[j];
                // System.out.print(String.format("%d, ", arr[j]));
                // System.out.print(String.format("Comparing (%d, %d)", currentElement, nextElement));
                if (nextElement > currentElement) {
                    arr[i] = nextElement;
                    break;
                }
                // if we're comparing last-1th element, set -1 to arr[i]
                if (j == arr.length - 1) {
                    arr[i] = -1;
                }
            }
            //System.out.println(")]");
            System.out.println();
        }
        arr[arr.length - 1] = -1;
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
        int minIndex = 0;   // first index
        int maxIndex = arr.length - 1;  // last index
        int max = arr[maxIndex] + 1;    // last element + 1
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

    public static void sort0s1s2sArray(int[] a) {
        // quickSort_Sorting(arr, 0, arr.length - 1);
        /*int zeroesCount = 0, onesCount = 0, twosCount = 0;
        for(int i : a) {
            switch(i) {
                case 0: zeroesCount++; break;
                case 1: onesCount++; break;
                case 2: twosCount++; break;
            }
        }

        int c = 0;
        for (int i = 0; i < zeroesCount; i++) {
            a[i] = 0;
            c++;
        }

        for (int i = c; i < a.length-c; i++) {
            a[i] = 1;
            c++;
        }

        for (int i = c; i < a.length; i++) {
            a[i] = 2;
            c++;
        }*/
        int low = 0, high = a.length - 1, mid = 0;
        while (mid <= high) {
            if (a[mid] == 0) {
                int temp = a[low];
                a[low] = a[mid];
                a[mid] = temp;
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else {
                int temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high--;
            }
        }

        System.out.println(String.format("(Low: %d, Mid: %d, High: %d)", low, mid, high));
    }

    //Function to find a continuous sub-array which adds up to a given number.
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int subArraySum = 0;
            int j = i;
            arrayList = new ArrayList<>();
            arrayList.add(i + 1);
            while (j < arr.length) {
                int tempSum = subArraySum + arr[j];
                if (tempSum < s) {
                    subArraySum += arr[j];
                } else if (tempSum == s) {
                    arrayList.add(j + 1);
                    return arrayList;
                } else {
                    arrayList = new ArrayList<>();
                    break;
                }
                j++;
            }
            if (arrayList.size() != 2) {
                arrayList = new ArrayList<>();
                arrayList.add(-1);
            }
        }
        /*if (arrayList.size() != 2) {
            arrayList = new ArrayList<>();
            arrayList.add(-1);
        }*/
        return arrayList;
    }

    /*n1: numberOfElements*/
    public static void cyclicalRotate(int[] arr, int rotateBy, int n) {
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int tempIndex = i;
            if (tempIndex + rotateBy < n) {
                tempIndex += rotateBy;
            } else {
                tempIndex = (n - rotateBy == 0) ? i : tempIndex % n - rotateBy;
            }
            result[tempIndex] = arr[i];
        }

        arr = result;
        displayArray(arr);
    }

    public static void copyArray(int[] source, int[] destination) {
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
    }

    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> duplicatesList = new ArrayList<>();
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();

        for (int i : arr) {
            String iString = Integer.toString(i);
            if (stringIntegerHashMap.containsKey(iString)) {
                // int occurence = stringIntegerHashMap.get(i);
                stringIntegerHashMap.put(iString, stringIntegerHashMap.get(iString) + 1);
            } else {
                stringIntegerHashMap.put(iString, 1);
            }
        }

        Set<String> keySet = stringIntegerHashMap.keySet();
        for (String i : keySet) {
            int occurence = stringIntegerHashMap.get(i);
            if (occurence > 1) duplicatesList.add(Integer.valueOf(i));
        }

        if (duplicatesList.size() == 0) {
            duplicatesList.add(-1);
        }
        return duplicatesList;
    }

    // Function to return the first position of the first repeating element.
    public static int firstRepeatedIndex(int[] arr, int n) {
        // Your code here
        HashMap<Integer, Integer> stringIntegerHashMap = new HashMap<>();
        int firstRepeatingIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (stringIntegerHashMap.containsKey(arr[i])) {
                stringIntegerHashMap.put(arr[i], stringIntegerHashMap.get(arr[i]) + 1);
            } else {
                stringIntegerHashMap.put(arr[i], 1);
            }
        }

        // iterating over the array elements.
        for (int i = 0; i < n; i++) {
            // if frequency of current element in map is greater than 1,
            // then we store the index and break the loop.
            if (stringIntegerHashMap.get(arr[i]) > 1) {
                firstRepeatingIndex = i + 1;
                break;
            }
        }
        return firstRepeatingIndex;
    }

    // Function to return the first non-repeating element.
    public static int firstNonRepeatingElement(int[] arr, int n) {
        // Your code here
        HashMap<Integer, Integer> stringIntegerHashMap = new HashMap<>();
        int firstNonRepeatingElement = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (stringIntegerHashMap.containsKey(arr[i])) {
                stringIntegerHashMap.put(arr[i], stringIntegerHashMap.get(arr[i]) + 1);
            } else {
                stringIntegerHashMap.put(arr[i], 1);
            }
        }

        // iterating over the array elements.
        for (int i = 0; i < n; i++) {
            // if frequency of current element in map is equal to 1,
            // then we store the element and break the loop.
            if (stringIntegerHashMap.get(arr[i]) == 1) {
                firstNonRepeatingElement = arr[i];
                break;
            }
        }
        return firstNonRepeatingElement;
    }

    public static ArrayList<Integer> removeDuplicates(int[] arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i : arr) {
            if (hashMap.containsKey(i)) {
                continue;
            }

            hashMap.put(i, true);
            result.add(i);
        }
        System.out.println(result);
        return result;
    }

    public static int mostRepeatedElement(int[] arr) {
        int mostRepeatedElement = arr[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int maxOccurence = 1;
        if (map.size() > 0) {
            Set<Integer> keys = map.keySet();
            for (int key : keys) {
                int keyValue = map.get(key);
                if (keyValue > maxOccurence) {
                    maxOccurence = keyValue;
                    mostRepeatedElement = key;
                }
            }
        }
        return mostRepeatedElement;
    }

    public static ArrayList<Integer> getIntersection(int[] a1, int[] a2) {
        ArrayList<Integer> interSection = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // Add a1's elements to Hashmap
        for(int i : a1) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }

        // Add a2's elements to Hashmap
        for(int i : a2) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }

        /*// new hashmap, to keep track how many times it should be there in intersection
        // HashMap<Integer, Integer> occurenceMap = new HashMap<>();*/
        if (hashMap.size() > 0) {
            Set<Integer> keys = hashMap.keySet();
            for(int key: keys) {
                int value = hashMap.get(key);
                value = (value > 1) ? value/2 : 0;
                hashMap.put(key, value);
                value = hashMap.get(key);

                for (int i =0; i < value; i++) {
                    interSection.add(key);
                }

                /*if (value > 1) {
                    // Add the key to new hashmap, to keep track how many times it should be there in intersection
                    occurenceMap.put(key, value/2);
                }
                // System.out.print(String.format("(Key: %d, Value: %d)", key, value));*/
            }
        }

        /*if (occurenceMap.size() > 0) {
            Set<Integer> keys = occurenceMap.keySet();
            for(int key: keys) {
                int occurence = occurenceMap.get(key);
                for(int i = 0; i < occurence; i++) {
                    interSection.add(key);
                }
            }
        }*/
        return interSection;
    }
}
