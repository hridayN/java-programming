package com.basics;

public class ClassBasics {
    public static void main(String[] args) {

    }

    /*Method overloading: Same method names, differing only by arguments, irrespective of the return type. STATIC POLYMORPHISM*/
    public static int Add(int number1, int number2) {
        return number1+number2;
    }

    public static int Add(int number1, int number2, int number3) {
        return number1+number2+number3;
    }
}
