package Puzzles;

import Basics.Strings;

import java.time.Clock;
import java.util.Stack;

public class Puzzles {
    public static void main(String[] args) {
        // getClockAngle("00:30");
        // String str = "{}]";
        //System.out.println(String.format("%s is valid: %b", str, isInputBracesStringValid(str)));
        /*//int num = 4, power = 3;
        // System.out.println(String.format("(%d^%d): %d", num, power, getRaisedToPower(num, power)));*/
        /*int binary = 0;
        System.out.println(String.format("%d's decimal: %d", binary, getDecimalFromBinary(binary)));*/
        int decimal = 15;
        System.out.println(String.format("%d's binary: %d", decimal, getBinaryFromDecimal(decimal)));
    }

    /*Clock Angle Problem: Given time in hh:mm format in 24-hour notation, calculate the shorter angle between
    the hour and minute hand in an analog clock.
    For example,
    Input:  5:30
    Output: 15°*/
    public static void getClockAngle(String time) {
        int hh = Integer.parseInt(time.split(":")[0]);
        int mm = Integer.parseInt(time.split(":")[1]);
        int angle = mm * 6 - (hh * 30 + (mm / 2));
        System.out.print(String.format("Angle b/w hour and minute hand at %d:%d, is: %d degree(s)", hh, mm, angle));
    }

    /*
    * Given a string of braces, determine whether the braces are closed in appropriate order or not*/
    public static boolean isInputBracesStringValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else {
                    char top = stack.peek();
                    if ((c == ')' && top == '(') ||
                            (c == '}' && top == '{') ||
                            (c == ']' && top == '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static int getBinaryFromDecimal(int decimal) {
        String binary = "";
        while (decimal > 1) {
            int remainder = decimal % 2;
            binary = binary.concat(remainder + "");
            decimal /= 2;
        }
        binary = binary.concat(decimal + "");
        binary = Strings.reverseWord(binary);
        return Integer.parseInt(binary);
    }

    public static int getDecimalFromBinary(int binary) {
        int counter = 0, decimal = 0;
        while(binary > 1) {
            int digit = binary % 10;
            decimal += (digit * getRaisedToPower(2, counter));
            binary = binary / 10;
            counter++;
        }
        decimal += getRaisedToPower(2, counter);

        return decimal;
    }

    public static int getRaisedToPower(int n, int power) {
        // 2^ 3, output = 8
        if (power == 0) return 1;
        int product = 1, count = 1;
        while (count <= power) {
            product = product * n;
            count++;
        }
        return product;
    }
}
