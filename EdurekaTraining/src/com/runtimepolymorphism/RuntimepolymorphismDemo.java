package com.runtimepolymorphism;

public class RuntimepolymorphismDemo {
    public static void main(String[] args) {
        //class(Car) object(mercedes of type Car) assigned to itself
        Car mercedes = new Car();
        mercedes.move();

        //class(Vehicle) object(new Vehicle()) assigned to itself
        Vehicle vehicle = new Vehicle();
        vehicle.move();

        //Subclass(Car) object(new Car()) being assigned to Superclass(Vehicle)
        vehicle = mercedes;

        /* During compile time the JVM binds the move method of Vehicle class but at runtime it finds that since mercedes
        is an object of Car type which is assigned to Vehicle. Hence, at runtime move() of Car is executed as it is
        overridden in Car */
        vehicle.move();

        mercedes.printClassName();

        Bike ducatti = new Bike();
        ducatti.printNumberOfWheels();

        /*Car subClassCar = (Car) new Vehicle();
        subClassCar.move();*/
        Vehicle baseClassVehicle = new Car();
        baseClassVehicle.move();
    }
}
