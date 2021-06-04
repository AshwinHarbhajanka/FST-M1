package activities;

interface Addable{
	int add(int num1, int num2);
}

public class Activity12{

	public static void main(String[] args) {
		
		Addable ad1 = (a,b) -> (a+b);
		System.out.println(ad1.add(100, 200));
		
		Addable ad2 = (a,b) -> {
			return a+b;
		};
		System.out.println(ad1.add(100, 2));
	}

}
