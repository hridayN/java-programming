package Basics;

public class ConstructorConcepts extends NonAbsract {
    /*when an instance of this class is created, the constructor of the the class to which this class is inheriting
    will be instantiated before this class's constructor*/
    ConstructorConcepts() {
     System.out.println("ConstructorConcepts constructor called");
    }
}

abstract class Base {
    Base() {
        System.out.println("Base constructor called");
    }
}

abstract class NonAbsract {
    NonAbsract() {
        System.out.println("NonAbsract constructor called");
    }
}

