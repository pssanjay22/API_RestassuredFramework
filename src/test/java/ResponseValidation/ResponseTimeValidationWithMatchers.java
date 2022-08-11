package ResponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidationWithMatchers {

	@Test
	public void responseTimevalidation() {
		
		baseURI = "http://localhost:8084";
		
		//step 1 : send the request and validate the response
		when().get("/projects")
		  .then().time(Matchers.lessThan(1000l), TimeUnit.MILLISECONDS);
	}
}
