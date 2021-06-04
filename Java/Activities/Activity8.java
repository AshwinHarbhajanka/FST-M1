package activities;

class CustomException extends Exception{
	private String message;
	
	CustomException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}

public class Activity8 {

	static void exceptionTest(String str) throws CustomException {
		if(str==null)
			throw new CustomException("String value is null");
		else
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		
		try {
		Activity8.exceptionTest("Will print to console");
		Activity8.exceptionTest(null);
		Activity8.exceptionTest("Won't execute");
		} catch(CustomException e) {
			 System.out.println(e.getMessage());
		}
	}

}
