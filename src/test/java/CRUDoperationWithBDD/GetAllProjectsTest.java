package CRUDoperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class GetAllProjectsTest {

	@Test
	public void getAllProjectsTest() {
		
		baseURI ="http://localhost";
		port =8084;
		
		//step1: Create the required data
		
		//step2: send the request
		when().get("/projects").then().assertThat().statusCode(200)
		.log().all();
		
		//step3: validate the response
		//ValidatableResponse validate = resp.then();
		//validate.log().all();
	}
}
