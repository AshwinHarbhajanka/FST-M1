package activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity2 {

	final static String Root_URI = "https://petstore.swagger.io/v2/user";

	@Test(priority = 1)
	public void addUser() throws IOException {

		FileInputStream inputJSON = new FileInputStream("inputJSON.json");
		String reqBody = new String(inputJSON.readAllBytes());
		Response response = given().contentType(ContentType.JSON).body(reqBody).when().post(Root_URI);
		inputJSON.close();
		response.body().prettyPrint();
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("3597"));
	}

	@Test(priority = 2)
	public void getUser() {

		File outputJSON = new File("outputJSON.json");

		Response response = given().contentType(ContentType.JSON).pathParam("username", "ashwinh").when()
				.get(Root_URI + "/{username}");

		String reqBody = response.body().prettyPrint();

		try {
			outputJSON.createNewFile();
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(reqBody);
			writer.close();

		} catch (IOException e) {
			e.getMessage();
		}

		response.then().body("id", equalTo(3597));
		response.then().body("username", equalTo("ashwinh"));
		response.then().body("firstName", equalTo("Ashwin"));
		response.then().body("lastName", equalTo("H"));
		response.then().body("email", equalTo("ashwinh@gmail.com"));
		response.then().body("password", equalTo("password123"));
		response.then().body("phone", equalTo("9999999999"));
	}

	@Test(priority = 3)
	public void deleteUser() {
		Response response = given().contentType(ContentType.JSON).pathParam("username", "ashwinh").when()
				.delete(Root_URI + "/{username}");
		response.body().prettyPrint();
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("ashwinh"));
	}

}
