package BasicCRUDoperations;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	@Test
	public void createProjectTest() {
		
		//create a random number
		Random ran=new Random();
		int random = ran.nextInt(2000);
		
		//step 1: Create the required data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Sanjay");
		jobj.put("projectName", "TYSS"+random);
		jobj.put("status", "Created");
		jobj.put("teamSize", 20);
		
		//step 2: Send the request
		RequestSpecification request = RestAssured.given();
		request.body(jobj);
		request.contentType(ContentType.JSON);
		
		Response resp = request.post("http://localhost:8084/addProject");
		
		//step 3: Validate the response
		ValidatableResponse validate = resp.then();
		validate.log().all();
		
	}
	

}