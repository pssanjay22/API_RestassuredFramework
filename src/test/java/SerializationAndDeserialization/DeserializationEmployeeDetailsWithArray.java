package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoForSerializationAndDeserialization.EmployeeDetailsWithArray;

public class DeserializationEmployeeDetailsWithArray {

	@Test
	public void deserialiseEmpDetalisTest() throws JsonParseException, JsonMappingException, IOException {
		
		//Create object of object mapper -jackson mapper
		ObjectMapper obj=new ObjectMapper();
		
		//read the value from object mapper
		EmployeeDetailsWithArray e2 = obj.readValue(new File(".\\EmpdetailsWithArray.json"), EmployeeDetailsWithArray.class);
		
		//fetch the required value from class
		System.out.println(e2.getAddress());
		System.out.println(e2.geteName());
		System.out.println(e2.getPhNo()[1]);
	}
}
