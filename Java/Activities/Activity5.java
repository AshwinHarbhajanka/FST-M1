package activities;

abstract class Book{
	String title;
	abstract public void setTitle(String arg);
	public String getTitle() {
		return title;
	}
}

class MyBook extends Book{

	public void setTitle(String arg) {
		title = arg;
	}
	}

public class Activity5 {

	public static void main(String[] args) {
		
		MyBook newNovel = new MyBook();
		newNovel.setTitle("The Age Of Reason");
		System.out.println(newNovel.getTitle());
	}

}
