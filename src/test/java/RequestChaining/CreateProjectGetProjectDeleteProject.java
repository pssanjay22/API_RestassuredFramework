package RequestChaining;

import java.util.Random;

import org.testng.annotations.Test;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectGetProjectDeleteProject {

	@Test
	public void createProjectGetProjectDeleteProject() {
		
		Random r=new Random();
		int ran = r.nextInt(2000);
		
		baseURI ="http://localhost:8084";
		
		//step1 :create the data
		ProjectLibrary pLib=new ProjectLibrary("sanjay", "TYSS"+ran, "created", 15);
		
		//step2 :send the post request
		Response resp = given()
		  .body(pLib)
		  .contentType(ContentType.JSON)
		  
		.when().post("/addProject");
		
		//step3 : capture the project id from the response body using json path
		String  proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		
		//step4 : use the captured project id in GET request
		given()
		  .pathParam("pId", proId)
		 .when()
		  .get("/projects/{pId}")
		  .then().log().all();
		
		//step5 :use the project ID in delete request
		given()
		  .pathParam("pId", proId)
		 .when()
		  .delete("/projects/{pId}").then().assertThat().statusCode(204).log().all();
	}
	
}
