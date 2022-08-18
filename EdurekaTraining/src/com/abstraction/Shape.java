package com.abstraction;

public abstract class Shape {
    /*Since we have one(or more) methods/properties as abstract, we need to define the class as abstract as well*/
    abstract float area(float radius);  //Definition of method

    public void displayArea(String shape, float area) {
        System.out.println("Area of " + shape + "is: " + area);
    }
}
