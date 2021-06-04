package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		
		Map<Integer, String> colours = new HashMap<Integer,String>();
		colours.put(1,"black");
		colours.put(2,"blue");
		colours.put(3,"white");
		colours.put(4,"green");
		colours.put(5,"red");
		System.out.println(colours);
		colours.remove(1);
		System.out.println(colours.containsValue("green"));
		System.out.println(colours.size());
		System.out.println(colours);
	}

}
