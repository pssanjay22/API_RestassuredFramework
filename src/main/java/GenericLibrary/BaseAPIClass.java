package GenericLibrary;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/**
 * This class is used to connect application
 * @author sanjay
 *
 */
public class BaseAPIClass {

	public DataBaseLibrary dLib=new DataBaseLibrary();
	public JavaLibrary jLib=new JavaLibrary();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();
	
	@BeforeSuite
	public void beforeSuiteConfig() throws SQLException
	{
		dLib.connectToDataBase();
		Reporter.log("====connection successful====", true);
		baseURI = "http://localhost";
		port = 8084;
	}
	
	@AfterSuite
	public void afterSuiteConfig() throws SQLException
	{
		dLib.closeToDataBase();
		Reporter.log("====connection closed====", true);
	}
}
