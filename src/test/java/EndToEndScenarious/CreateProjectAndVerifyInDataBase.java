package EndToEndScenarious;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPointsLibrary;
import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateProjectAndVerifyInDataBase extends BaseAPIClass {

	@Test
	public void createProjectAndVerifyInDataBase() throws SQLException {
		
		//step1: create pre requisties
		ProjectLibrary pLib=new ProjectLibrary("Sanjay", "TYSS"+jLib.getRandomNum(), "created", 15);
		
		//step2: send the request
		Response res = given()
				.body(pLib)
				.contentType(ContentType.JSON)
				.post(EndPointsLibrary.createProject);
		res.then().log().all();

		//step3: capture the project ID
		String expData = rLib.getJsonData(res, "projectId");
		Reporter.log(expData, true);

		//step4: get a project using get request
		given()
		.pathParam("pId", "expData")
		.when()
		.get(EndPointsLibrary.getSingleProject+"{pId}")
		.then().log().all();
		
		//step5: validate the id in database 
		String query = "select * from project;";
		String actualData = dLib.readDataFromDBAndValidate(query, 1, expData);
		
		Assert.assertEquals(expData, actualData);
	}
}
