package CRUDoperationWithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class CreateProjectTest {
	
	@Test
	public void createProjectTest() {
		
		//create a random number
		Random ran=new Random();
		int random = ran.nextInt(2000);
		
		baseURI ="http://localhost";
		port =8084;
		
		//step 1: Create the required data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Sanjay");
		jobj.put("projectName", "TYSS"+random);
		jobj.put("status", "Created");
		jobj.put("teamSize", 20);
		
		//step 2: Send the request and validate response
		given().
		body(jobj)
		.contentType(ContentType.JSON).
		
		when().post("/addProject").then().assertThat().statusCode(201)
		.log().all();
		
		//step 3: Validate the response
		//ValidatableResponse validate = resp.then();
		//validate.log().all();
		
	}
	

}