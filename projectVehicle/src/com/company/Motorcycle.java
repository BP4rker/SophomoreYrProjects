package com.company;

/*
 * Motorcycle.java
 *
 * A class that represents a motorcycle.  It is a subclass of Vehicle.
 *
 * It inherits all of its fields and methods (except its constructor) from
 * Vehicle.
 *
 * Computer Science 111, Boston University
 */

public class Motorcycle extends Vehicle {
    /*
     * All fields and methods are inherited from Vehicle!
     *
     * Using a separate class still allows us to treat
     * motorcyles as a different class of Vehicle.
     *
     * In addition, the constructor specifies the
     * correct number of wheels for motorcyles.
     */

    public Motorcycle(String make, String model, int year) {
        // invoke the Vehicle constructor to initialize
        // the fields inherited form Vehicle
        super(make, model, year, 2);
    }
}