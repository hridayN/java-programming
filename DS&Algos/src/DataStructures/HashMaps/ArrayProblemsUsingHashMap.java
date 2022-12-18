package DataStructures.HashMaps;

import DataStructures.Arrays.ArrayProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ArrayProblemsUsingHashMap {
    public static void main(String[] args) {
        /*int[] arr = {15, 24, 23, 12, 19, 11, 16}; //{3, 7, 2, 1, 9, 8, 41};// {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        ArrayProblems.displayArray(GetLongestConsecutiveSequence(arr.length, arr));*/

        /*int[] arr = {4, 4, 4, 4};
        int difference = 0;
        System.out.println(
        String.format("Total Pairs with difference: %d = %d",
        difference, GetPairsCountForAGivenDifference(arr.length, arr, difference)));*/

        int[] a1 = {1, 5, 10, 20, 40, 80}, a2 = {6, 7, 20, 80, 100}, a3 = {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println(GetIntersectionOf3Arrays(a1, a2, a3));
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
        for (int key : keys) {
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

    public static ArrayList<Integer> GetIntersectionOf3Arrays(int[] a1, int[] a2, int[] a3) {
        ArrayList<Integer> intersection = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // Add a1's elements to Hashmap
        AddOrUpdateHashmap(hashMap, a1);

        // Add a2's elements to Hashmap
        AddOrUpdateHashmap(hashMap, a2);

        // Add a3's elements to Hashmap
        AddOrUpdateHashmap(hashMap, a3);

        // Get hashmap keys
        Set<Integer> keySet = hashMap.keySet();
        for (int key : keySet) {
            int keyValue = hashMap.get(key);
            // if (keyValue % 3 == 0) intersection.add(key);
            System.out.println(String.format("(key: %d, Value: %d)", key, keyValue));
        }
        return intersection;
    }

    public static void AddOrUpdateHashmap(HashMap<Integer, Integer> hashMap, int[] arr) {
        for (int i : arr) {
            int elementFrequency = 0;
            if (hashMap.containsKey(i)) {
                elementFrequency = hashMap.get(i);
                hashMap.put(i, elementFrequency + 1);
            } else {
                hashMap.put(i, 1);
            }
        }
    }
}
