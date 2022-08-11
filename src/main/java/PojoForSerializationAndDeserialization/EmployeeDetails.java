package PojoForSerializationAndDeserialization;

public class EmployeeDetails {

	//step1:Declare all the variables as global
	String eName;
	String eId;
	int phNum;
	String email;
	String address;

	//step2:use constructor to intialize 
	public EmployeeDetails(String eName, String eId, int phNum, String email, String address) {
		this.eName = eName;
		this.eId = eId;
		this.phNum = phNum;
		this.email = email;
		this.address = address;
	}
	
	public EmployeeDetails() {
		
	}

	//step3:use getter and setter to access

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public int getPhNum() {
		return phNum;
	}

	public void setPhNum(int phNum) {
		this.phNum = phNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
