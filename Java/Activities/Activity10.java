package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {

	public static void main(String[] args) {
		Set<String> hs = new HashSet<String>();
		hs.add("Ashwin");
		hs.add("Ashwin1");
		hs.add("Ashwin2");
		hs.add("Ashwin3");
		hs.add("Ashwin4");
		hs.add("Ashwin5");
		System.out.println(hs);
		System.out.println(hs.size());
		hs.remove("Ashwin");
		hs.remove("Aditya");
		System.out.println(hs.contains("Ashwin"));
		System.out.println("Updated Set:\n"+hs);
	}

}
