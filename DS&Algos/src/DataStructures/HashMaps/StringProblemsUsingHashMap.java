package DataStructures.HashMaps;

import java.util.HashMap;

public class StringProblemsUsingHashMap {
    public static void main(String[] args) {
        // String inputStr = "thisisinput", expectedOutput = "thisnpu";
        // System.out.println(String.format("Original string: %s, After removing duplicates: %s", inputStr, RemoveDuplicates(inputStr)));
        // System.out.println(String.format("Output matches expected Output: %b", (RemoveDuplicates(inputStr)).equals(expectedOutput)));
        String str = "xy";
        System.out.println(String.format("Highest occurring char: %c", GetHighestOccurringChar(str)));
    }

    public static String RemoveDuplicates(String str) {
        String result = "";
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for(int i =0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (!hashMap.containsKey(currentChar)) {
                hashMap.put(currentChar, 1);
                result += currentChar + "";
            }
        }
        return result;
    }

    public static char GetHighestOccurringChar(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int highestOccurringCharFrequency = 0;
        char highestOccurringChar = '\n';
        for (int i =0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            HashMapUtility.AddKeyToHashMap(hashMap, currentChar);
            // highestOccurringCharFrequency = hashMap.get(currentChar);
            int currentCharFrequency = hashMap.get(currentChar);
            if (currentCharFrequency > highestOccurringCharFrequency) {
                highestOccurringCharFrequency = currentCharFrequency;
                highestOccurringChar = currentChar;
            }
        }
        return highestOccurringChar;
    }
}
