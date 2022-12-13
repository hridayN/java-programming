package Recursions;

import java.util.HashSet;

import static DataStructures.Arrays.ArrayProblems.displayArray;

public class ArrayRecursiveProblems {
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
        /*String str = "23";
        PrintKeypadCombination(str, 0, "");*/
        /*int n = 5;
        System.out.println(String.format("Sum of first %d natural no.s is: %d", n, SumOfNNaturalNumbers(n)));*/
        /*int n = 100, power = 10;
        System.out.println(String.format("(%d^%d) = %.2e", n, power, GetPower(n, power)));*/
        /*int n = 1;
        System.out.println(String.format("No. of digits in %d are %d", n, GetNumberOfDigits(n)));*/
        int[] arr = {1, 3, 6, 3, 9};
        int x = 9;
        // System.out.println(String.format("Is arr sorted?: %b", IsArraySorted(arr)));
        // System.out.println(String.format("Arr elements sum: %d", GetArraySum(arr)));
        // System.out.println(String.format("Is %d present: %b", x, FindXInArray(arr, x)));
        // System.out.println(String.format("Is %d present: %b", x, FindXInArrayWithoutExtraSpace(null, x)));
        // System.out.println(String.format("Is arr sorted?: %b", IsArraySortedWithoutExtraSpace(arr, 0)));
        /*int firstOccurenceIndex = FindFirstOccurenceIndexOfGivenNumber(arr, x);
        String str = (firstOccurenceIndex == -1) ? "%d doesn't exists" : "%d exists at %dth index, firstly";
        System.out.println(String.format(str, x, firstOccurenceIndex));*/

        /*int lastOccurenceIndex = FindLastOccurenceIndexOfGivenNumber(arr, x);
        String str = (lastOccurenceIndex == -1) ? "%d doesn't exists" : "%d exists at %dth index, lastly";
        System.out.println(String.format(str, x, lastOccurenceIndex));*/

        int[] allOccurenceIndexArray = FindAllOccurenceIndexOfGivenNumber(arr, x);
        System.out.println(String.format("%d occurs at following indices: ", x));
        displayArray(allOccurenceIndexArray);
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
        PrintAllSubsequencesOfAString(str, newString + currentChar, counter + 1);

        // If current char will NOT be a part of subsequence
        PrintAllSubsequencesOfAString(str, newString, counter + 1);
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
        PrintOnlyUniqueSubsequencesOfAString(str, newString + currentChar, counter + 1, hashSet);

