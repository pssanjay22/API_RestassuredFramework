package GenericLibrary;

import io.restassured.response.Response;

/**
 * This class contains rest assured specific resusable methods
 * @author sanjay
 *
 */
public class RestAssuredLibrary {
	/**
	 * This method will get the jsondata through json path from response body
	 * @param response
	 * @param path
	 * @return
	 */
	
	public String getJsonData(Response response, String path)
	{
		String jsonData = response.jsonPath().get(path);
		return jsonData;
	}

}
