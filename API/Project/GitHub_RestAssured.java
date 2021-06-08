package activities;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.BeforeClass;

public class GitHub_RestAssured {

	RequestSpecification reqSpec;
	int id;

	@Test(priority = 1)
	public void addToken() {
		String reqBody = "{\"title\": \"testApiKey\",\"key\":\"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC+aBKWh7CAmFSVgsSpFMgryAbo8WvP/d2t2rOBANasNOJY8VTGG+aPkFUAvORESSP0sxy7M2\"}";
		Response response = given().spec(reqSpec).body(reqBody).when().post("/user/keys");
		response.body().prettyPrint();
		id = response.then().extract().path("id");
		response.then().body("id", equalTo(id));
	}

	@Test(priority = 2)
	public void getToken() {
		Response response = given().spec(reqSpec).pathParam("id", id).when().get("/user/keys/{id}");
		response.then().body("id", equalTo(id));
		response.body().prettyPrint();
	}

	@Test(priority = 3)
	public void deleteToken() {
		Response response = given().spec(reqSpec).pathParam("id", id).when().delete("/user/keys/{id}");
		response = given().spec(reqSpec).when().get("/user/keys");
		response.body().prettyPrint();
	}

	@BeforeClass
	public void beforeClass() {
		reqSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.addHeader("Authorization", "token ghp_QW4HmwUbzO0z")
				.setBaseUri("https://api.github.com").build();
	}

}
