package activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("Apples");
		myList.add("Bananas");
		myList.add("Cactus");
		myList.add("Dragonfruit");
		myList.add("Emu");
		System.out.println("The List is: ");
		for (String s : myList)
			System.out.println(s);
		System.out.println("The third element in the list is: " + myList.get(2));
		System.out.println("Does my list contain Oranges: " + myList.contains("Oranges"));
		System.out.println("Size of my list is: " + myList.size());
		myList.remove("Cactus");
		System.out.println("New size of the list is: " + myList.size());
	}

}