        // If current char will NOT be a part of subsequence
        PrintOnlyUniqueSubsequencesOfAString(str, newString, counter + 1, hashSet);
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
            PrintKeypadCombination(str, counter + 1, combination + mapping.charAt(i));
        }
    }

    public static int SumOfNNaturalNumbers(int n) {
        if (n == 1) return 1;
        return n + SumOfNNaturalNumbers(n - 1);
    }

    public static float GetPower(int n, int power) {
        if (n == 0) return 0;
        if (n == 1 || power == 0) return 1;
        if (power == 1) return n;

        return n * GetPower(n, power - 1);
    }

    public static int GetNumberOfDigits(int n) {
        if (n < 10) return 1;
        return 1 + GetNumberOfDigits(n/10);
    }

    public static boolean IsArraySorted(int[] arr) {
        if (arr.length <= 1) return true;

        // Create a partial array with all elements but 0th, and check if it's sorted or not
        int[] partialArr = new int[arr.length -1];
        for (int i =1; i < arr.length; i++) partialArr[i-1] = arr[i];

        // Check if partial array is sorted
        boolean isArraySorted = IsArraySorted(partialArr);

        // If n-1 is not sorted, we need not check further
        if (!isArraySorted) return false;

        // If 0th element is less than 1st, arr is sorted
        isArraySorted = (arr[0] <= arr[1]) ? true : false;
        return isArraySorted;
    }

    /*arr: Input array,
    * startIndex: Starting index of array
    * We'll keep arr unchanged, just vary startIndex by increasing it by 1 everytime, till it reaches our last element
    *  */
    public static boolean IsArraySortedWithoutExtraSpace(int[] arr, int startIndex) {
        // If true, indicates there's only 1 element in array. Hence, array is sorted
        if (startIndex >= arr.length - 1) return true;

        // Check if starting element is greater than it's next
        if (arr[startIndex] > arr[startIndex + 1]) return false;

        // We'll keep increasing startIndex, so that check will be performed on arr.size - 1
        return IsArraySortedWithoutExtraSpace(arr, startIndex + 1);
    }

    public static int GetArraySum(int[] arr) {
        // If array is of length 0, return 0
        if (arr.length == 0) {
            return 0;
        }

        // If array is of length 1, return the only element
        if (arr.length == 1) {
            return arr[0];
        }

        // Create a partial array with all elements but 0th
        int[] partialArr = new int[arr.length -1];
        for (int i =1; i < arr.length; i++) partialArr[i-1] = arr[i];

        // Problem is divided into 1st element + (arr-1) element's sum
        return arr[0] + GetArraySum(partialArr);
    }

    /*arr: Input Array
    * x: Value to find in Array */
    public static boolean FindXInArray(int[] arr, int x) {
        if (arr.length == 0) return false;
        if (arr[0] == x) return true;

        // Create a partial array with all elements but 0th
        int[] partialArr = new int[arr.length -1];
        for (int i =1; i < arr.length; i++) partialArr[i-1] = arr[i];

        return FindXInArray(partialArr, x);
    }

    /*Search for a given number in array,  without creating a new array*/
    private static boolean FindXInArrayWithoutExtraSpace(int[] arr, int startIndex, int x) {
        // Check if array is null or empty
        if (arr == null || arr.length == 0) return false;

        // Check if we've reached to end of array, stop searching
        if (startIndex == arr.length) return false;

        // Check if element at current index matches the given number
        if (arr[startIndex] == x) return true;

        return FindXInArrayWithoutExtraSpace(arr, startIndex + 1, x);
    }

    /*User will call this function, as user mustn't be concerned about the stratIndex and all other things*/
    public static boolean FindXInArrayWithoutExtraSpace(int[] arr, int x) {
        return FindXInArrayWithoutExtraSpace(arr, 0, x);
    }

    public static int FindFirstOccurenceIndexOfGivenNumber(int[] arr, int x) {
        return FindFirstOccurenceIndexOfGivenNumber(arr, 0, x);
    }

    private static int FindFirstOccurenceIndexOfGivenNumber(int[] arr, int startIndex, int x) {
        // Check if array is null or empty
        if (arr == null || arr.length == 0 || startIndex == arr.length) return -1;

        // Check if we've reached to end of array, stop searching
        if (arr[startIndex] == x) return startIndex;

        return FindFirstOccurenceIndexOfGivenNumber(arr, startIndex + 1, x);
    }

    public static int FindLastOccurenceIndexOfGivenNumber(int[] arr, int x) {
        return FindLastOccurenceIndexOfGivenNumber(arr, arr.length-1, x);
    }

    /*Idea is to start looking for x, from end*/
    private static int FindLastOccurenceIndexOfGivenNumber(int[] arr, int endIndex, int x) {
        // Check if array is null or empty
        if (arr == null || arr.length == 0 || endIndex == -1) return -1;

        // Check if index at current element matches given number
        if (arr[endIndex] == x) return endIndex;

        return FindLastOccurenceIndexOfGivenNumber(arr, endIndex - 1, x);
    }

    public static int[] FindAllOccurenceIndexOfGivenNumber(int[] arr, int x) {
        int[] resultArr = new int[arr.length];
        for (int i =0; i < resultArr.length; i++) {
            resultArr[i] = -1;
        }
        resultArr = FindAllOccurenceIndexOfGivenNumber(arr, 0, x, resultArr);
        // Get count of non -1's in result array
        int countOfIndexes = 0;
        for(int i : resultArr) {
            if (i != -1) countOfIndexes++;
        }

        int tempArrCounts = (countOfIndexes == 0) ? 1 : countOfIndexes;
        int[] tempArr = new int[tempArrCounts];
        if (tempArrCounts == 1 && countOfIndexes == 0) {
            tempArr[0] = -1;
        } else {
            int tempArrCounter = 0;
            for(int i : resultArr) {
                if (i != -1) {
                    tempArr[tempArrCounter] = i;
                }
                tempArrCounter++;
            }
        }

        return tempArr;
    }

    /*This function returns all indices of given number.
    * idea is if element current index(startIndex) matches the given number, add current index to result array's current index   */
    private static int[] FindAllOccurenceIndexOfGivenNumber(int[] arr, int startIndex, int x, int[] resultArr) {
        // Check if array is null or empty
        if (arr == null || arr.length == 0) return null;

        // Check if we've reached till end of array
        if (startIndex == arr.length - 1) return resultArr;

        // Check if index at current element matches given number
        if (arr[startIndex] == x) resultArr[startIndex] = startIndex;

        return FindAllOccurenceIndexOfGivenNumber(arr, startIndex + 1, x, resultArr);
    }
}
