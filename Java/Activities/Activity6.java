package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane{
	
	private List<String> passengers;
	private int maxPassengers;
	private Date lastTimeTookOf;
	private Date lastTimeLanded;
	
	Plane(int numberOfPassesngers){
		this.maxPassengers = numberOfPassesngers;
		this.passengers = new ArrayList<String>();
	}
	
	public void onBoard(String passenger) {
		passengers.add(passenger);
		}
	
	public Date takeOff() {
		lastTimeTookOf = new Date();
		return lastTimeTookOf;
	}
	
	public void land() {
		lastTimeLanded = new Date();
		passengers.clear();
	}
	
	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}
	
	public List<String> getpassengers() {
		return passengers;
	}
}

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		Plane plane = new Plane(10);
		plane.onBoard("A");
		plane.onBoard("B");
		plane.onBoard("C");
		plane.onBoard("D");
		plane.onBoard("E");
		plane.onBoard("F");
		plane.onBoard("G");
		plane.onBoard("H");
		plane.onBoard("I");
		plane.onBoard("J");
		System.out.println(plane.takeOff());
		System.out.println(plane.getpassengers());
		Thread.sleep(5000);
		plane.land();
		System.out.println(plane.getLastTimeLanded());
	}

}
