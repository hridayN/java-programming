package com.basics;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Class2 obj1 = new Class2();
        obj1.sayHello();
        obj1 = new Class2("Hello to all");
        obj1.sayHello();
    }
}

// By default class has public modifier
class Class2 {
    private String str = "";

    //Constructor chaining
    public Class2() {
        // Calling another constructor from current constructor, basically creating chain of the constructors
        // this keyword will search for a constructor which takes a parameter of type string
        this("Hello");
    }

    public Class2(String string) {
        str = string;
    }
    public void sayHello() {
        System.out.println(str);
    }
}
