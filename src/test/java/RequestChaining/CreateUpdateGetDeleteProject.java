package RequestChaining;

import java.util.Random;

import org.testng.annotations.Test;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class CreateUpdateGetDeleteProject {

	@Test
	public void createUpdateGetDeleteProject() {

		Random r=new Random();
		int ran = r.nextInt(2000);


		baseURI ="http://localhost:8084";

		//step1 :create the data
		ProjectLibrary pLib=new ProjectLibrary("sanjay", "TYSS"+ran, "created", 20);

		//step2 :send the post request
		Response resp = given()
				.body(pLib)
				.contentType(ContentType.JSON)

				.when().post("/addProject");

		String proId = resp.jsonPath().get("projectId");
		String proName = resp.jsonPath().get("projectName");
		System.out.println(proId);
		System.out.println(proName);

		//step3 :update the project
		ProjectLibrary pLib1=new ProjectLibrary("sanjay", proName, "on-going", 20);
		given()
		.pathParam("pId", proId)
		.body(pLib1)
		.contentType(ContentType.JSON)

		.when()
		.put("/projects/{pId}");

		//step4 :get the project
		given()
		.pathParam("pId", proId)
		.when().get("/projects/{pId}").then().log().all();

		//step5 :delete the project
		given()
		.pathParam("pId", proId)
		.when()
		.delete("/projects/{pId}").then().assertThat().statusCode(204).log().all();
	}
}
