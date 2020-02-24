package com.company;

/*
 * VehicleDemo.java
 *
 * A class that illustrates concepts related to inheritance and polymorphism named UsingVehicles.
 *
 * Computer Science 111, Boston University
 * Adapted by Laura Gross and renamed
 */

public class VehicleDemo {
    public static void printFleet(Vehicle[] fleet) {
        // Print each Vehicle in the array.
        // Thanks to dynamic binding, the correct
        // version of the toString() method will
        // be invoked for each vehicle.
        for (int i = 0; i < fleet.length; i++) {
            System.out.println(fleet[i]);
        }
    }

    public static double computeAverageAge(Vehicle[] fleet) {
        int totalAge = 0;

        // We can invoke the getYear() method on each object in the fleet,
        // because they are all subclasses of Vehicle, and the getYear()
        // method is defined in Vehicle.
        for (int i = 0; i < fleet.length; i++) {
            int age = 2006 - fleet[i].getYear();
            totalAge += age;
        }

        double averageAge = (double)totalAge / fleet.length;
        return averageAge;
    }

    public static double computeAverageMileage(Vehicle[] fleet) {
        int totalMileage = 0;

        // We can invoke the getMileage() method on each object in the
        // fleet, because they are all subclasses of Vehicle, and the
        // getMileage() method is defined in Vehicle.
        for (int i = 0; i < fleet.length; i++) {
            totalMileage += fleet[i].getMileage();
        }

        double averageMileage = (double)totalMileage / fleet.length;
        return averageMileage;
    }

    public static void main(String[] args) {
        Vehicle[] fleet = new Vehicle[5];
        fleet[0] = new Automobile("Honda", "Civic", 2005);
        fleet[1] = new Motorcycle("Harley", "Sportster", 2007);

        //
        // In order to call the setIsSleeper() method, we need
        // to use a variable of type TractorTrailer, because
        // the method is defined in that class.
        //
        // We can't do
        //    fleet[2].setIsSleeper();
        // because setIsSleeper() is not defined in Vehicle.
        //
        TractorTrailer t = new TractorTrailer("Mack", "Vision", 2003, 10);
        t.setIsSleeper(true);
        fleet[2] = t;

        fleet[3] = new Taxi("Ford", "Tempo", 1999, "12345");
        fleet[4] = new Truck("Dodge", "Durango", 2007, 4);

        printFleet(fleet);
        //System.exit(0);

        double averageAge = computeAverageAge(fleet);
        System.out.println("\naverage age = " + averageAge);

        // We can use the array elements when calling
        // setMileage(), because that method is defined
        // in the Vehicle class.
        fleet[0].setMileage(120000);
        fleet[1].setMileage(65000);
        fleet[2].setMileage(83125);
        fleet[3].setMileage(220000);
        fleet[4].setMileage(15000);
        double averageMileage = computeAverageMileage(fleet);
        System.out.println("average mileage = " + averageMileage);
        System.out.println();

        // To call the getNumAxles() method on the two
        // trucks in the fleet, we need to use casting,
        // because that method is defined in the Truck class.
        // Thanks to dynamic binding, the correct version of
        // getNumAxles() will be called.
        Truck mackTruck = (Truck)fleet[2];
        Truck durango = (Truck)fleet[4];
        System.out.println("The " + mackTruck.getMake() + " has " +
                mackTruck.getNumWheels() + " wheels and " +
                mackTruck.getNumAxles() + " axles.");
        System.out.println("The " + durango.getMake() + " has " +
                durango.getNumWheels() + " wheels and " +
                durango.getNumAxles() + " axles.");


        System.out.println(fleet[2]);
        Truck tr = (Truck)fleet[2];
        System.out.println(tr.getNumAxles());

        TractorTrailer big = (TractorTrailer) fleet[2];
        System.out.println(big.getNumAxles());
    }
}

