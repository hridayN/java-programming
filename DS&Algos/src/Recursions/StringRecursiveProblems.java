package Recursions;

import static Puzzles.Puzzles.getRaisedToPower;
import static Utility.UtilityFunctions.printArray;

public class StringRecursiveProblems {
    public static void main(String[] args) {
        //String str = "axcdxxads";
        // char charToRemove = 'x';
        // System.out.println(String.format("After removing %c from %s: %s", charToRemove, str, RemoveGivenChar(str, charToRemove)));
        // System.out.println(String.format("%s after removing Consecutive duplicates: %s", str, RemoveConsecutiveDuplicates(str)));
        // System.out.println(String.format("%s after removing duplicates: %s", str, RemoveDuplicates(str)));
        // PrintAllSubstrings("co");
        /*String str = "abcba";
        System.out.println(String.format("Is %s Palindrome?: %b", str, IsStringPalindrome(str)));*/

        /*String str = "xy";
        printArray(GetStringSubsequences(str));*/

        /*int num = 23;
        printArray(GetKeypadCodes(num));*/

        /*String str = "pip";
        System.out.println(String.format("Result: %s", ReplaceStringPartWithGivenString(str, "pi", "3.14")));*/

        String str = "123";
        System.out.println(String.format("Result: %d", ConvertStringToInteger(str)));
    }

    /*Method to remove the given character from the given string */
    public static String RemoveGivenChar(String str, char c) {
        return RemoveGivenChar_Logic(str, c);
    }

    public static String RemoveConsecutiveDuplicates(String str) {
        return RemoveConsecutiveDuplicates_Logic(str);
    }

    public static String RemoveDuplicates(String str) {
        return RemoveDuplicates_Logic(str);
    }

    public static void PrintAllSubstrings(String str) {
        PrintAllSubstrings_Logic(str, 0, str.length());
    }

    public static boolean IsStringPalindrome(String str) {
        return IsStringPalindrome_Logic(str, 0, str.length() - 1);
    }

    /*For a string of n length, there can be 2^length subsequences*/
    public static String[] GetStringSubsequences(String str) {

        // If string is empty, return array having a blank element
        if (str == null || str.isEmpty()) return new String[]{""};

        // Get Substring's subsequences
        String[] subStringSubsequences = GetStringSubsequences(str.substring(1));

        // Now, we need to do 2 things:
        // 1. copy all subsequences of substring into an array and
        // 2. Prefix 0th character of string with every subsequence of substring and add them to the array
        int subStringSubsequencesLength = subStringSubsequences.length;

        // as we need to do things twice, so we're taking 2 times length for new array
        String[] stringSubsequences = new String[2 * subStringSubsequencesLength];
        for (int i = 0; i < subStringSubsequencesLength; i++) {
            // Do 1.
            stringSubsequences[i] = subStringSubsequences[i];

            // Do 2.
            stringSubsequences[i + subStringSubsequencesLength] = str.charAt(0) + subStringSubsequences[i];
        }

        return stringSubsequences;
    }

    /* Get all possible keypad combinations for a given number
     * Total combinations for num 12: (possible combos for 1 * possible combos for 2)  */
    public static String[] GetKeypadCodes(int num) {
        // num is in decimals
        if (num == 0) return new String[]{""};

        // Get keypad codes for smaller sub-number
        String[] subNumberKeyPadCodes = GetKeypadCodes(num / 10);

        // Get current number possible codes
        String[] currentNumCodes = GetCombinationByNumber(num % 10);

        /*Now we need to do below tasks
         * 1. Create a result array of size (currentNumCodes * subNumberKeyPadCodes)
         * 2. For every combination of current number, suffix with every code of sub-number*/

        int keyPadCodesSize = currentNumCodes.length * subNumberKeyPadCodes.length, counter = 0;
        String[] keyPadCodes = new String[keyPadCodesSize];
        for (int i = 0; i < currentNumCodes.length; i++) {
            for (int j = 0; j < subNumberKeyPadCodes.length; j++) {
                keyPadCodes[counter] = subNumberKeyPadCodes[j] + currentNumCodes[i];
                counter++;
            }
        }
        return keyPadCodes;
    }

