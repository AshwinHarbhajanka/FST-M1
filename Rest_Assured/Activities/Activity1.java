package activities;

import io.restassured.response.Response;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;

public class Activity1 {

	final static String Root_URI = "https://petstore.swagger.io/v2/pet";

	@Test(priority = 1)
	public void addNewPet() {

		String reqBody = "{\"id\": 77232,\"name\": \"Riley\",\"status\": \"alive\"}";

		Response response = given().contentType(ContentType.JSON).body(reqBody).when().post(Root_URI);

		response.body().prettyPrint();
		response.then().body("id", equalTo(77232));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));

	}

	@Test(priority = 2)
	public void getPetInfo() {

		Response response = given().contentType(ContentType.JSON).when().pathParam("petId", "77232")
				.get(Root_URI + "/{petId}");

		response.body().prettyPrint();
		response.then().body("id", equalTo(77232));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));

	}

	@Test(priority = 3)
	public void deletePet() {

		Response response = given().contentType(ContentType.JSON).when().pathParam("petId", "77232")
				.delete(Root_URI + "/{petId}");

		response.body().prettyPrint();
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("77232"));

		response = given().contentType(ContentType.JSON).when().pathParam("petId", "77232").get(Root_URI + "/{petId}");

		response.body().prettyPrint();
		response.then().body("code", equalTo(1));
		response.then().body("message", equalTo("Pet not found"));

	}

}
