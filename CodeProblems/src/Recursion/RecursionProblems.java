package Recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionProblems {
    public static void main(String[] args) {
        String str = "ABC";
        // System.out.println(String.format("Is %s Palindrome?: %b", str, isPalindromeRecursive(str, 0, str.length()-1)));
        // System.out.println(String.format("Output %s after removing duplicate chars from %s", removeDuplicateCharsRecusrive(str, 0), str));
        // System.out.println(String.format("Output %s after reversing %s", reverseStringRecursive(str, str.length()-1), str));
        findNonOverlappingSubstringsOfString(str);
    }

    public static boolean isPalindromeRecursive(String str, int start, int end) {
        // base case
        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static String removeDuplicateCharsRecusrive(String str, int index) {
        String result = "";
        if (result.indexOf(str.charAt(index)) == -1) {
            result = result.concat(str.charAt(index) + "");
        }

        // base case
        if (index == str.length() - 1) {
            return result;
        }
        result = removeDuplicateCharsRecusrive(str, index + 1);
        return result;
    }

    public static String reverseStringRecursive(String str, int index) {
        if (index == 0) {
            return str.charAt(index) + "";
        }
        return str.charAt(index) + reverseStringRecursive(str, index - 1);
    }

/*    public static List<String> findAllStringsWithBalancedParenthesis(int length) {
        if (length % 2 != 0) {
            return new ArrayList("Invalid input");

        }
    }*/

    public static String findNonOverlappingSubstringsOfString(String str) {
        if (str.length() == 0) {
            return "";
        }
        String result = "";
        for (int i = 1; i < str.length()-1; i++) {
            result = result.concat(findNonOverlappingSubstringsOfString(str.substring(i, str.length()-1)));
        }
        return result;
    }
}
