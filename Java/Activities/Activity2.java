package activities;

import java.util.Arrays;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numArr = { 10, 77, 10, 54, -11, 10 };
		System.out.println("Original Array: " + Arrays.toString(numArr));
		int find = 10;
		int sum = 0;
		for (int i = 0; i < numArr.length; i++) {
			if (numArr[i] == find) {
				sum = sum + find;
			}
		}
		System.out.println("Sum of 10s in the array: " + sum);
		Boolean result;
		if (sum == 30)
			result = true;
		else
			result = false;
		System.out.println("Hence " + result);
	}

}
