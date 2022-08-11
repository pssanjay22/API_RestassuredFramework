package CRUDoperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;



public class DeleteProjectTest {

	@Test
	public void deleteProjectTest() {
		
		baseURI="http://localhost";
		port =8084;
		
		
		//step1: Create the request data
		
		//step2: send the request and validate the response
		when().delete("/projects/TY_PROJ_1209").then().assertThat().statusCode(204)
		.log().all();
		
		//step3: validate the response
		//resp.then().log().all();
		//long time = resp.getTimeIn(TimeUnit.MILLISECONDS);
		//System.out.println(time+"ms" );
	}
}
