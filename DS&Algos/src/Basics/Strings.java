package Basics;

import java.util.Scanner;
import java.util.Stack;

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
        System.out.println(ReverseStringWordWise("Always indent your code"));
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

        return result;
    }
}
