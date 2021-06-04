package activities;

public class Activity3 {

	public static void main(String[] args) {
		
		double seconds = 1000000000;

		double EarthSeconds = 31557600;
		double MercurySeconds = 0.2408467;
		double VenusSeconds = 0.61519726;
		double MarsSeconds = 1.8808158;
		double JupiterSeconds = 11.862615;
		double SaturnSeconds = 29.447498;
		double UranusSeconds = 84.016846;
		double NeptuneSeconds = 164.79132;
        
		System.out.println(seconds/EarthSeconds +" Earth Years");
        System.out.println(seconds/(EarthSeconds*MercurySeconds) +" Mercury Years");
        System.out.println(seconds/(EarthSeconds*VenusSeconds) +" Venus Years");
        System.out.println(seconds/(EarthSeconds*MarsSeconds) +" Mars Years");
        System.out.println(seconds/(EarthSeconds*JupiterSeconds) +" Jupiter Years");
        System.out.println(seconds/(EarthSeconds*SaturnSeconds) +" Saturn Years");
        System.out.println(seconds/(EarthSeconds*UranusSeconds) +" Uranus Years");
        System.out.println(seconds/(EarthSeconds*NeptuneSeconds) +" Neptune Years");
   }
}