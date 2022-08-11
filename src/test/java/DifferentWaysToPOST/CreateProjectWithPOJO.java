package DifferentWaysToPOST;

import org.testng.annotations.Test;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectWithPOJO {
	

	@Test
	public void createProject() {

		baseURI ="http://localhost";
		port =8084;
		
		Random r=new Random();
		int ran = r.nextInt(2000);
		
		//step1 : create required data
		ProjectLibrary pLib=new ProjectLibrary("sanjay", "TYSS"+ran, "created", 10);
		
		//step2 : send  the request and validate the response
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
}
