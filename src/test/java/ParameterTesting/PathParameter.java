package ParameterTesting;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameter {

	@Test
	public void  pathParmeterTest() {
		
		baseURI = "http://localhost:8084";
		
		//step1 : Create the data
		given()
		   .pathParam("pId", "TY_PROJ_1204")
		   
		//step2 : send the request and validate response
		   .when()
		     .get("/projects/{pId}")
		    .then()
		      .assertThat().statusCode(200).log().all();
	}
}
