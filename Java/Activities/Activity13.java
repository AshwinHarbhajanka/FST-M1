package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		Random indexGen = new Random();
		System.out.println("Enter the numbers:\n");
		List<Integer> numbers = new ArrayList<Integer>();
		while(obj.hasNextInt()) {
			numbers.add(obj.nextInt());
		}
		System.out.println(numbers.toString());
		Integer nums[] = numbers.toArray(new Integer[0]);
		int newIndex = indexGen.nextInt(nums.length);
		System.out.println("Value at index "+ newIndex + " is " + nums[newIndex]);
		obj.close();
	}

}
