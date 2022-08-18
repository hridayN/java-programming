package com.runtimepolymorphism;

public class Vehicle {
    Vehicle() {
        System.out.println(Vehicle.class.toString() + " constructor");
    }
    int wheels = 4;
    String className = Vehicle.class.toString();
    public void move() {
        System.out.println("move() in Vehicle");
    }
}
