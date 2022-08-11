package DifferentWaysToPOST;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectWithFormParameter {

	@Test
	public void createProject() {
		

		baseURI ="http://localhost";
		port =8084;
		
		Random r=new Random();
		int ran = r.nextInt(2000);
		
		//step1 : create the required data
		
		//step2: send the request and validate the response
		given()
		.formParam("createdBy", "sanjay")
		
		.formParam("projectName", "TYSS"+ran)
		.formParam("status", "created")
		.formParam("teamSize", 20)
		
		.contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(500).log().all();
	}
}

