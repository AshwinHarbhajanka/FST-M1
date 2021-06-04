package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car baleno = new Car();
		baleno.make = 2020;
		baleno.color = "Magma Metallic Grey";
		baleno.transmission = "Manual";
		baleno.displayCharacteristics();
		baleno.accelerate();
		baleno.brake();
	}
}