    public static String ReplaceStringPartWithGivenString(String str, String partToFind, String stringToReplace) {
        if (str.length() == 1) return str;

        if (str.indexOf(partToFind) == 0) str = str.replace(partToFind, stringToReplace);

        return str.charAt(0) + ReplaceStringPartWithGivenString(str.substring(1), partToFind, stringToReplace);
    }

    public static int ConvertStringToInteger(String str) {
        if (str == null || str.isEmpty()) return 0;
        int numericString = str.charAt(0) - '0';
        if (str.length() == 1) return numericString;

        int num = numericString * getRaisedToPower(10, str.length() - 1);
        num += ConvertStringToInteger(str.substring(1));
        return num;
    }


    /*REGION: PRIVATE METHODS STARTS*/

    /*Method to remove the given character from the given string */
    private static String RemoveGivenChar_Logic(String str, char c) {
        if (str == null || str.isEmpty()) return null;

        String result = "";
        char charAt0 = str.charAt(0);
        if (charAt0 != c) result += charAt0 + "";
        String tempResult = RemoveGivenChar_Logic(str.substring(1), c);
        result += (tempResult != null) ? tempResult : result;
        return result;
    }

    private static String RemoveConsecutiveDuplicates_Logic(String str) {
        if (str == null || str.isEmpty() || str.length() == 1) return str;
        char charAt0 = str.charAt(0);
        if (charAt0 == str.charAt(1)) return RemoveConsecutiveDuplicates_Logic(str.substring(1));
        else return charAt0 + RemoveConsecutiveDuplicates_Logic(str.substring(1));
    }

    private static String RemoveDuplicates_Logic(String str) {
        if (str == null || str.isEmpty() || str.length() == 1) return str;
        char charAt0 = str.charAt(0);
        String result = RemoveDuplicates_Logic(str.substring(1));
        if (result != null && !result.isEmpty()) {
            if (result.indexOf(charAt0) == -1) {
                result += charAt0;
            }
        }
        return result;
    }

    private static void PrintAllSubstrings_Logic(String str, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        System.out.println(str.substring(startIndex, endIndex));

        PrintAllSubstrings_Logic(str, startIndex, endIndex - 1);
        PrintAllSubstrings_Logic(str, startIndex + 1, endIndex);
    }

    private static boolean IsStringPalindrome_Logic(String str, int startIndex, int endIndex) {
        // If string is null or empty, it's palindrome
        if (str == null || str.isEmpty()) return true;

        // If start has become greater or equal to end, we're remaining with only one char or empty string. Which is palindrome
        if (startIndex >= endIndex) return true;

        // If first and last chars aren't equal, return false
        if (str.charAt(startIndex) != str.charAt(endIndex)) return false;

        // Reduce string by 1 char from each side(front and end)
        str = str.substring(1, endIndex);

        // Check if substring is Palindrome or not
        return IsStringPalindrome_Logic(str, 0, str.length() - 1);
    }

    private static String[] GetCombinationByNumber(int num) {
        if (num >= 10) {
            return null;
        }

        switch (num) {
            case 1:
                return new String[]{"_"};
            case 2:
                return new String[]{"a", "b", "c"};
            case 3:
                return new String[]{"g", "h", "i"};
            case 4:
                return new String[]{"d", "e", "f"};
            case 5:
                return new String[]{"j", "k", "l"};
            case 6:
                return new String[]{"m", "n", "o"};
            case 7:
                return new String[]{"p", "q", "r", "s"};
            case 8:
                return new String[]{"t", "u", "v"};
            case 9:
                return new String[]{"w", "x", "y", "z"};
            case 0:
                return new String[]{" "};
        }

        return null;
    }
    /*REGION ENDS*/
}
