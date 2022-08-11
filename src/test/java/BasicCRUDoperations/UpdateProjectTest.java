package BasicCRUDoperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {

	@Test
	public void updateProjectTest() {
		//step1: Create the required data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "sanjay");
		jobj.put("projectName", "TYSS");
		jobj.put("status", "On-Going");
		jobj.put("teamSize", 20);
		
		//step2: send the request
		RequestSpecification request = RestAssured.given();
		request.body(jobj);
		request.contentType(ContentType.JSON);
		
		Response resp = request.put("http://localhost:8084/projects/TY_PROJ_1002");
		
		//step3: validate the response 
		resp.then().log().all();
	}
}
