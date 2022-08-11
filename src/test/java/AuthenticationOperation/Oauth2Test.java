package AuthenticationOperation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Test {

	@Test
	public void oauth2Test() {
		
		baseURI ="http://coop.apps.symfonycasts.com";
		
		//step 1: genrate the access token
		Response resp = given()
		.formParam("client_id", "API application")
		.formParam("client_secret", "1eacdd43574cd5271be94d4a90fde694")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://apiexample.com")
		.formParam("code", "authorization_code")
		
		.when().post("/token");
		
		//step 2: capture the access token using json path
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
			
		//step 3: utilise the access token
		given()
		.auth()
		.oauth2(token)
		.pathParam("USER_ID",3669)
	   .when()
	    .post("/api/{USER_ID}/chickens-feed")
	    .then().log().all();
	}
}
