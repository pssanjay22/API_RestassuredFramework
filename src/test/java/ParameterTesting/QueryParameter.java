package ParameterTesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {

	@Test
	public void queryParamterTest() {
		
		baseURI ="https://reqres.in/";
		//step 1: create pre requistites
		given().queryParam("page", 2)
		
		//step2 : send the request and validate the response
		.when()
		  .get("/api/users")
		  .then().log().all();
	}
}
