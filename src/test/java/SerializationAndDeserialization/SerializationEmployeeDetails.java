package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoForSerializationAndDeserialization.EmployeeDetails;

public class SerializationEmployeeDetails {

	@Test
	public void serializeEmpDetailsTest() throws JsonGenerationException, JsonMappingException, IOException {

		//step1:Create object of pojo and provide values

		EmployeeDetails emp=new EmployeeDetails("Sanjay", "TY_143",766555, "sanjay@gamil.com", "Banglore");

		//step2:Create object of object mapper from jackson mapper

		ObjectMapper obj=new ObjectMapper();

		//step3:write data into json file

		obj.writeValue(new File("./EmployeeDetails.json"), emp);

	}
}
