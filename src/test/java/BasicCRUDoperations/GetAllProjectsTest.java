package BasicCRUDoperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProjectsTest {

	@Test
	public void getAllProjectsTest() {
		
		//step1: Create the required data
		
		//step2: send the request
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		//step3: validate the response
		ValidatableResponse validate = resp.then();
		validate.log().all();
	}
}
