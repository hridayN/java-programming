package Basics;

import java.util.Stack;

public class Strings {
    public static void main(String[] args){
        /*StringBuffer();
        StringBuilder();*/
        String str = "SeeS";
        // System.out.println(reverseWord(str));
        //StringBuilderExample();
        System.out.println(String.format("%s is Palindrome: %b", str, isStringPalindrome(str)));
    }

    /*
    * The StringBuilder class provides no guarantee of synchronization whereas the StringBuffer class does
    * StringBuilder is faster than StringBuffer
    * StringBuilder instances are not safe for use by multiple threads
    * */

    public static void StringBuffer() {
        System.out.println("Using StringBuffer:");
        StringBuffer buffer = new StringBuffer();
        System.out.println("Length: " + buffer.length() + ", \nTotal Capacity: " + buffer.capacity() + ", \nReserved capacity: " + (buffer.capacity()-buffer.length()));

        buffer.append("hriday");
        System.out.println("Length: " + buffer.length() + ", \nTotal Capacity: " + buffer.capacity() + ", \nReserved capacity: " + (buffer.capacity()-buffer.length()));

        buffer = new StringBuffer("hriday");
        System.out.println("Length: " + buffer.length() + ", \nTotal Capacity: " + buffer.capacity() + ", \nReserved capacity: " + (buffer.capacity()-buffer.length()));
    }

    public static void StringBuilder(){
        System.out.println("Using StringBuilder:");
        StringBuilder builder = new StringBuilder();
        System.out.println("Length: " + builder.length() + ", \nTotal Capacity: " + builder.capacity() + ", \nReserved capacity: " + (builder.capacity()-builder.length()));

        builder.append("hriday");
        System.out.println("Length: " + builder.length() + ", \nTotal Capacity: " + builder.capacity() + ", \nReserved capacity: " + (builder.capacity()-builder.length()));

        builder = new StringBuilder("hriday");
        System.out.println("Length: " + builder.length() + ", \nTotal Capacity: " + builder.capacity() + ", \nReserved capacity: " + (builder.capacity()-builder.length()));
    }

    public static String reverseWord(String str)
    {
        // Reverse the string str
        String reversedWord = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            reversedWord = reversedWord.concat(str.charAt(i) + "");
        }
        return reversedWord;
    }

    public static void StringBuilderExample() {
        StringBuilder str = new StringBuilder("xhx");
        str.delete(0, 1);
        System.out.print(String.format("str: %s", str));
    }

    public static boolean isStringPalindrome(String str) {
        int leftPtr = 0, rightPtr = str.length()-1;
        while (leftPtr < rightPtr) {
            if (str.charAt(leftPtr) != str.charAt(rightPtr)) return false;
            leftPtr++;
            rightPtr--;
        }
        return true;
    }
    /*public static void reverseStringUsingStack(String str) {
        Stack<char>
    }*/
}
