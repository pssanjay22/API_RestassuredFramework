package DataDrivenTesting;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjects {

	@Test(dataProvider = "data")
	public void createProject(String createdBy,String projectName,String status, int teamSize) {
		
		//create random number
		Random r=new Random();
		int ran = r.nextInt(2000);
		
		ProjectLibrary pLib=new ProjectLibrary("sanjay", "TYSS"+ran, "createdBy", 20);
		
		baseURI ="http://localhost:8084";
		
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject").then().log().all();
		
			
	}
	@DataProvider(name="data")
	public Object[][] data()
	{
		Object [][] data=new Object[3][4];
		
		data[0][0] = "sanjay";
		data[0][1] = "Dell";
		data[0][2] = "Completed";
		data[0][3] = 12;
		
		data[1][0] = "Vijay";
		data[1][1] = "HP";
		data[1][2] = "Created";
		data[1][3] = 15;
		
		data[2][0] = "Pavan";
		data[2][1] = "TYSS";
		data[2][2] = "On Going";
		data[2][3] = 20;
		return data;
	}
}
