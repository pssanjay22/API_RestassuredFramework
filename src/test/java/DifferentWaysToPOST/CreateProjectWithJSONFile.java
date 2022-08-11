package DifferentWaysToPOST;

import java.io.File;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithJSONFile {

	@Test
	public void createProject() throws FileNotFoundException {
		
		baseURI = "http://localhost";
		port = 8084;
		
		//step1: create required data
		File file=new File(".\\src\\main\\resources\\requestData.json");
		
		//step2: send the request and validate the response
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
}
