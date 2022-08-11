package PojoForSerializationAndDeserialization;

public class EmployeeDetailsWithObject {

	//step1:Declare all the variables as global
	String eName;
	String eId;
	int[] phNo;
	String[] email;
	Object spouse;
	
	//step2:use constructor to intialize 
	public EmployeeDetailsWithObject(String eName, String eId, int[] phNo, String[] email, Object spouse) {
		this.eName = eName;
		this.eId = eId;
		this.phNo = phNo;
		this.email = email;
		this.spouse = spouse;
	}
	
	public EmployeeDetailsWithObject() {
		
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

	public int[] getPhNo() {
		return phNo;
	}

	public void setPhNo(int[] phNo) {
		this.phNo = phNo;
	}

	public String[] getEmail() {
		return email;
	}

	public void setEmail(String[] email) {
		this.email = email;
	}

	public Object getSpouse() {
		return spouse;
	}

	public void setSpouse(Object spouse) {
		this.spouse = spouse;
	}
	
	
	
}
