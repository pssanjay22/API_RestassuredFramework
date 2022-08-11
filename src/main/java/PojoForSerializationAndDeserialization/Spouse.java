package PojoForSerializationAndDeserialization;

public class Spouse {

	//step1:Declare all the variables as global
	String name;
	int phno;
	String company;
	
	//step2:use constructor to intialize 
	public Spouse(String name, int phno, String company) {
		this.name = name;
		this.phno = phno;
		this.company = company;
	}

	//step3:use getter and setter to access
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhno() {
		return phno;
	}

	public void setPhno(int phno) {
		this.phno = phno;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
}
