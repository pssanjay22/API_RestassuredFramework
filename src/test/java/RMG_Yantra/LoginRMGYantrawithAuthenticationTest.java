package RMG_Yantra;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginRMGYantrawithAuthenticationTest {
	
	@Test
	public void loginRMGYantrawithAuthenticationTest() {
		//step1: Create the required data
		//step2: send the requiest
		RequestSpecification rest = RestAssured.given().auth().basic("rmgyantra", "rmgy@9999").contentType(ContentType.JSON);
		Response resp = rest.get("http://localhost:8084/login");
		
		//step3: validate the response
		resp.then().log().all();
	}

}
