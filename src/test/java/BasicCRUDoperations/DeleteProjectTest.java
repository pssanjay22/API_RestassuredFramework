package BasicCRUDoperations;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {

	@Test
	public void deleteProjectTest() {
		//step1: Create the request data
		
		//step2: send the request
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1002");
		
		//step3: validate the response
		resp.then().log().all();
		long time = resp.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println(time+"ms" );
	}
}
