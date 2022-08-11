package PojoForSerializationAndDeserialization;

public class EmployeeDetailsWithArray {

	//step1:Declare all the variables as global
	String eName;
	String eId;
	int phNo[];
	String eMail[];
	String address;
	
	//step2:use constructor to intialize 
	public EmployeeDetailsWithArray(String eName, String eId, int[] phNo, String[] eMail, String address) {
		this.eName = eName;
		this.eId = eId;
		this.phNo = phNo;
		this.eMail = eMail;
		this.address = address;
	}
	
	public EmployeeDetailsWithArray() {
		
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

	public String[] geteMail() {
		return eMail;
	}

	public void seteMail(String[] eMail) {
		this.eMail = eMail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
