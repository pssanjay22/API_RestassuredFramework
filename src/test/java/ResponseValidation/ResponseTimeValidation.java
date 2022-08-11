package ResponseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ResponseTimeValidation {
	
	@Test
	public void responseTimeValidation() {
		
		baseURI = "http://localhost:8084";
		long expTime = 1000;
		
		//step 1 : send the request
		Response resp = when().get("/projects");
		
		//step 2 : capture the response
		long time = resp.getTime();
		if(time<=expTime)
		{
			System.out.println("time validate"+time);
		}
		else {
			System.out.println("time not validate"+time);
		}
	}

}
