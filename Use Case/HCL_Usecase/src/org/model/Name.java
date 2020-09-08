package org.model;

public class Name {
	
	public int id;
	public String employeeName;
	

	public Name(int id, String employeeName) {
		super();
		this.id = id;
		this.employeeName = employeeName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Name [id=" + id + ", employeeName=" + employeeName + "]";
	}
	
	

}
