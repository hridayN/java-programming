package Basics;

import DataStructures.HashMaps.HashMapUtility;
import DataStructures.HashMaps.Map;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import static Utility.UtilityFunctions.printArray;

public class Strings {
    public static void main(String[] args) {
        /*StringBuffer();
        StringBuilder();*/
        // String str = "SeeS";
        // System.out.println(reverseWord(str));
        //StringBuilderExample();
        // System.out.println(String.format("%s is Palindrome: %b", str, isStringPalindrome(str)));
        // str = str.replace('e', '\0');
        // System.out.println(String.format("str: %s, updated: %s", "SeeS", str));
        // System.out.println(String.format("str length: %s, updated length: %s", "SeeS".length(), str.length()));
        // System.out.println(String.format("Last char: %c", str.charAt(str.length() - 1)));
        /*String str = "Coding Ninjas!";
        System.out.println(String.format("No. of words: %d", CountNumberOfWordsInString(str)));*/

        // StringChange();
        // PrintAllSubstrings("abc");
        // System.out.println("abc".substring(0, 3));
        // System.out.println(ReverseStringWordWise("Always indent your code"));
        /*String str1 = "", str2 = "";
        System.out.println(String.format("Is %s a permutation of %s?: %b", str1, str2, IsStringPermutationOfOther(str1, str2)));*/
        /*String str = "aabccbaa";
        char c = 'a';
        System.out.println(String.format("%s after removing %c: %s", str, c, RemoveAllOccurrencesOfAGivenChar(str, c)));*/
        /*String str = "aaabbcddeeeee";
        System.out.println(String.format("%s's Compressed form: %s, length: %d", str, CompressString(str), CompressString(str).length()));
        //System.out.println(String.format("%c", str.charAt(str.length())));*/
        // CheckProduct();
        //System.out.println(String.format("%d", "abc".indexOf("bc")));
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }

    /*
     * The StringBuilder class provides no guarantee of synchronization whereas the StringBuffer class does
     * StringBuilder is faster than StringBuffer
     * StringBuilder instances are not safe for use by multiple threads
     * */
    public static void StringBuffer() {
        System.out.println("Using StringBuffer:");
        StringBuffer buffer = new StringBuffer();
        System.out.println("Length: " + buffer.length() + ", \nTotal Capacity: " + buffer.capacity() + ", \nReserved capacity: " + (buffer.capacity() - buffer.length()));

        buffer.append("hriday");
        System.out.println("Length: " + buffer.length() + ", \nTotal Capacity: " + buffer.capacity() + ", \nReserved capacity: " + (buffer.capacity() - buffer.length()));

        buffer = new StringBuffer("hriday");
        System.out.println("Length: " + buffer.length() + ", \nTotal Capacity: " + buffer.capacity() + ", \nReserved capacity: " + (buffer.capacity() - buffer.length()));
    }

    public static void StringBuilder() {
        System.out.println("Using StringBuilder:");
        StringBuilder builder = new StringBuilder();
        System.out.println("Length: " + builder.length() + ", \nTotal Capacity: " + builder.capacity() + ", \nReserved capacity: " + (builder.capacity() - builder.length()));

        builder.append("hriday");
        System.out.println("Length: " + builder.length() + ", \nTotal Capacity: " + builder.capacity() + ", \nReserved capacity: " + (builder.capacity() - builder.length()));

        builder = new StringBuilder("hriday");
        System.out.println("Length: " + builder.length() + ", \nTotal Capacity: " + builder.capacity() + ", \nReserved capacity: " + (builder.capacity() - builder.length()));
    }

