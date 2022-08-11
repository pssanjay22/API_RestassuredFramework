package DifferentWaysToPOST;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithHashMap {

	@Test
	public void createProjectTest() {
		

		baseURI ="http://localhost";
		port =8084;
		
		Random r=new Random();
		int ran = r.nextInt(2000);
		
		//step1 : Create the required data
		HashMap map=new HashMap();
		map.put("createdBy", "sanjay");
		map.put("projectName", "TYSS"+ran);
		map.put("status", "created");
		map.put("teamSize", 12);
		
		//step2 : send the request and validate the response
		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
}
