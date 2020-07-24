package org.divya.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hibusers")
public class Hibusers {

	@Id
	@Column(name = "users_id")
	int usersId;

	@Column(name = "username")
	String username;

	@Column(name = "password")
	String password;

	@Column(name = "first_name")
	String firstName;

	@Column(name = "last_name")
	String lastName;
	
	
	public Hibusers() {

	}

	public Hibusers(String username, String password, String firstName, String lastName) {
		
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Hibusers [usersId=%s, username=%s, password=%s, firstName=%s, lastName=%s]", usersId,
				username, password, firstName, lastName);
	}
	
	

}
