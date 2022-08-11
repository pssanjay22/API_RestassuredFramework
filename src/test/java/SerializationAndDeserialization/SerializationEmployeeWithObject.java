package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoForSerializationAndDeserialization.EmployeeDetailsWithObject;
import PojoForSerializationAndDeserialization.Spouse;

public class SerializationEmployeeWithObject {

	//step1:Create object of pojo and provide values

	int[] phNo= {6545866,5464765};
	String[] eMail= {"sanjay@gmail.com","sanjay@ty.com"};

	@Test
	public void serialiseEmpObjectTest() throws JsonGenerationException, JsonMappingException, IOException {

		//step1:Create object of pojo and provide values
		
		Spouse s=new Spouse("ABC", 4546446, "TCS");
		EmployeeDetailsWithObject emp=new EmployeeDetailsWithObject("Sanjay", "TY_1997", phNo, eMail, s);

		//step2:Create object of object mapper from jackson mapper

		ObjectMapper obj=new ObjectMapper();
		
		//step3:write data into json file
		
		obj.writeValue(new File("./EmployeeWithObject.json"), emp);

	}
}
