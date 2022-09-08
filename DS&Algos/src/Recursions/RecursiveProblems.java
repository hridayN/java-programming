package Recursions;

import java.util.HashSet;

public class RecursiveProblems {
    public static String[] keypadMap = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void main(String[] args) {
        //ShiftAllXToEndRecursive(new StringBuilder("xaxxa"));
        //ShiftAllXToEndIterative(new StringBuilder("xxhyxz"));
        //PrintNumbersInReverseRecursive(5);
        // PrintNumbersRecursive(1);
        //int n = 5;
        //System.out.println(String.format("Sum of first %d natural no.s is: %d", n, SumOfNNaturalNumbersBackwards(n)));
        // SumOfNNaturalNumbersForwards(n, 1, 0);
        // System.out.println(String.format("Factorial of %d is: %d", n, Factorial(n)));
        /*int firstTerm = 0, secondTerm = 1;
        System.out.print(firstTerm + ", ");
        System.out.print(secondTerm + ", ");*/
        // PrintFibonacciSequence(firstTerm, secondTerm, n-2);
        //int fibonacciSequenceSum = firstTerm + secondTerm + GetFibonacciSequenceSum(firstTerm, secondTerm, n);
        //System.out.print(fibonacciSequenceSum);
        // System.out.println(PrintXtoPowerN(2, 3));
        //String str = "ada";
        //PrintReverseString(str, str.length()-1);
        //PrintFirstAndLastOccurenceOfACharInStringRecursive(str, 'a', 0, -1, -1);
        //int arr[] = {1, 2, 1, 3};
        //System.out.println(CheckIfArrayIsStrictlySorted(arr, 0));
        //RemoveDuplicatesFromString("abbccd", "", 0);
        //String str = "aaa";
        /*System.out.println(String.format("All subsequences of %s are: ", str));
        PrintAllSubsequencesOfAString("abc", "", 0);*/
        /*HashSet<String> hashSet = new HashSet<>();
        System.out.println(String.format("All unique subsequences of %s are: ", str));
        PrintOnlyUniqueSubsequencesOfAString(str, "", 0, hashSet);*/
        String str = "23";
        PrintKeypadCombination(str, 0, "");
    }

    public static void ShiftAllXToEndRecursive(StringBuilder str) {
        // Create a temp String containing the str value without x
        String stringWithoutX = String.valueOf(str);
        stringWithoutX = stringWithoutX.replaceAll("x", "");

        int xIndex = str.indexOf("x");

        /*Base case: if we're comparing x's index in str with stringWithoutX,
        that means all our xs are already at the end, hence we can end the function
        */
        if (xIndex == stringWithoutX.length()) {
            System.out.print(str);
            return;
        }

        // Delete x from index i and append at end
        if (xIndex != -1) {
            str.delete(xIndex, xIndex + 1);
            str.append('x');
        }

        ShiftAllXToEndRecursive(str);
    }

    public static void PrintNumbersRecursive(int n) {
        System.out.print(n + ", ");
        if (n == 5) {
            return;
        }
        PrintNumbersRecursive(n + 1);
    }

    public static void PrintNumbersInReverseRecursive(int n) {
        System.out.print(n + ", ");
        if (n == 1) {
            return;
        }
        PrintNumbersInReverseRecursive(n - 1);
    }

    public static int SumOfNNaturalNumbersBackwards(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return (n + SumOfNNaturalNumbersBackwards(n - 1));
    }

    public static void SumOfNNaturalNumbersForwards(int n, int counter, int sum) {
        if (counter == n) {
            sum += n;
            System.out.println(String.format("Sum of first %d natural no.s is: %d", n, sum));
            return;
        }
        sum += counter;
        SumOfNNaturalNumbersForwards(n, counter + 1, sum);
    }

    public static int Factorial(int n) {
        System.out.println("Factorial() called for " + n);
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * Factorial(n - 1);
    }

    public static void PrintFibonacciSequence(int a, int b, int n) {
        if (n == 0) return;

        int currentTerm = a + b;
        System.out.print(currentTerm + ", ");
        PrintFibonacciSequence(b, currentTerm, n - 1);
    }

    public static int GetFibonacciSequenceSum(int a, int b, int n) {
        if (n == 0 || n == 1) {
            b += n;
            // System.out.println(b);
            return 1;
        }

        int nextTerm = a + b;
        // System.out.print(currentTerm + ", ");
        return GetFibonacciSequenceSum(b, nextTerm, n - 1);
    }