    public static String reverseWord(String str) {
        // Reverse the string str
        String reversedWord = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedWord = reversedWord.concat(str.charAt(i) + "");
        }
        return reversedWord;
    }

    public static void StringBuilderExample() {
        StringBuilder str = new StringBuilder("xhx");
        str.delete(0, 1);
        System.out.print(String.format("str: %s", str));
    }

    public static boolean isStringPalindrome(String str) {
        int leftPtr = 0, rightPtr = str.length() - 1;
        while (leftPtr < rightPtr) {
            if (str.charAt(leftPtr) != str.charAt(rightPtr)) return false;
            leftPtr++;
            rightPtr--;
        }
        return true;
    }

    /*Count the number of Space separated words in  the string
     * Idea: Increase count by 1, everytime a space/ endline is encountered*/
    public static int CountNumberOfWordsInString(String str) {
        int count = 0;
        if (str != null && !str.isEmpty()) {
            Scanner scn = new Scanner(str);
            while (scn.hasNext()) {
                count++;
                scn.next();
            }
            scn.close();
        }
        return count;
    }

    public static void StringChange() {
        String str1 = "abc", str2 = "abc";
        str2 = str2.concat("a");
        System.out.println(String.format("str1: %s, str2: %s", str1, str2));
    }

    public static void PrintAllSubstrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                System.out.println(String.format("(i: %d, j: %d)", i, j));
                // System.out.println(String.format("%s", str.substring(j)));
            }
        }
    }

    public static String ReverseStringWordWise(String str) {
        String result = "";

        Scanner strScanner = new Scanner(str);
        while (strScanner.hasNext()) {
            result = strScanner.next() + " " + result;
        }
        strScanner.close();
        return result;
    }

    /*Is a given string permutation of the other
     * Idea is to add S1's chars to hashmap and then, when we're adding S2's char to hashmap,
     * we check if it's already present in HM, reduce it's frequency by 1
     * At the end if there's any key having non-zero frequency, it indicates both strings are different*/
    public static boolean IsStringPermutationOfOther(String str1, String str2) {
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty() || str1.length() != str2.length())
            return false;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            // Add str1's chars to Hashmap

            // Current character
            char currentChar = str1.charAt(i);

            // Current char frequency in Hashmap
            int currentCharFrequency = 0;

            // Check if current char exists in Hashmap, update it's frequency
            if (hashMap.containsKey(currentChar)) {
                hashMap.put(currentChar, currentCharFrequency + 1);
                currentCharFrequency = hashMap.get(currentChar);
            } else {
                hashMap.put(currentChar, 1);
                currentCharFrequency = 1;
            }

            /*// Now, if current char is also a part of String 2(str2 here), reduce it's frequency from Hashmap by 1
            if (str2.indexOf(currentChar) != -1) {
                hashMap.put(currentChar, currentCharFrequency - 1);
            }*/
        }

        // Add str2's chars to Hashmap
        for (int i = 0; i < str2.length(); i++) {
            char currentChar = str2.charAt(i);
            int currentCharFrequency = 0;
            // Reduce the frequency of char, if it exists in map
            if (hashMap.containsKey(currentChar)) {
                currentCharFrequency = hashMap.get(currentChar);
                hashMap.put(currentChar, currentCharFrequency - 1);
            } else {
                hashMap.put(currentChar, 1);
            }

            // HashMapUtility.AddKeyToHashMap(hashMap, currentChar);
        }

        // Get all keys from Hashmap
        // Check if there's any key whose frequency is not 0, indicating that strings are different
        Set<Character> keySet = hashMap.keySet();
        for (char key : keySet) {
            if (hashMap.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    /*Remove all occurrences of the given character from the String
     * Idea is to add every char to a new string, if it's not equal to removed character*/
    public static String RemoveAllOccurrencesOfAGivenChar(String str, char c) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar != c) {
                result += currentChar;
            }
        }
        return result;
    }

    /*To compress the given String by replacing multiple occurrences of a char with the count, next to that char */
    public static String CompressString(String str) {
        if (str == null || str.isEmpty()) return "";

        String result = str.charAt(0) + "";
        char currentChar = Character.MIN_VALUE, nextChar = Character.MIN_VALUE;
        int charOccurrenceCount = 0;
        for (int i = 0; i < str.length(); i++) {
            currentChar = str.charAt(i);
            boolean isLastChar = (i == str.length() - 1);
            nextChar = (isLastChar) ? Character.MIN_VALUE : str.charAt(i + 1);

            // If current and next chars are equal, increment current char's occurrence count
            if (currentChar == nextChar) {
                charOccurrenceCount++;
            } else {
                // If current char's occurrence count is not 0, increment the count and add it to result. Else,
                // add empty string
                result += (charOccurrenceCount == 0) ? "" : ++charOccurrenceCount;

                // If it's last character we're visitng and, current char's occurrence count is 0, add current char to result
                // else, add next char
                result += (isLastChar && charOccurrenceCount == 0) ? currentChar : nextChar;

                // Reset current char's occurrence count to 0
                charOccurrenceCount = 0;
            }
        }
        return result;
    }

    public static void CheckProduct() {
        char[] a1 = {'a', 'b', 'c'}, a2 = {'d', 'e', 'f'};
        int resultLength = a1.length * a2.length, counter = 0;
        String[] result = new String[resultLength];
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                result[counter] = a1[i] + a2[j] + "";
                counter++;
            }
        }
        // printArray(result);
    }

    public static int isPalindrome(String A) {
        StringBuilder sb = new StringBuilder(A);
        StringBuilder refactoredString = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            // if upper case, convert to lower case
            if (sb.charAt(i) >= 65 && sb.charAt(i) <= 90) {
                refactoredString.append((sb.charAt(i) + "").toLowerCase());
            }
            // if lowercase or numbers
            if ((sb.charAt(i) >= 97 && sb.charAt(i) <= 122) || (sb.charAt(i) >= 48 && sb.charAt(i) <= 57)) {
                refactoredString.append(sb.charAt(i));
            }
        }

        int leftPtr = 0, rightPtr = refactoredString.length() - 1;
        while (leftPtr <= rightPtr) {
            if (refactoredString.charAt(leftPtr) != refactoredString.charAt(rightPtr)) return 0;
            leftPtr++;
            rightPtr--;
        }

        return 1;
    }
}
