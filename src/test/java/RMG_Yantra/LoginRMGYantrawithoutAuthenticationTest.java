package RMG_Yantra;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginRMGYantrawithoutAuthenticationTest {

	@Test
	public void loginRMGYantrawithoutAuthentication() {
		//step1: Create the required data
		//step2: send the request
		RequestSpecification req = RestAssured.given().auth().basic("", "").contentType(ContentType.JSON);
		Response resp = req.get("http://localhost:8084/login");
		
		//step3: validatethe response
		resp.then().log().all();
	}
}
