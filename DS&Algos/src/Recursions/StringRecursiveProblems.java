package Recursions;

public class StringRecursiveProblems {
    public static void main(String[] args) {
        //String str = "axcdxxads";
        // char charToRemove = 'x';
        // System.out.println(String.format("After removing %c from %s: %s", charToRemove, str, RemoveGivenChar(str, charToRemove)));
        // System.out.println(String.format("%s after removing Consecutive duplicates: %s", str, RemoveConsecutiveDuplicates(str)));
        // System.out.println(String.format("%s after removing duplicates: %s", str, RemoveDuplicates(str)));
        PrintAllSubstrings("co");
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
        String result =  RemoveDuplicates_Logic(str.substring(1));
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
    /*REGION ENDS*/
}
