package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {

	@Test
	public void staticResponseValidation() {
		
		baseURI ="http://localhost";
		port =8084;
		String expData ="TY_PROJ_1202";
		
		//step1 : send the request and validate the response
		Response res = when().get("/projects");
		String actData = res.jsonPath().get("[0].projectId");
		
		System.out.println(actData);
		
		Assert.assertEquals(expData, actData);
	}
}
