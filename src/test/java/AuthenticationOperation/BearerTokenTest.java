package AuthenticationOperation;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {

	@Test
	public void bearerTokenTest() {
		
		//step1: create the pre requisites
		HashMap map=new HashMap();
		map.put("name", "SDET36-Rest-Bearer");
		map.put("description", "api framework");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("https://api.github.com/user/repos")
		.then().log().all();
	}
}
