package AuthenticationOperation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthTest {

	@Test
	public void basicAuthTest() {
		
		baseURI ="http://localhost:8084";
		
		//step1: create the data
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		
		//step2: send request and validate response
		.when()
		.get("/login").then().assertThat().statusCode(202).log().all();
	}
	
	@Test
	public void basicPreEmpltiveAuthTest() {
		
		baseURI ="http://localhost:8084";
		
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		
		.when().get("/login").then().log().all();
	}
	
	@Test
	public void digestTest() {
		
		baseURI ="http://localhost:8084";
		
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		
		.when().get("/login").then().log().all();
	}
}
