package strings;

import java.util.Scanner;

public class StringProblems {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        double d = scanner.nextDouble();
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.print("String: " + s);
        System.out.print("Double: " + d);
        System.out.print("int: " + i);*/

        /*String B = scanner.next();
        performOperations(A, B);*/
        // javaOutputFormatting();
        // printMultiplesAsTable(2);
        // printSeries();
        // printArray(InsertionSort(new int[] { 3, 2, 3, 4, 1 }));

    }

    public static void performOperations(String A, String B) {
        System.out.println(lengthSum(A, B));
    }

    public static int lengthSum(String A, String B) {
        return A.length() + B.length();
    }


}