    public static int PrintXtoPowerN(int x, int n) {
        System.out.println(String.format("Calculating %d^%d", x, n));
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }

        return x * PrintXtoPowerN(x, n - 1);
    }

    public static void PrintReverseString(String str, int position) {
        //System.out.println(String.format("Called %dth time", counter));
        if (position == 0) {
            System.out.print(str.charAt(0));
            return;
        }
        System.out.print(str.charAt(position));
        PrintReverseString(str, position - 1);
    }

    public static void PrintFirstAndLastOccurenceOfACharInStringRecursive(String str, char c, int counter, int firstOccurence, int lastOccurence) {
        if (counter == str.length() - 1) {
            if (str.charAt(counter) == c) {
                if (firstOccurence == -1) {
                    firstOccurence = counter;
                    lastOccurence = counter;
                } else {
                    lastOccurence = counter;
                }
            }
            System.out.println(String.format("%c occurs at firstly at %d and lastly at %d", c, firstOccurence, lastOccurence));
            return;
        }
        /*int arr[] = PerformCheck(str, c, counter, firstOccurence, lastOccurence);
        firstOccurence = arr[0];
        lastOccurence = arr[1];*/
        if (str.charAt(counter) == c) {
            if (firstOccurence == -1) {
                firstOccurence = counter;
                lastOccurence = counter;
            } else {
                lastOccurence = counter;
            }
        }
        PrintFirstAndLastOccurenceOfACharInStringRecursive(str, c, counter + 1, firstOccurence, lastOccurence);
    }

    public static int[] PerformCheck(String str, char c, int position, int firstOccurence, int lastOccurence) {
        int[] arr = {-1, -1};
        if (str.charAt(position) == c) {
            if (firstOccurence == -1) {
                firstOccurence = position;
                lastOccurence = position;
            } else {
                lastOccurence = position;
            }
            arr[0] = firstOccurence;
            arr[1] = lastOccurence;
        }
        return arr;
    }

    public static boolean CheckIfArrayIsStrictlySorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        if (arr[index] < arr[index + 1]) {
            return CheckIfArrayIsStrictlySorted(arr, index + 1);
        } else {
            return false;
        }
    }

    public static void RemoveDuplicatesFromString(String str, String newString, int counter) {
        /*Create a new string, if indexOfCurrentChar of Original is -1 in newString, append it into new string
         * */
        if (counter == str.length()) {
            System.out.println(String.format("%s without duplicates is: %s", str, newString));
            return;
        }
        char currentChar = str.charAt(counter);
        if (newString.indexOf(currentChar) == -1) {
            newString = newString.concat(currentChar + "");
        }
        RemoveDuplicatesFromString(str, newString, counter + 1);
    }

    public static void PrintAllSubsequencesOfAString(String str, String newString, int counter) {
        if (counter == str.length()) {
            System.out.println(String.format("%s", newString));
            return;
        }
        char currentChar = str.charAt(counter);
        // If current char will be a part of subsequence
        PrintAllSubsequencesOfAString(str, newString+currentChar, counter+1);

        // If current char will NOT be a part of subsequence
        PrintAllSubsequencesOfAString(str, newString, counter+1);
    }

    public static void PrintOnlyUniqueSubsequencesOfAString(String str, String newString, int counter, HashSet<String> hashSet) {
        if (counter == str.length()) {
            if (hashSet.contains(newString)) {
                return;
            } else {
                hashSet.add(newString);
                System.out.println(String.format("%s", newString));
                return;
            }
        }
        char currentChar = str.charAt(counter);
        // If current char will be a part of subsequence
        PrintOnlyUniqueSubsequencesOfAString(str, newString+currentChar, counter+1, hashSet);

        // If current char will NOT be a part of subsequence
        PrintOnlyUniqueSubsequencesOfAString(str, newString, counter+1, hashSet);
    }

    /*Print all possible outputs for a combination of keys on the phone keypad*/
    public static void PrintKeypadCombination(String str, int counter, String combination) {
        if (counter == str.length()) {
            System.out.println(combination);
            return;
        }
        char currentChar = str.charAt(counter);
        String mapping = keypadMap[currentChar - '0'];
        for (int i = 0; i < mapping.length(); i++) {
            PrintKeypadCombination(str, counter + 1, combination+mapping.charAt(i));
        }
    }
}
