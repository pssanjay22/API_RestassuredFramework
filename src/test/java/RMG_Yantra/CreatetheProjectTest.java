package RMG_Yantra;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreatetheProjectTest {

	@Test
	public void createtheProject() {
		
		//create random number
		Random r=new Random();
		int ran = r.nextInt(2000);
		
		//step1: Create the required data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "rmg"+ran);
		jobj.put("createdOn", "26/05/2021");
		jobj.put("status", "created");
		jobj.put("teamSize", 10);
		
		//step2: send the requiest
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		
		Response resp = req.post("http://localhost:8084/addProject");
		
		//step3: validate the response
		resp.then().log().all();
	}
}
