package DataStructures.HashMaps;

import java.util.HashMap;

public class StringProblemsUsingHashMap {
    public static void main(String[] args) {
        String inputStr = "thisisinput", expectedOutput = "thisnpu";
        // System.out.println(String.format("Original string: %s, After removing duplicates: %s", inputStr, RemoveDuplicates(inputStr)));
        System.out.println(String.format("Output matches expected Output: %b", (RemoveDuplicates(inputStr)).equals(expectedOutput)));
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
}
