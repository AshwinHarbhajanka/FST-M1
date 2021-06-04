package activities;

public class Car {

	String color;
	String transmission;
	int make, tyres, doors;

	Car() {
		tyres = 4;
		doors = 4;
	}

	public void displayCharacteristics() {
		System.out.println("Color of the Car is " + color);
		System.out.println("Make of the Car is " + make);
		System.out.println("Transmission of the Car is " + transmission);
		System.out.println("Number of tyres of the Car is " + tyres);
		System.out.println("Number of doors of the Car is " + doors);
	}

	public void accelerate() {
		System.out.println("This car is moving forward.");
	}

	public void brake() {
		System.out.println("This car has stopped.");
	}
}
