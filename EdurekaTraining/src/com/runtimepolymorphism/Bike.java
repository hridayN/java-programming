package com.runtimepolymorphism;

public class Bike extends Vehicle {
    public int wheels;
    public void printNumberOfWheels() {
        wheels = 2;
        System.out.println(wheels);
        System.out.println(super.wheels);
    }
}
