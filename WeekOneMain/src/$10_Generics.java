package src;

import java.util.ArrayList;
import java.util.List;

// TODO: 1. Create two objects of car and truck classes respectively and sets the number of wheels for each
// TODO: 2. Create a list of vehicles objects and add the car and truck objects to the list
public class $10_Generics {
public static void main(String[] args) {
	List<Vehicle> vehicles = new ArrayList<>();

	Car car = new Car(4);
	Truck truck = new Truck(6);

	vehicles.add(car);
	vehicles.add(truck);

	// TODO: 3. Loop over the list and print out the number of wheels for each vehicle
	for (Vehicle vehicle : vehicles) {
		System.out.println("Number of wheels: " + vehicle.getNumberOfWheels());
	}
}
}

// TODO: 4. Implements inheritance by creating subclasses, Car and Truck, that inherit the numberOfWheels variable and the getNumberOfWheels() method from the Vehicle superclass
class Vehicle {

private final int numberOfWheels;


public Vehicle(int numberOfWheels) {
	this.numberOfWheels = numberOfWheels;
}


public int getNumberOfWheels() {
	return numberOfWheels;
}
}

class Car extends Vehicle {
public Car(int numberOfWheels) {
	super(numberOfWheels);
}
}

class Truck extends Vehicle {

public Truck(int numberOfWheels) {
	super(numberOfWheels);
}
}

/* In both cases, the constructors take an integer parameter numberOfWheels, which is passed as an argument to the super() method. The super() method calls the constructor of the superclass (Vehicle), which takes an integer parameter numberOfWheels and assigns it to the numberOfWheels field of the Vehicle class. This way, the Car and Truck classes inherit the numberOfWheels field and the getNumberOfWheels() method from the Vehicle superclass, and can set the number of wheels for each object at the time of creation. */
