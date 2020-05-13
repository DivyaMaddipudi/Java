package com.project.books;

public class ReadBooks {
	
	private String name;

	
	public ReadBooks(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("ReadBooks [name=%s]", name);
	}
	
	
	

}
