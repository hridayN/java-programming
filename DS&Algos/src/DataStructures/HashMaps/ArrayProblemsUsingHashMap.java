package DataStructures.HashMaps;

import DataStructures.Arrays.ArrayProblems;

import java.util.HashMap;
import java.util.Set;

public class ArrayProblemsUsingHashMap {
    public static void main(String[] args) {
        /*int[] arr = {15, 24, 23, 12, 19, 11, 16}; //{3, 7, 2, 1, 9, 8, 41};// {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        ArrayProblems.displayArray(GetLongestConsecutiveSequence(arr.length, arr));*/

        int[] arr = {4, 4, 4, 4};
        int difference = 0;
        System.out.println(String.format("Total Pairs with difference: %d = %d", difference, GetPairsCountForAGivenDifference(arr.length, arr, difference)));
    }

    public static int[] GetLongestConsecutiveSequence(int n, int[] arr) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }

        int maxLength = 1;
        // For each key, check whether it's consecutive element exists in map or not. keep track of the length
        for (int key : hashMap.keySet()) {
            int currentLength = 1, start = key, end = key;
            while (hashMap.containsKey(key + 1)) {
                currentLength++;
                end = key + 1;
                key += 1;
            }
            // System.out.println(String.format("Key: %d, index in original array: %d", key, hashMap.get(key)));
            // System.out.println(String.format("Start: %d, index in original array: %d", start, hashMap.get(start)));

            // Check if current length is more than maxLength.
            // And, start was present at a smaller index than key in original array
            if (currentLength >= maxLength) {
                maxLength = currentLength;
                result[0] = start;
                result[1] = end;
            }
        }
        return result;
    }

    public static int GetPairsCountForAGivenDifference(int n, int[] arr, int difference) {
        int pairsCount = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : arr) {
            hashMap.put(i, 1);
        }
        Set<Integer> keys = hashMap.keySet();
        for(int key : keys) {
            int requiredKey = key - difference;
            if (hashMap.containsKey(requiredKey)) {
                System.out.println(String.format("(%d, %d)", key, requiredKey));
                pairsCount++;
            }
        }

        return pairsCount;
    }

    public static int GetAbsoluteDifference(int a, int b) {
        int absoluteDifference = a - b;
        absoluteDifference = (absoluteDifference >= 0) ? absoluteDifference : b - a;
        return absoluteDifference;
    }
}
