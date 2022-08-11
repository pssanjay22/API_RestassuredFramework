package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoForSerializationAndDeserialization.EmployeeDetailsWithArray;

public class SerializationEmployeeDetailsWithArray {

	int phNo[]= {4684665,445465465};
	String eMail[]= {"sanjay@gmail.com","sanjay@ty.in"};
	@Test
	public void SerialiseEmpDetailsTest() throws JsonGenerationException, JsonMappingException, IOException {

		//step1:Create object of pojo and provide values
		EmployeeDetailsWithArray emp=new EmployeeDetailsWithArray("Sanjay", "TY_143",phNo,eMail, "Davanagere");

		//step2:Create object of object mapper from jackson mapper
		ObjectMapper obj=new ObjectMapper();

		//step3:write data into json file
		obj.writeValue(new File("./EmpdetailsWithArray.json"), emp);
	}
}
