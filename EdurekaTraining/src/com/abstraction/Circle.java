package com.abstraction;

/*Since the Circle class inherits an abstract class, either we must declare Circle as abstract as well or it should override the abstract methods of Parent class*/
public class Circle extends Shape {
    //Implementation of method
    @Override
    float area(float radius) {
        return (float)(3.14*radius*radius);
    }
}
