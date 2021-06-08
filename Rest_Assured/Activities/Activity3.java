package activities;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class Activity3 {

	RequestSpecification reqSpec;
	ResponseSpecification resSpec;

	@Test(priority = 1)
	public void addPets() {

		String reqBody = "{\"id\":77232,\"name\":\"Riley\",\"status\":\"alive\"}";
		Response response = given().spec(reqSpec).body(reqBody).when().post();
		response.body().prettyPrint();
		response.then().spec(resSpec).body("name", equalTo("Riley"));

		reqBody = "{\"id\":77233,\"name\":\"Hansel\",\"status\":\"alive\"}";
		response = given().spec(reqSpec).body(reqBody).when().post();
		response.body().prettyPrint();
		response.then().spec(resSpec).body("name", equalTo("Hansel"));
	}

	@Test(dataProvider = "petInfoProvider", priority = 2)
	public void getPets(int id, String name, String status) {

		Response response = given().spec(reqSpec).pathParam("petId", id).when().get("/{petId}");

		response.body().prettyPrint();

		response.then().spec(resSpec).body("name", equalTo(name));
	}

	@Test(dataProvider = "petInfoProvider", priority = 3)
	public void deletePets(int id, String name, String status) {

		Response response = given().spec(reqSpec).pathParam("petId", id).when().delete("/{petId}");

		response.body().prettyPrint();
		String message = Integer.toString(id);
		response.then().spec(resSpec).body("message",equalTo(message));
	}

	@DataProvider
	public Object[][] petInfoProvider() {
		Object[][] testdata = new Object[][] { { 77232, "Riley", "alive" }, { 77233, "Hansel", "alive" } };
		return testdata;
	}

	@BeforeClass
	public void beforeClass() {
		reqSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setBaseUri("https://petstore.swagger.io/v2/pet").build();

		resSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();

	}

}
