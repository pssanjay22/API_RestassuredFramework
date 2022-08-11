package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoForSerializationAndDeserialization.EmployeeDetailsWithObject;

public class DeserilizationEmployeeWithObject {
	
	@Test
	public void deseriliseEmpDetailsTest() throws JsonParseException, JsonMappingException, IOException {
		
		//Create object of object mapper -jackson mapper
		ObjectMapper obj=new ObjectMapper();
		
		//read the value from object mapper
		EmployeeDetailsWithObject em = obj.readValue(new File(".\\EmployeeWithObject.json"), EmployeeDetailsWithObject.class);
		
		//fetch the required value from class
		System.out.println(em.getSpouse());
		System.out.println(em.getEmail()[1]);
		System.out.println(em.getPhNo()[0]);
	}

}
