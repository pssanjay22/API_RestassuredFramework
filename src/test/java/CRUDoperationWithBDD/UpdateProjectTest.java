package CRUDoperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class UpdateProjectTest {

	@Test
	public void updateProjectTest() {
		
		baseURI ="http://localhost";
		port =8084;
		
		//step1: Create the required data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "sanjay");
		jobj.put("projectName", "TYSS");
		jobj.put("status", "On-Going");
		jobj.put("teamSize", 20);
		
		//step2: send the request
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when().put("/projects/TY_PROJ_1209").then().assertThat().statusCode(200)
		.log().all();
		
		//step3: validate the response 
		//resp.then().log().all();
	}
}
