package activities;

interface BicycleParts{

	public int gears=0;
	public int currentSpeed=0;
	
}

interface BicycleOperations{
	
	public void applyBrake(int decreament);
	public void speedUp(int increament);
	
}

class Bicycle implements BicycleOperations,BicycleParts{
	
	public int gears;
	public int currentSpeed;
	
	Bicycle(int gears, int currentSpeed){
		this.currentSpeed = currentSpeed;
		this.gears = gears;
	}
	
	public void applyBrake(int decreament) {
		currentSpeed -= decreament;
	}
	
	public void speedUp(int increament) {
		currentSpeed += increament;
	}
	
	public void bicycleDesc(){
		System.out.println("No. of gears: "+gears+"\nSpeed: "+currentSpeed);
	}
}

class MountainBike extends Bicycle{
	
	public int seatHeight;
	
	MountainBike(int gears, int currentSpeed, int seatHeight) {
		super(gears, currentSpeed);
		this.seatHeight = seatHeight;
	}
	
	public void setHeight(int newHeight) {
		seatHeight = newHeight;
	}
	
	public void bicycleDesc(){
		super.bicycleDesc();
		System.out.println("Seat Hieght: " +seatHeight);
	}
}

public class Activity7 {

	public static void main(String[] args) {
		MountainBike mb = new MountainBike(4, 20, 25);
		mb.bicycleDesc();
		mb.setHeight(40);
		mb.speedUp(20);
		mb.applyBrake(10);
		mb.bicycleDesc();
	}

}
