package Strings;

import java.util.ArrayList;
import java.util.List;

public class StringProblems {
    private String result;

    public static void main(String[] args) {
        String str = "ABCCBA";
        // System.out.println(String.format("Is %s Palindrome?: %b", str, isPalindrome(str)));
        // System.out.println(String.format("Output %s after removing duplicate chars from %s", removeDuplicateChars(str), str));
        // System.out.println(String.format("Output %s after reversing %s", reverseString(str), str));
        // System.out.println(String.format("Output %s after reversing %s", reverseString(str), str));
        /*String toFind = "BC";
        int index = findOneStringInOther(str, toFind);
        if (index == -1) {
            System.out.println(String.format("%s not found in %s", toFind, str));
        } else {
            System.out.println(String.format("%s found in %s at index: %d", toFind, str, index));
        }*/
        /*int rotation = 5;
        System.out.println(String.format("%s rotated by %d, result: %s", str, rotation, rotateStringByIndex(str, rotation)));*/
        // findAllRotations(str);
        System.out.println("result: " + isRotatedStringPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        int leftPtr = 0;
        int rightPtr = str.length() - 1;
        while (leftPtr <= rightPtr) {
            if (str.charAt(leftPtr) != str.charAt(rightPtr)) {
                return false;
            }
            leftPtr++;
            rightPtr--;
        }
        return true;
    }

    public static String removeDuplicateChars(String str) {
        String result = "";
        for (int i = 0; i <= str.length() - 1; i++) {
            if (result.indexOf(str.charAt(i)) == -1) {
                result = result.concat(str.charAt(i) + "");
            }
        }
        return result;
    }

    public static String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result = result.concat(str.charAt(i) + "");
        }
        return result;
    }

    public static int findOneStringInOther(String str, String toFind) {
        if (str == null || toFind.length() > str.length()) {
            return -1;
        }
        if (toFind == null || toFind.length() == 0) {
            return -1;
        }
        for (int i = 0; i <= str.length() - toFind.length(); i++) {
            for (int j = 0; j < toFind.length(); j++) {
                if (toFind.charAt(j) != str.charAt(i + j)) {
                    break;
                }
                if (j == toFind.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static List<String> findAllRotations(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= str.length() - 1; i++) {
            // System.out.println(String.format("%dth rotation: %s", i, rotateStringByIndex(str, i)));
            result.add(rotateStringByIndex(str, i));
        }
        return result;
    }

    public static String rotateStringByIndex(String str, int rotation) {
        if (rotation < 0 || rotation > str.length()) {
            return String.format("Please provide rotation-index in range of %d and %d", 0, str.length());
        }
        String result = "";
        for (int i = rotation; i <= str.length()-1; i++) {
            result = result.concat(str.charAt(i) + "");
        }
        for (int i = 0; i <= rotation-1; i++) {
            result = result.concat(str.charAt(i) + "");
        }
        return result;
    }

    public static String isRotatedStringPalindrome(String str) {
        List<String> rotations = findAllRotations(str);
        for (String rotatedString: rotations) {
            if (isPalindrome(rotatedString)) {
                return String.format("%s is a rotated palindrome of %s", rotatedString, str);
            }
        }
        return String.format("there's no rotated palindrome of %s", str);
    }
}
