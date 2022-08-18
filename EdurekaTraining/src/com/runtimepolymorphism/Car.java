package com.runtimepolymorphism;

public class Car extends Vehicle {
    /*Since we are inheriting Vehicle class, whenever an object of Car is created it would call the parent class(Vehicle class here)
     default constructor also*/
    String className = Car.class.toString();
    private int wheels = 4;
    @Override
    public void move() {
        System.out.println("move() in Car");
    }

    public void printClassName() {
        System.out.println(className);

        //super refers to parent class, i.e., Vehicle here
        System.out.println(super.className);
    }

    public void printNumberOfWheels() {
        System.out.println(wheels);
        System.out.println(super.wheels);
    }
}
