package com.abstraction;

public class AbstractionDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        float area = circle.area(7);
        circle.displayArea("Circle", area);
    }
}
