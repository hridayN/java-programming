package Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) throws IOException {
        inputUsingScanner();
        inputUsingBufferedReader();
    }

    /*
     * Scanner is slower than BufferedReader as it parses the input
     * BufferedReader synchronous while Scanner is not
     * Scanner has 1kB char buffer as compared to 8kB buffer in BufferedReader
     */

    public static void inputUsingScanner() {
        /*Problem:
        * If nextLine() is called after nextxxx() method, it doesn't read input
        * Solution: make another call of nextLine() berfore your required nextLine()
        * */
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int i = input.nextInt();
        System.out.print("\n You entered: " + i);

        System.out.print("\nEnter a string: ");
        String str1 = input.nextLine();
        String str2 = input.nextLine();
        System.out.println("You entered: " + str2);
        System.out.println("************************");
        input.close();
    }

    public static void inputUsingBufferedReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an integer: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.print("\n You entered: " + i);

        System.out.print("\nEnter a string: ");
        String str = reader.readLine();
        System.out.print("\n You entered: " + str);
    }
}
