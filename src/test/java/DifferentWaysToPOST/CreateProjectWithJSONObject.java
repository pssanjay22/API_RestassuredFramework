package DifferentWaysToPOST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectWithJSONObject {

	@Test
	public void createProjectTest() {
		
		baseURI ="http://localhost";
		port =8084;
		
		Random r=new Random();
		int ran = r.nextInt(2000);
		
		//step1: create the required data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "sanjay");
		jobj.put("projectName", "TYSS"+ran);
		jobj.put("status", "created");
		jobj.put("teamSize", 12);
		
		//step2: send the request and validate the response
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
}
