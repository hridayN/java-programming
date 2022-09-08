package Recursions;

public class IterativeProblems {
    public static void main(String[] args) {
        char c = 'a';
        String str = "abca";
        //System.out.println(String.format("%s", str));
        PrintFirstAndLastOccurenceOfACharInStringIterative(str, 'a');
        //PrintNumbersInReverseIterative(5);
    }

    public static void PrintNumbersInReverseIterative(int n) {
        for (int i = n; i >= 1; i--) {
            System.out.print(i + ", ");
        }
    }

    public static void PrintFirstAndLastOccurenceOfACharInStringIterative(String str, char c) {
        int firstOccurence = -1, lastOccurence = -1;
        for (int i = 0; i <= str.length()-1; i++) {
            if (str.charAt(i) == c) {
                if (firstOccurence == -1) {
                    firstOccurence = i;
                    lastOccurence = i;
                } else {
                    lastOccurence = i;
                }
            }
        }
        System.out.println(String.format("%c occurs firstly at index %d and lastly at index %d in %s", c, firstOccurence, lastOccurence, str));
    }
}
